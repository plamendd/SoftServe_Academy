package core;

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
    class ValidateInputTests {
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "-0.1", "0", "-2.44", "-232", "-4343.44", "-2323"})
        void should_ReturnFalse_WhenInputIsNullAndInputIsNotMoreThanZero(String valueOfString) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("validateInput", String.class );
            method.setAccessible(true);
            assertFalse((Boolean) method.invoke(sortingTrianglesEngine,valueOfString));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1.1", "0.1", "1.23", "2.44", "232", "4343.44", "2323"})
        void should_ReturnTrue_WhenInputIsNotNullAndInputIsMoreThanZero(String valueOfString) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("validateInput", String.class );
            method.setAccessible(true);
            assertTrue((Boolean) method.invoke(sortingTrianglesEngine,valueOfString));
        }

    }

    @Nested
    class CalculatedAreaByHeronTests {
        @Test
        void shouldReturnCorrectArea_WhenCorrectSides() throws NoSuchMethodException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("calculateAreaByHeron", double.class, double.class, double.class );
            method.setAccessible(true);
            assertAll(
                    () -> assertEquals(6.0, method.invoke(sortingTrianglesEngine,3, 4, 5)),
                    () -> assertEquals(5.41, method.invoke(sortingTrianglesEngine,3.5, 3.5, 6)),
                    () -> assertEquals(0.95, method.invoke(sortingTrianglesEngine,1.4, 1.4, 2.2)),
                    () -> assertEquals(55.50, method.invoke(sortingTrianglesEngine,18.3, 16, 7)),
                    () -> assertEquals(3594.67, method.invoke(sortingTrianglesEngine,110.18, 238.6, 136))
            );
        }
    }

    @Nested
    class IsValidTriangleTests{
        @ParameterizedTest
        @ValueSource(strings = {"3 4 5", "3.5 3.5 6", "1.4 1.4 2.2", "18.3 16 7", "110.18 238.6 136"})
        void should_ReturnTrueIfTrianglesSidesRatioIsValid(String sides) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("isValidTriangle", Triangle.class );
            method.setAccessible(true);
            String [] triangleSides = sides.split("\\s+");
            Triangle triangle = new Triangle()
                    .setFirstSide(Double.parseDouble(triangleSides[0]))
                    .setSecondSide(Double.parseDouble(triangleSides[1]))
                    .setThirdSide(Double.parseDouble(triangleSides[2]));

            assertTrue((Boolean) method.invoke(sortingTrianglesEngine, triangle));
        }

        @ParameterizedTest
        @ValueSource(strings = {"3 4 19", "35 3.5 6", "0.1 0.1 2.2", "183 16 7", "110.18 6 136"})
        void should_ReturnFalseIfTrianglesSidesRatioIsInValid(String sides) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("isValidTriangle", Triangle.class );
            method.setAccessible(true);
            String [] triangleSides = sides.split("\\s+");
            Triangle triangle = new Triangle()
                    .setFirstSide(Double.parseDouble(triangleSides[0]))
                    .setSecondSide(Double.parseDouble(triangleSides[1]))
                    .setThirdSide(Double.parseDouble(triangleSides[2]));

            assertFalse((Boolean) method.invoke(sortingTrianglesEngine, triangle));
        }


    }
}