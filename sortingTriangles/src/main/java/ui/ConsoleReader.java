package ui;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner reader;

    public ConsoleReader(Scanner scanner) {
        this.reader = scanner;
    }

    @Override
    public String readLine(){
        return  reader.nextLine();
    }
}
