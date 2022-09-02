package core;

import ui.ConsolePrinter;
import ui.Printer;


import java.util.Scanner;

public class MatrixEngine implements Engine {
    private Scanner reader;
    private Printer printer;

    public MatrixEngine() {
        this.printer = new ConsolePrinter();
        this.reader = new Scanner(System.in);
    }

    @Override
    public void start() {
        printer.printInstructions();
        String input = reader.nextLine();

        while (!"exit".equals(input)) {
            doWork(input);
            printer.printInstructions();
            input = reader.nextLine();
        }
    }

    @Override
    public void doWork(String input) {
        String[] args = input.split("\\s");

        int parametersCount = args.length;
        int requiredParametersCount = 2;

        if (parametersCount != requiredParametersCount) {
            printer.printError();
            return;
        }

        Integer height = parseIntOrNull(args[0]);
        Integer width = parseIntOrNull(args[1]);

        if ((height == null || height <= 0) && (width == null || width <= 0)) {
            printer.printError();
            return;
        }

        printer.printMatrix(height, width);
        return;

    }


    public Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
