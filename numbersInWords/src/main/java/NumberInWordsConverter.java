import core.Engine;
import core.NumberInWordsEngine;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

public class NumberInWordsConverter {
    private Engine engine;

    public void run(String[] args) {
        engine.start(args);
    }

    public Engine getEngine() {
        return engine;
    }

    public NumberInWordsConverter setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

}
