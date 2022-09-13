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
        input = reader.readLine();
        doWork(input);
        while (!queue.isEmpty()) {
            printer.printResultFromSortingTriangles(queue.poll());
        }
        stop();
    }

    @Override
    public void doWork(String input) {
        int parametersCount = 4;
        while (true) {
            String[] splitInput = input.split(",");
            if (splitInput.length != parametersCount) {
                printer.printError();
                printer.printInstructions();
                return;
            }
            Arrays.stream(splitInput).forEach(String::trim);

            Triangle triangle = new Triangle();
            triangle.setName(splitInput[0]);

            for (int i = 1; i <= 3; i++) {
                if (!validateInput(splitInput[i])) {
                    printer.printError();
                    printer.printInstructions();
                    return;
                }
            }

            triangle.setFirstSide(Double.parseDouble(splitInput[1]))
                    .setSecondSide(Double.parseDouble(splitInput[2]))
                    .setThirdSide(Double.parseDouble(splitInput[3]));

            if (!isValidTriangle(triangle)) {
                printer.printError();
                printer.printInstructions();
                return;
            }

            triangle.setArea(calculateAreaByHeron(triangle.getFirstSide(),
                    triangle.getSecondSide(), triangle.getThirdSide()));

            queue.add(triangle);
            printer.printContinue();
            input = reader.readLine();
            if ("y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)) {
                printer.printInstructions();
                input = reader.readLine();
            } else {
                break;
            }

        }

    }

    @Override
    public void stop() {
        printer.printExit();
    }

    private boolean validateInput(String input) {
        Double sideSize = SortingTrianglesUtils.parseDoubleOrNull(input);
        return (sideSize != null && sideSize > 0);
    }

    //calculate area rounded by second sign after the delimeter
    private double calculateAreaByHeron(double firstSide, double secondSide, double thirdSide) {
        double area = 0.25 * Math.sqrt((firstSide + secondSide + thirdSide)
                * (-firstSide + secondSide + thirdSide)
                * (firstSide - secondSide + thirdSide)
                * (firstSide + secondSide - thirdSide));

        return Math.round(area * 100.0) / 100.0;
    }

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
