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
    public boolean start() {
        printer.printInstructions();
        String input = reader.readLine();

        while (!"exit".equals(input)) {
            doWork(input);
            printer.printInstructions();
            input = reader.readLine();
            return false;
        }
        stop();
        return true;
    }

    @Override
    public boolean doWork(String input) {
        String[] args = input.split("\\s");
        if (!checkParametersCount(args)) {
            printer.printError();
            return false;
        }
        if (!checkParametersRange(args[0], args[1])) {
            printer.printError();
            return false;
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        printer.printBoard(generateBoard(height, width));
        return true;

    }

    @Override
    public void stop() {
        printer.printExit();
    }

    protected boolean checkParametersCount(String[] args) {
        int parametersCount = args.length;
        int requiredParametersCount = 2;
        return parametersCount == requiredParametersCount;
    }

    protected boolean checkParametersRange(String first, String second) {
        Integer height = BoardUtils.parseIntOrNull(first);
        Integer width = BoardUtils.parseIntOrNull(second);
        return (height != null && height > 0) && (width != null && width > 0);
    }

    /**
     * Generate 2D Matrix with given dimensions.
     * Fills it with '*' -> when row is even number == coll is even number
     * Fills it with ' ' -> when its not.
     *
     * @param height
     * @param width
     * @return 2D matrix of chars;
     */
    protected char[][] generateBoard(int height, int width) {
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
