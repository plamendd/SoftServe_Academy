package core;

import core.utils.EnvelopAnalysisUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    class DoWorkTests {
        @ParameterizedTest
        @ValueSource(strings = {"1", "1, 2, 3", "4, 4, 4, 4, 4", " ", "","3.3, 1.3"})
        void should_ReturnFalse_When_ParametersCountInvalid(String args) {
            //given
            String[] arguments = args.split("\\s*,\\s*");
            //when
            boolean checkedParametersCount = envelopAnalysisEngine.doWork(arguments);
            //then
            assertFalse(checkedParametersCount);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1, 4, 5, i", "-, 2, 3, 4", "c, a, b, t", "4f, 3a, 6+, 2.","3.3, 5, `, 1.3","-3, -5, -1, 13", "6.33, 800, 0.1, 0","3.4, 5.7, *, 1.3"})
        void should_ReturnFalse_When_ParametersCountValidAndParametersNot(String args) {
            //given
            String[] arguments = args.split("\\s*,\\s*");
            //when
            boolean checkedParametersCount = envelopAnalysisEngine.doWork(arguments);
            //then
            assertFalse(checkedParametersCount);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1, 4, 5, 5", "1.1, 0.1, 0.2, 0.1", "100, 10000, 100000, 0.1", "1, 5600, 0.01, 18" })
        void should_ReturnTrue_When_ParametersCountValidAndParametersValid(String args) {
            //given
            String[] arguments = args.split("\\s*,\\s*");
            //when
            boolean checkedParametersCount = envelopAnalysisEngine.doWork(arguments);
            //then
            assertTrue(checkedParametersCount);
        }

    }

    @Nested
    class ValidateInputTests {
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "-0.1", "0", "-2.44", "-232", "-4343.44", "-2323"})
        void should_ReturnFalse_WhenInputIsNullAndInputIsNotMoreThanZero(String valueOfString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = EnvelopAnalysisEngine.class.getDeclaredMethod("validateInput", String.class);
            method.setAccessible(true);

            assertFalse((Boolean) method.invoke(envelopAnalysisEngine, valueOfString));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1.1", "0.1", "1.23", "2.44", "232", "4343.44", "2323"})
        void should_ReturnTrue_WhenInputIsNotNullAndInputIsMoreThanZero(String valueOfString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = EnvelopAnalysisEngine.class.getDeclaredMethod("validateInput", String.class);
            method.setAccessible(true);

            assertTrue((Boolean) method.invoke(envelopAnalysisEngine, valueOfString));
        }

    }

    @Nested
    class CheckIfTwoEnvelopPassTests {


        @ParameterizedTest
        @ValueSource(strings = {"1 10 2 20", "1.23 10.54 1.25 10.55", "0.1 10000.22 0.11 10000.23 "})
        void should_ReturnTrueWhenFirstEnvelopIsSmaller(String valuefOfString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = EnvelopAnalysisEngine.class.getDeclaredMethod("checkIfTwoEnvelopsPass", Envelop.class, Envelop.class);
            method.setAccessible(true);

            String[] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertTrue((Boolean) method.invoke(envelopAnalysisEngine, first, second));
        }

        @ParameterizedTest
        @ValueSource(strings = {"2 20 1 10", "1.25 10.55 1.23 10.54 ", "0.11 10000.23 0.1 10000.22 "})
        void should_ReturnTrueWhenSecondEnvelopIsSmaller(String valuefOfString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = EnvelopAnalysisEngine.class.getDeclaredMethod("checkIfTwoEnvelopsPass", Envelop.class, Envelop.class);
            method.setAccessible(true);

            String[] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertTrue((Boolean) method.invoke(envelopAnalysisEngine, first, second));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1 21 2 20", "1.26 10.54 1.25 10.55", "1.26 10.54 1.26 10.54", "0.11 10000.24 0.11 10000.23 "})
        void should_ReturnFalseWhenFirstEnvelopIsNotSmaller(String valuefOfString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = EnvelopAnalysisEngine.class.getDeclaredMethod("checkIfTwoEnvelopsPass", Envelop.class, Envelop.class);
            method.setAccessible(true);

            String[] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertFalse((Boolean) method.invoke(envelopAnalysisEngine, first, second));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1 21 2 19", "1.26 10.54 1.27 10.54", "1.26 10.54 1.26 10.54", "0.11 10000.24 0.10 10000.25 "})
        void should_ReturnFalseWhenSecondEnvelopIsNotSmaller(String valuefOfString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = EnvelopAnalysisEngine.class.getDeclaredMethod("checkIfTwoEnvelopsPass", Envelop.class, Envelop.class);
            method.setAccessible(true);

            String[] args = valuefOfString.split("\\s+");
            Envelop first = new Envelop()
                    .setShorterSide(Double.parseDouble(args[0]))
                    .setLongerSide(Double.parseDouble(args[1]));
            Envelop second = new Envelop()
                    .setShorterSide(Double.parseDouble(args[2]))
                    .setLongerSide(Double.parseDouble(args[3]));

            assertFalse((Boolean) method.invoke(envelopAnalysisEngine, first, second));
        }

    }

}