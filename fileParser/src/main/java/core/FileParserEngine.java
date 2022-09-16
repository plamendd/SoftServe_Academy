package core;

import ui.Reader;
import ui.FileParserPrinter;



public class FileParserEngine implements Engine {
    private Reader reader;
    private FileParserPrinter printer;
    private FileParserStrategy  fileParserStrategy ;



    @Override
    public void start() {
        printer.printInstructions();
        String input = reader.readLine();
        doWork(input);
        stop();

    }

    @Override
    public boolean doWork(String input) {
        String [] splitInput = input.split("\\s");

        if (splitInput.length < 2 ||  splitInput.length > 3 ){
            printer.printError();
            return false;
        }
        //if parameters  are  two -> Wordcounter mode strategy.
        if (splitInput.length == 2){
            this.setFileParserStrategy(new FileParserWordCounter());
        }

        //if parameters  are  three -> Wordreplacer mode strategy.
        if (splitInput.length == 3){
            this.setFileParserStrategy(new FileParserWordReplacer());
        }
        this.getFileParserStrategy().fileParsing(splitInput);
        return true;
    }

    @Override
    public void stop() {
        printer.printExit();
    }

    public Reader getReader() {
        return reader;
    }

    public FileParserPrinter getPrinter() {
        return printer;
    }

    public FileParserEngine setReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    public FileParserEngine setPrinter(FileParserPrinter printer) {
        this.printer = printer;
        return this;
    }

    public FileParserStrategy getFileParserStrategy() {
        return fileParserStrategy;
    }

    public FileParserEngine setFileParserStrategy(FileParserStrategy fileParserStrategy) {
        this.fileParserStrategy = fileParserStrategy;
        return this;
    }
}
