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
        public void should_ReturnTrue_WhenTwoTrianglesHaveSameArea()  {

            this.firstTriangle = new Triangle()
                    .setName("first")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5);

            this.secondTriangle = new Triangle()
                    .setName("second")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5);

            int result = triangleComparator.compare(firstTriangle, secondTriangle);
            assertTrue(result == 0);
        }

        @Test
        public void should_ReturnTrueWhenIsGreater() {

            this.firstTriangle = new Triangle()
                    .setName("first")
                    .setFirstSide(1.2)
                    .setSecondSide(1.2)
                    .setThirdSide(2.4);

            this.secondTriangle = new Triangle()
                    .setName("second")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5);

            int result = triangleComparator.compare(firstTriangle, secondTriangle);
            assertTrue(result >= 1);
        }

        @Test
        public void shoul_ReturnTrueWhenIsSmaller() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

            this.firstTriangle = new Triangle()
                    .setName("first")
                    .setFirstSide(1.2)
                    .setSecondSide(1.2)
                    .setThirdSide(2.4);

            this.secondTriangle = new Triangle()
                    .setName("second")
                    .setFirstSide(3)
                    .setSecondSide(4)
                    .setThirdSide(5);

            int result = triangleComparator.compare(secondTriangle, firstTriangle);
            assertTrue(result <= -1);
        }
    }
}