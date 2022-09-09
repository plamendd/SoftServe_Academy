import core.Engine;
import core.FileParserEngine;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

public class FileParser {
    private Engine engine;


    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        fileParser.setEngine(new FileParserEngine()
                .setPrinter(new ConsolePrinter())
                .setReader(new ConsoleReader(new Scanner(System.in))));

        fileParser.run();

    }

    public void run() {
        engine.start();
    }

    public Engine getEngine() {
        return engine;
    }

    public FileParser setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

}
