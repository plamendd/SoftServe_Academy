package ui;

import java.util.Arrays;


public class ConsolePrinter implements BoardPrinter {

    @Override
    public void printInstructions() {
        System.out.println("For generating a matrix with height and width: -> Type two  positive numbers separated by whitespace for height and width.");
    }

    @Override
    public void printError() {
        System.out.println("Your input is incorrect !");
    }


    @Override
    public void printBoard(char[][] board) {
        Arrays.stream(board)
                .forEach(System.out::println);
    }

    @Override
    public void printExit(){
        System.out.println("Stopping the program...");
    }
}
