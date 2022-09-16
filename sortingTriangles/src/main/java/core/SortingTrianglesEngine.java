package core;

import core.utils.SortingTrianglesUtils;
import ui.TriangleSortingPrinter;
import ui.Reader;

import java.util.Arrays;
import java.util.PriorityQueue;


public class SortingTrianglesEngine implements Engine {
    private Reader reader;
    private TriangleSortingPrinter printer;
    private PriorityQueue<Triangle> queue;

    public SortingTrianglesEngine() {
        this.queue = new PriorityQueue<>(10, new TriangleComparator() {
        });
    }

    @Override
    public void start() {
        String input;
        printer.printInstructions();
        do {
            input = reader.readLine();
            doWork(input);
            input = reader.readLine();
        }
        while (("y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)));

        while (!queue.isEmpty()) {
            printer.printResultFromSortingTriangles(queue.poll());
        }
        stop();
    }

    @Override
    public boolean doWork(String input) {
        int parametersCount = 4;

        String[] splitInput = input.split(",");
        if (splitInput.length != parametersCount) {
            printer.printError();
            printer.printInstructions();
            printer.printContinue();
            return false;
        }
        Arrays.stream(splitInput).forEach(String::trim);

        Triangle triangle = new Triangle();
        triangle.setName(splitInput[0]);

        for (int i = 1; i <= 3; i++) {
            if (!validateInput(splitInput[i])) {
                printer.printError();
                printer.printInstructions();
                printer.printContinue();
                return false;
            }
        }

        triangle.setFirstSide(Double.parseDouble(splitInput[1]))
                .setSecondSide(Double.parseDouble(splitInput[2]))
                .setThirdSide(Double.parseDouble(splitInput[3]));

        if (!isValidTriangle(triangle)) {
            printer.printError();
            printer.printInstructions();
            printer.printContinue();
            return false;
        }

        queue.add(triangle);
        printer.printContinue();
        return true;
    }

    @Override
    public void stop() {
        printer.printExit();
    }

    private boolean validateInput(String input) {
        Double sideSize = SortingTrianglesUtils.parseDoubleOrNull(input);
        return (sideSize != null && sideSize > 0);
    }



    //sum of two sides have to be more than third side.
    private boolean isValidTriangle(Triangle triangle) {
        return (triangle.getFirstSide() + triangle.getSecondSide() > triangle.getThirdSide())
                && (triangle.getSecondSide() + triangle.getThirdSide() > triangle.getFirstSide())
                && (triangle.getFirstSide() + triangle.getThirdSide() > triangle.getSecondSide());
    }


    public Reader getReader() {
        return reader;
    }

    public TriangleSortingPrinter getPrinter() {
        return printer;
    }

    public SortingTrianglesEngine setReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    public SortingTrianglesEngine setPrinter(TriangleSortingPrinter printer) {
        this.printer = printer;
        return this;
    }

}
