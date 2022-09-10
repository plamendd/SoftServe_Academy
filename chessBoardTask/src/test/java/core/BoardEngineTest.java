package core;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardEngineTest {
    private BoardEngine boardEngine;

    @BeforeEach
    void setUp() {
        this.boardEngine = new BoardEngine();
    }

    @Nested
    class StartTests {

    }

    @Nested
    class DoWorkTests {

    }

    @Nested
    class CheckParametersCountTests {
        @ParameterizedTest(name = "first={0}, second={1}")
        @CsvSource(value = {"89, 2", "95, 5", "110, 12", "34, 34", "1, 1"})
        void should_ReturnTrue_When_ParametersCountIsTwo(String first, String second) {
            //given
            String[] arguments = {first, second};
            //when
            boolean checkedParametersCount = boardEngine.checkParametersCount(arguments);
            //then
            assertTrue(checkedParametersCount);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1, 2, 3", "4, 4, 4, 4, 4, 4, 4", ""})
        void should_ReturnFalse_When_ParametersCountIsNotTwo(String args) {
            //given
            String[] arguments = args.split("\\s*,\\s*");
            //when
            boolean checkedParametersCount = boardEngine.checkParametersCount(arguments);
            //then
            assertFalse(checkedParametersCount);
        }

    }

    @Nested
    class CheckParametersRangeTests {
        @ParameterizedTest(name = "first={0}, second={1}")
        @CsvSource(value = {"89, 2", "95, 5", "110, 12", "34, 323242", "1, 1"})
        void should_ReturnTrue_When_ParametersInRange(String first, String second) {
            //given
            String one = first;
            String two = second;
            //when
            boolean checkedParametersRange = boardEngine.checkParametersRange(one, two);
            //then
            assertTrue(checkedParametersRange);
        }

        @ParameterizedTest(name = "first={0}, second={1}")
        @CsvSource(value = {"89, 0", "95, -1", "110, -65", "0, 323242", "-1, -1", "0,0"})
        void should_ReturnFalse_When_ParametersNotInRange(String first, String second) {
            //given
            String one = first;
            String two = second;
            //when
            boolean checkedParametersRange = boardEngine.checkParametersRange(one, two);
            //then
            assertFalse(checkedParametersRange);
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
        void should_ReturnCorrectBoardArray_When_HeightAndAreThree() {
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
        void should_ReturnCorrectBoardArray_When_HeightZeroAandZero() {
            //given
            int height = 0;
            int width = 0;

            char[][] expected = {


            };

            //when
            char[][] generatedBoard = boardEngine.generateBoard(height, width);

            //then
            assertArrayEquals(expected, generatedBoard);


        }
    }
}