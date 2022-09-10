package ui;


public class ConsolePrinter implements NumberInWordsPrinter {


    @Override
    public void printInstructions() {
        System.out.println("On the next line type one positive number under one thousand.");
    }

    @Override
    public void printError() {
        System.out.println("Your input is incorrect !");
        System.out.println("You have to type one positive number under one thousand.");
    }

    @Override
    public void printContinue(){
        System.out.println("For continue the program: -> Type 'y' or 'yes' else the program will stop.");
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printExit(){
        System.out.println("Stopping the program...");
    }


}
