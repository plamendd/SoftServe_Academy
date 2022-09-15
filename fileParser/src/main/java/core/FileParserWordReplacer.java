package core;

import core.utils.FileParserUtils;
import ui.ConsolePrinter;
import ui.Printer;

import java.io.*;

public class FileParserWordReplacer implements FileParserStrategy {

    @Override
    public boolean fileParsing(String[] args) {
        Printer printer = new ConsolePrinter();
        String filePath = args[0];
        String wordTobBeReplaced = args[1];
        String newWord = args[2];
        File file = new File(filePath);
        StringBuilder oldContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(file)) {
            String line = reader.readLine();
            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            StringBuilder newContent = FileParserUtils.replaceAll(oldContent, wordTobBeReplaced, newWord);
            writer.write(newContent.toString());
            return true;
        } catch (IOException e) {
            printer.printError();
            printer.printInstructions();
            return false;
        }
    }
}

