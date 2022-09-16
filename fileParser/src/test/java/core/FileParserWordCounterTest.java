package core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class FileParserWordCounterTest {
    @Nested
    class FileParsingTests {

        @Test
        void should_ReturnTrue_When_CountsOfWordMatches() {
            //given
            FileParserEngine fileParserEngine = new FileParserEngine();
            String[] args = new String[2];
            args[0] = "/Users/me/softserve/SoftServe_Academy/fileParser/sample.txt";
            args[1] = "tosho";
            //when
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            fileParserEngine.setFileParserStrategy(new FileParserWordCounter());
            fileParserEngine.getFileParserStrategy().fileParsing(args);
            //then
            assertEquals("counts: 2" + System.lineSeparator(), outContent.toString());
        }
    }


}