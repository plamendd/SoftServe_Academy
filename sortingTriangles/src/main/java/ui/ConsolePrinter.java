package ui;


public class ConsolePrinter implements TriangleSortingPrinter {

    @Override
    public void printInstructions() {
        System.out.println("For sorting triangles by their area put -> 'triangle name','firstSide','secondSide','thirdSide' separated by ',' ");
    }

    @Override
    public void printError() {
        System.out.println("Your input is incorrect !");
    }

    @Override
    public void printContinue(){
        System.out.println("For continue the program: -> Type 'y' or 'yes' else the program will stop.");
    }

    @Override
    public void printExit(){
        System.out.println("Stopping the program...");
    }

    @Override
    public void printResultFromSortingTriangles() {


    }
}
