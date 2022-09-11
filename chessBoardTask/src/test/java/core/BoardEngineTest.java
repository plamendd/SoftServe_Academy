package core;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ui.ConsolePrinter;
import ui.ConsoleReader;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BoardEngineTest {
    private BoardEngine boardEngine;

    @BeforeEach
    void setUp() {
        this.boardEngine = new BoardEngine();
        boardEngine.setReader(new ConsoleReader(new Scanner(System.in))).setPrinter(new ConsolePrinter());
    }

    @Nested
    class StartTests {

    }

    @Nested
    class DoWorkTests {
        @ParameterizedTest
        @ValueSource(strings = {"1", "1, 2, 3", "4, 4, 4, 4, 4, 4, 4", " "})
        void should_ReturnFalse_When_ParametersCountIsNotTwo(String args) {
            //given
            String[] arguments = args.split("\\s*,\\s*");
            //when
            boolean checkedParametersCount = boardEngine.doWork(arguments);
            //then
            assertFalse(checkedParametersCount);
        }

        @ParameterizedTest(name = "first={0}, second={1}")
        @CsvSource(value = {"89, 2", "95, 5", "110, 12", "34, 34", "1, 1"})
        void should_ReturnTrue_When_ParametersCountIsTwo(String first, String second) {
            //given
            String[] arguments = {first, second};
            //when
            boolean checkedParametersCount = boardEngine.doWork(arguments);
            //then
            assertTrue(checkedParametersCount);
        }

        @ParameterizedTest(name = "first={0}, second={1}")
        @CsvSource(value = {"89, 0", "95, -1", "110, -65", "0, 323242", "-1, -1", "0,0"})
        void should_ReturnFalse_When_ParametersNotInRange(String first, String second) {
            //given
            String [] args = new String[2];
            args[0] = first;
            args[1] = second;
            //when
            boolean isParametersInRange = boardEngine.doWork(args);
            //then
            assertFalse(isParametersInRange);
        }

    }

    @Nested
    class GenerateBoardTests {
        @Test
        void should_ReturnCorrectBoardArray_When_HeightThreeAndWidthOne() {
            //given
            int height = 3;
            int width = 1;
            char[][] expected = {
                    {'*'},
                    {' '},
                    {'*'},
            };
            //when
            char[][] generatedBoard = boardEngine.generateBoard(height, width);
            //then
            assertArrayEquals(expected, generatedBoard);
        }

        @Test
        void should_ReturnCorrectBoardArray_When_HeightAndWidthAreThree() {
            //given
            int height = 3;
            int width = 3;
            char[][] expected = {
                    {'*', ' ', '*'},
                    {' ', '*', ' '},
                    {'*', ' ', '*'},
            };
            //when
            char[][] generatedBoard = boardEngine.generateBoard(height, width);
            //then
            assertArrayEquals(expected, generatedBoard);
        }

        @Test
        void should_ReturnCorrectBoardArray_When_HeightThreeAndWidthTwo() {
            //given
            int height = 3;
            int width = 2;
            char[][] expected = {
                    {'*', ' '},
                    {' ', '*'},
                    {'*', ' '},
            };
            //when
            char[][] generatedBoard = boardEngine.generateBoard(height, width);
            //then
            assertArrayEquals(expected, generatedBoard);
        }

        @Test
        void should_ReturnCorrectBoardArray_When_HeightOneAndWidthOne() {
            //given
            int height = 1;
            int width = 1;
            char[][] expected = {
                    {'*'},

            };
            //when
            char[][] generatedBoard = boardEngine.generateBoard(height, width);
            //then
            assertArrayEquals(expected, generatedBoard);


        }

        @Test
        void should_ReturnCorrectBoardArray_When_HeightZeroAndZero() {
            //given
            int height = 0;
            int width = 0;
            char[][] expected = {};
            //when
            char[][] generatedBoard = boardEngine.generateBoard(height, width);
            //then
            assertArrayEquals(expected, generatedBoard);
        }
    }
}
