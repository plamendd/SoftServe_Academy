package core.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardUtilsTest {

    @Nested
    class ParseIntOrNull{

        @ParameterizedTest
        @ValueSource(strings = {"1","-1","0","2","232","4343","-2323"})
        void should_ReturnInteger_When_Input_Is_Number(String valueOfString){
            //given
            Integer number = Integer.parseInt(valueOfString);
            //when
            boolean expected  = number.equals(BoardUtils.parseIntOrNull(valueOfString));
            //then
            assertTrue(expected);
        }


        @ParameterizedTest
        @ValueSource(strings = {"ewqe","-13eq","0qe","c","ew.,.","","-=+"})
        void should_ReturnNull_When_Input_Is_NotANumber(String valueOfString){

            assertNull(BoardUtils.parseIntOrNull(valueOfString));
        }

    }

}