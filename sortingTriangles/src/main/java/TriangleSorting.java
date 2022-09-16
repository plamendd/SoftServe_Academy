import core.Engine;
import core.SortingTrianglesEngine;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

public class TriangleSorting {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public TriangleSorting setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public void run() {
        engine.start();
    }

    public static void main(String[] args) {
        TriangleSorting triangleSorting = new TriangleSorting();
        triangleSorting.setEngine(new SortingTrianglesEngine()
                .setPrinter(new ConsolePrinter())
                .setReader(new ConsoleReader(new Scanner(System.in))));

        triangleSorting.run();

    }



}
