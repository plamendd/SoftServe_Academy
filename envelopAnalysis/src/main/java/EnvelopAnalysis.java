import core.Engine;
import core.EnvelopAnalysisEngine;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

public class EnvelopAnalysis {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public EnvelopAnalysis setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public void run() {
        engine.start();
    }

    public static void main(String[] args) {
        EnvelopAnalysis envelopAnalysis = new EnvelopAnalysis();
        envelopAnalysis.setEngine(new EnvelopAnalysisEngine()
                .setPrinter(new ConsolePrinter())
                .setReader(new ConsoleReader(new Scanner(System.in))));

        envelopAnalysis.run();

    }



}
