package ui;


import core.Triangle;

public class ConsolePrinter implements TriangleSortingPrinter {
    int counter = 0;


    @Override
    public void printInstructions() {
        System.out.println("For sorting triangles by their area put -> 'triangle name','firstSide','secondSide','thirdSide' separated by ',' ");
    }

    @Override
    public void printError() {
        System.out.println("Your input is incorrect !");
    }

    @Override
    public void printContinue() {
        System.out.println("For continue the program: -> Type 'y' or 'yes' else the program will stop.");
    }

    @Override
    public void printExit() {
        System.out.println("Stopping the program...");
    }

    @Override
    public void printResultFromSortingTriangles(Triangle triangle) {
        counter++;
        StringBuilder builder = new StringBuilder()
                .append(counter)
                .append(". ")
                .append("[Triangle ")
                .append(triangle.getName())
                .append("]: ")
                .append(String.format("%1$,.2f",
                        triangle.calculateAreaByHeron(triangle.getFirstSide(),
                        triangle.getSecondSide(),
                                triangle.getThirdSide())))
                .append("cm.");


        System.out.println(builder);
    }
}
