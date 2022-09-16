package core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Nested
    class CalculatedAreaByHeronTests {
        Triangle triangle = new Triangle();

        @Test
        void shouldReturnCorrectArea_WhenCorrectSides() throws NoSuchMethodException {

            assertAll(
                    () -> assertEquals(6.0, triangle.calculateAreaByHeron(3, 4, 5)),
                    () -> assertEquals(5.41, triangle.calculateAreaByHeron(3.5, 3.5, 6)),
                    () -> assertEquals(0.95, triangle.calculateAreaByHeron(1.4, 1.4, 2.2)),
                    () -> assertEquals(55.50, triangle.calculateAreaByHeron(18.3, 16, 7)),
                    () -> assertEquals(3594.67, triangle.calculateAreaByHeron(110.18, 238.6, 136))
            );
        }
    }

}