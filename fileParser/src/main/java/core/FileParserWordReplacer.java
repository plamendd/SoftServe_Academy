package core;

import core.utils.FileParserUtils;

import java.io.*;

public class FileParserWordReplacer implements FileParserStrategy {

    @Override
    public void fileParsing(String[] args) {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
