import core.BoardEngine;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ChessBoard chessBoard = new ChessBoard(
                new BoardEngine(
                        new ConsolePrinter(),
                        new ConsoleReader(
                                new Scanner(System.in))));
        chessBoard.run();
    }
}
