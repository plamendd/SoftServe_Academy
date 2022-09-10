import core.NumberInWordsEngine;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NumberInWordsConverter numberInWordConverter = new NumberInWordsConverter();
        numberInWordConverter.setEngine(new NumberInWordsEngine()
                .setPrinter(new ConsolePrinter())
                .setReader(new ConsoleReader(new Scanner(System.in))));

        numberInWordConverter.run(args);
    }
}
