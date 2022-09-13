package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class TriangleComparatorTest {

    @Nested
    class CompareTests {
        private Triangle firstTriangle;
        private Triangle secondTriangle;
        private TriangleComparator triangleComparator;
        private SortingTrianglesEngine sortingTrianglesEngine;


        @BeforeEach
        void setUp() {
            this.triangleComparator = new TriangleComparator();
            this.sortingTrianglesEngine = new SortingTrianglesEngine();
        }


        @Test
        public void should_ReturnTrue_WhenTwoTrianglesHaveSameArea() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("calculateAreaByHeron", double.class, double.class, double.class);
            method.setAccessible(true);
            this.firstTriangle = new Triangle()
                    .setName("first")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5)
                    .setArea((Double) method.invoke(sortingTrianglesEngine, 3, 4, 5));
            this.secondTriangle = new Triangle()
                    .setName("second")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5)
                    .setArea((Double) method.invoke(sortingTrianglesEngine, 3, 4, 5));
            int result = triangleComparator.compare(firstTriangle, secondTriangle);
            assertTrue(result == 0);
        }

        @Test
        public void shoul_ReturnTrueWhenIsGreater() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("calculateAreaByHeron", double.class, double.class, double.class);
            method.setAccessible(true);
            this.firstTriangle = new Triangle()
                    .setName("first")
                    .setFirstSide(1.2)
                    .setSecondSide(1.2)
                    .setThirdSide(2.4)
                    .setArea((Double) method.invoke(sortingTrianglesEngine,1.4, 1.4, 2.2));
            this.secondTriangle = new Triangle()
                    .setName("second")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5)
                    .setArea((Double) method.invoke(sortingTrianglesEngine, 3, 4, 5));
            int result = triangleComparator.compare(firstTriangle, secondTriangle);
            assertTrue(result >= 1);
        }

        @Test
        public void shoul_ReturnTrueWhenIsSmaller() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            Method method = SortingTrianglesEngine.class.getDeclaredMethod("calculateAreaByHeron", double.class, double.class, double.class);
            method.setAccessible(true);
            this.firstTriangle = new Triangle()
                    .setName("first")
                    .setFirstSide(1.2)
                    .setSecondSide(1.2)
                    .setThirdSide(2.4)
                    .setArea((Double) method.invoke(sortingTrianglesEngine,1.4, 1.4, 2.2));
            this.secondTriangle = new Triangle()
                    .setName("second")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5)
                    .setArea((Double) method.invoke(sortingTrianglesEngine, 3, 4, 5));

            int result = triangleComparator.compare(secondTriangle, firstTriangle);
            assertTrue(result <= -1);
        }
    }
}