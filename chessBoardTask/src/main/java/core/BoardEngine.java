package core;

import core.utils.BoardUtils;
import ui.BoardPrinter;
import ui.Reader;


public class BoardEngine implements Engine {
    private Reader reader;
    private BoardPrinter printer;

    public Reader getReader() {
        return reader;
    }

    public BoardPrinter getPrinter() {
        return printer;
    }

    public BoardEngine setReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    public BoardEngine setPrinter(BoardPrinter printer) {
        this.printer = printer;
        return this;
    }

    @Override
    public void start() {
        printer.printInstructions();
        String input = reader.readLine();

        while (!"exit".equals(input)) {
            doWork(input);
            printer.printInstructions();
            input = reader.readLine();
        }
        stop();
    }

    @Override
    public void doWork(String input) {
        String[] args = input.split("\\s");
        if (!checkParametersCount(args)) {
            printer.printError();
            return;
        }
        if (!checkParametersRange(args)) {
            printer.printError();
            return;
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        printer.printBoard(generateBoard(height, width));
        return;

    }

    @Override
    public void stop() {
        printer.printExit();
    }

    private boolean checkParametersCount(String[] args) {
        int parametersCount = args.length;
        int requiredParametersCount = 2;
        return parametersCount == requiredParametersCount;
    }

    private boolean checkParametersRange(String[] args) {
        Integer height = BoardUtils.parseIntOrNull(args[0]);
        Integer width = BoardUtils.parseIntOrNull(args[1]);
        return (height != null && height > 0) && (width != null && width > 0);
    }

    /**
     * Generate 2D Matrix with given dimensions.
     * Fills it with '*' -> when row is even number == coll is even number
     * Fills it with ' ' -> when its not.
     * @param height
     * @param width
     * @return 2D matrix of chars;
     */
    private char[][] generateBoard(int height, int width) {
        char[][] board = new char[height][width];
        for (int col = 0; col < height; col++) {
            for (int row = 0; row < width; row++) {
                if ((col % 2 == 0) == (row % 2 == 0)) {
                    board[col][row] = '*';
                } else {
                    board[col][row] = ' ';
                }
            }
        }
        return board;
    }


}
