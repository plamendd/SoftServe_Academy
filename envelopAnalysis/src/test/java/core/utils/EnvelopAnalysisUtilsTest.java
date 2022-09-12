package core.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopAnalysisUtilsTest {

    @Nested
    class ParseDoubleOrNullTests{

        @ParameterizedTest
        @ValueSource(strings = {"1.5","-1.4","0","2.44","232","4343.44","-2323"})
        void should_ReturnDouble_When_Input_Is_CorrectNumber(String valueOfString){
            //given
            Double number = Double.parseDouble(valueOfString);
            //when
            boolean expected  = number.equals(EnvelopAnalysisUtils.parseDoubleOrNull(valueOfString));
            //then
            assertTrue(expected);
        }


        @ParameterizedTest
        @ValueSource(strings = {"ewqe","-13eq","0qe  ret","3 4","ew.,.","","-=+"})
        void should_ReturnNull_When_Input_Is_NotAValidNumber(String valueOfString){

            assertNull(EnvelopAnalysisUtils.parseDoubleOrNull(valueOfString));
        }

    }


}