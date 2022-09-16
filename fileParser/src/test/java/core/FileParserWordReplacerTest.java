package core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileParserWordReplacerTest {
    @Nested
    class FileParsingTests{

        @Test
        void should_ReturnTrue_When_TwoFilesHaveSameContentAndParametersAreThreeValid() throws IOException {
            //given
            FileParserEngine  fileParserEngine = new FileParserEngine();
            String [] args = new String[3];
            args[0] = "/Users/me/softserve/SoftServe_Academy/fileParser/sample.txt";
            args[1] = "gosho";
            args[2] = "tosho";

            //when
            fileParserEngine.setFileParserStrategy(new FileParserWordReplacer());
            fileParserEngine.getFileParserStrategy().fileParsing(args);

            byte[] f1 = Files.readAllBytes(Path.of("/Users/me/softserve/SoftServe_Academy/fileParser/fortest.txt"));
            byte[] f2 = Files.readAllBytes(Path.of("/Users/me/softserve/SoftServe_Academy/fileParser/sample.txt"));

            //then
            assertArrayEquals(f1,f2);
        }

    }
}