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
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            StringBuilder newContent = FileParserUtils.replaceAll(oldContent,wordTobBeReplaced, newWord);
            writer = new FileWriter(file);
            writer.write(newContent.toString());
            return true;
        } catch (IOException e) {
          //  e.printStackTrace();
            printer.printError();
            printer.printInstructions();
            return false;
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
              //  e.printStackTrace();
                printer.printError();
                printer.printInstructions();
            }
        }
    }


}
