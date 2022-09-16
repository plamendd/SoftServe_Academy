package core;

import ui.ConsolePrinter;
import ui.FileParserPrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FileParserWordCounter implements FileParserStrategy {
    private int counter = 0;

    @Override
    /**
     * caunts all matches of word in a file with new given word from arguments
     */
    public boolean fileParsing(String[] args) {
        FileParserPrinter printer = new ConsolePrinter();
        String path = args[0];
        String wordTobeCounted = args[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                String[] wordsInLine = line.split("\\s");
                counter += Arrays.stream(wordsInLine)
                        .filter(word -> word.equals(wordTobeCounted))
                        .count();
                line = reader.readLine();
            }
            printer.printCount(counter);
            return true;
        } catch (IOException e) {
            printer.printError();
            printer.printInstructions();
            return false;
        }
    }
}


