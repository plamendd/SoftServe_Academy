package ui;


public class ConsolePrinter implements EnvelopAnalysisPrinter {

    @Override
    public void printInstructions() {
        System.out.println("For comparing two envelopes - type their sides.(a,b) and (c,d)");
        System.out.println("Type four positive numbers each one represents side from one envelop.");

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
    public void printResultFromEnvelopAnalysis(boolean isPassed) {
        if (isPassed) {
            System.out.println("The two envelops can be put inside each other.");
        } else {
            System.out.println("The two envelops can  not be put inside each other.");
        }


    }
}
