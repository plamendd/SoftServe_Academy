package ui;


public class ConsolePrinter implements FileParserPrinter {


    @Override
    public void printInstructions() {
        System.out.println("On the next line type 'path to file' and 'word' which will be counted' or 'path to file' and 'word' to be replaced with 'other word'.");
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

}
