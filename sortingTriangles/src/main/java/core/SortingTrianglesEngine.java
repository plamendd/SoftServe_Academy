package core;

import core.utils.SortingTrianglesUtils;
import ui.TriangleSortingPrinter;
import ui.Reader;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.PriorityQueue;


public class SortingTrianglesEngine implements Engine {
    private Reader reader;
    private TriangleSortingPrinter printer;
    private PriorityQueue<Triangle> queue;

    public SortingTrianglesEngine() {
        this.queue = new PriorityQueue<Triangle>(10, new TriangleComparator() {
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
            return;



    }

    @Override
    public void doWork(String input) {
        int parametersCount = 4;
          while (true) {
              String[] splitInput = input.split(",");
              if (splitInput.length != parametersCount) {
                  printer.printError();
                  return;
              }
              Arrays.stream(splitInput).forEach(x -> x.trim());
              Triangle triangle = new Triangle();
              triangle.setName(splitInput[0]);

              for (int i = 1; i <= 3; i++) {
                  if (!validateInput(splitInput[i])) {
                      printer.printError();
                      return;
                  }
              }
              triangle.setFirstSide(Double.parseDouble(splitInput[1]));
              triangle.setSecondSide(Double.parseDouble(splitInput[2]));
              triangle.setThirdSide(Double.parseDouble(splitInput[3]));
              triangle.setArea(calculateAreaByHeron(triangle.getFirstSide(),
                      triangle.getSecondSide(), triangle.getThirdSide()));

              queue.add(triangle);
              printer.printContinue();
              input = reader.readLine();
              if ("y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)){
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

    public double calculateAreaByHeron(double firstSide, double secondSide, double thirdSide) {
        return 0.25 * Math.sqrt((firstSide + secondSide + thirdSide)
                * (-firstSide + secondSide + thirdSide)
                * (firstSide - secondSide + thirdSide)
                * (firstSide + secondSide - thirdSide));
    }
}
