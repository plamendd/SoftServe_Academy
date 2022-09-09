package core;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileParserWordCounter implements FileParserStrategy {
    private int counter = 0;

    @Override
    public void fileParsing(String[] args) {
        BufferedReader reader = null;
        String path = args[0];
        String wordTobeCounted = args[1];
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                String[] wordsInLine = line.split("\\s");

                counter += Arrays.stream(wordsInLine)
                        .filter(word -> word.equals(wordTobeCounted))
                        .count();

                line = reader.readLine();
            }
            System.out.println("counts: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
