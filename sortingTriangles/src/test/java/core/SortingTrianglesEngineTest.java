package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SortingTrianglesEngineTest {

    private SortingTrianglesEngine sortingTrianglesEngine;

    @BeforeEach
    void setUp() {
        this.sortingTrianglesEngine = new SortingTrianglesEngine();
        sortingTrianglesEngine
                .setPrinter(new ConsolePrinter())
                .setReader(new ConsoleReader(new Scanner(System.in)));
    }

    @Nested
    class ValidateInputtTests {
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "-0.1", "0", "-2.44", "-232", "-4343.44", "-2323"})
        void should_ReturnFalse_WhenInputIsNullAndInputIsNotMoreThanZero(String valueOfString) {
            assertFalse(sortingTrianglesEngine.validateInput(valueOfString));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1.1", "0.1", "1.23", "2.44", "232", "4343.44", "2323"})
        void should_ReturnTrue_WhenInputIsNotNullAndInputIsMoreThanZero(String valueOfString) {
            assertTrue(sortingTrianglesEngine.validateInput(valueOfString));
        }

    }

    @Nested
    class CalculatedAreaByHeronTests {
        @Test
        void shouldReturnCorrectArea_WhenCorrectSides() {
            assertAll(
                    () -> assertEquals(6, sortingTrianglesEngine.calculateAreaByHeron(3, 4, 5)),
                    () -> assertEquals(5.41, sortingTrianglesEngine.calculateAreaByHeron(3.5, 3.5, 6)),
                    () -> assertEquals(0.95, sortingTrianglesEngine.calculateAreaByHeron(1.4, 1.4, 2.2)),
                    () -> assertEquals(55.50, sortingTrianglesEngine.calculateAreaByHeron(18.3, 16, 7)),
                    () -> assertEquals(3594.67, sortingTrianglesEngine.calculateAreaByHeron(110.18, 238.6, 136))
            );
        }
    }

    @Nested
    class IsValidTriangleTests{
        @ParameterizedTest
        @ValueSource(strings = {"3 4 5", "3.5 3.5 6", "1.4 1.4 2.2", "18.3 16 7", "110.18 238.6 136"})
        void should_ReturnTrueIfTrianglesSidesRatioIsValid(String sides){
            String [] triangleSides = sides.split("\\s+");
            Triangle triangle = new Triangle()
                    .setFirstSide(Double.parseDouble(triangleSides[0]))
                    .setSecondSide(Double.parseDouble(triangleSides[1]))
                    .setThirdSide(Double.parseDouble(triangleSides[2]));

            assertTrue(sortingTrianglesEngine.isValidTriangle(triangle));
        }

        @ParameterizedTest
        @ValueSource(strings = {"3 4 19", "35 3.5 6", "0.1 0.1 2.2", "183 16 7", "110.18 6 136"})
        void should_ReturnFalseIfTrianglesSidesRatioIsInValid(String sides){
            String [] triangleSides = sides.split("\\s+");
            Triangle triangle = new Triangle()
                    .setFirstSide(Double.parseDouble(triangleSides[0]))
                    .setSecondSide(Double.parseDouble(triangleSides[1]))
                    .setThirdSide(Double.parseDouble(triangleSides[2]));

            assertFalse(sortingTrianglesEngine.isValidTriangle(triangle));
        }


    }
}