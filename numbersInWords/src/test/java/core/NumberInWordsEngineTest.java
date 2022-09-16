package core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

class NumberInWordsEngineTest {

    @Nested
    class ConvertNumberToWordsTests {
        NumberInWordsEngine numberInWordsEngine;

        @BeforeEach
        void setUp() {
            numberInWordsEngine = new NumberInWordsEngine()
                    .setPrinter(new ConsolePrinter())
                    .setReader(new ConsoleReader(new Scanner(System.in)));
        }

        @Test
        void should_ReturnTrue_WithValidInput() {
            String number = "126";

            assertTrue(numberInWordsEngine.doWork(number));
        }


        @Test
        void should_ReturnFalseWith_WithInvalidInput() {

            String number = "126 334";

            assertFalse(numberInWordsEngine.doWork(number));
        }

        @Test
        void should_ReturnFalseWith_WithInvalidInputString() {

            String number = "pesho123";

            assertFalse(numberInWordsEngine.doWork(number));
        }


        @Test
        void should_ReturnFalseWith_EmptyInput() {

            String number = "";

            assertFalse(numberInWordsEngine.doWork(number));
        }

        @Test
        void should_ReturnFalseWith_InputOverRangeInput() {

            String number = "1000";

            assertFalse(numberInWordsEngine.doWork(number));
        }


        @Test
        void should_ReturnFalseWith_MinusIntegerInput() {

            String number = "-1";

            assertFalse(numberInWordsEngine.doWork(number));
        }

        @Test
        void should_ReturnTrueWith_ZeroInput() {

            String number = "0";

            assertTrue(numberInWordsEngine.doWork(number));
        }
    }




}