package core;

import core.utils.EnvelopAnalysisUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopAnalysisEngineTest {

    private EnvelopAnalysisEngine envelopAnalysisEngine;

    @BeforeEach
    void setUp() {
        this.envelopAnalysisEngine = new EnvelopAnalysisEngine();
        this.envelopAnalysisEngine.setReader(new ConsoleReader(new Scanner(System.in)))
                .setPrinter(new ConsolePrinter());
    }

    @Nested
    class ValidateInputTests {
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "-0.1", "0", "-2.44", "-232", "-4343.44", "-2323"})
        void should_ReturnFalse_WhenInputIsNullAndInputIsNotMoreThanZero(String valueOfString) {
            assertFalse(envelopAnalysisEngine.validateInput(valueOfString));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1.1", "0.1", "1.23", "2.44", "232", "4343.44", "2323"})
        void should_ReturnTrue_WhenInputIsNotNullAndInputIsMoreThanZero(String valueOfString) {
            assertTrue(envelopAnalysisEngine.validateInput(valueOfString));
        }

    }

    @Nested
    class CheckIfTwoEnvelopPassTests {


        @ParameterizedTest
        @ValueSource(strings = {"1 10 2 20", "1.23 10.54 1.25 10.55", "0.1 10000.22 0.11 10000.23 "})
        void should_ReturnTrueWhenFirstEnvelopIsSmaller(String valuefOfString) {
            String [] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertTrue(envelopAnalysisEngine.checkIfTwoEnvelopsPass(first,second));
        }

        @ParameterizedTest
        @ValueSource(strings = {"2 20 1 10", "1.25 10.55 1.23 10.54 ", "0.11 10000.23 0.1 10000.22 "})
        void should_ReturnTrueWhenSecondEnvelopIsSmaller(String valuefOfString) {
            String [] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertTrue(envelopAnalysisEngine.checkIfTwoEnvelopsPass(first,second));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1 21 2 20", "1.26 10.54 1.25 10.55", "1.26 10.54 1.26 10.54", "0.11 10000.24 0.11 10000.23 "})
        void should_ReturnFalseWhenFirstEnvelopIsNotSmaller(String valuefOfString) {
            String [] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertFalse(envelopAnalysisEngine.checkIfTwoEnvelopsPass(first,second));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1 21 2 19", "1.26 10.54 1.27 10.54", "1.26 10.54 1.26 10.54", "0.11 10000.24 0.10 10000.25 "})
        void should_ReturnFalseWhenSecondEnvelopIsNotSmaller(String valuefOfString) {
            String [] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertFalse(envelopAnalysisEngine.checkIfTwoEnvelopsPass(first,second));
        }



    }


}