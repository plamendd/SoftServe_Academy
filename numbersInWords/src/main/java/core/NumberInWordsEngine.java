package core;

import core.utils.NumberInWordsUtils;
import ui.NumberInWordsPrinter;
import ui.Reader;


public class NumberInWordsEngine implements Engine {
    private Reader reader;
    private NumberInWordsPrinter printer;

    private static final String[] namesStartsWithTen = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] nameStartsUnderTen = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };


    @Override
    public void start(String[] args) {
        printer.printInstructions();
        String input = reader.readLine();

        doWork(input);

        stop();
        return;

    }

    @Override
    public void doWork(String input) {
        String[] splitInput = input.split("\\s");

        if (splitInput.length != 1) {
            printer.printError();
            return;
        }
        if (!checkInput(input)) {
            printer.printError();
            return;
        }
        String numberInWord = convertNumberToWordUnderThousand(Integer.parseInt(input));
        printer.printResult(numberInWord.trim());
        return;
    }


    @Override
    public void stop() {
        printer.printExit();
    }


    public Reader getReader() {
        return reader;
    }

    public NumberInWordsPrinter getPrinter() {
        return printer;
    }

    public NumberInWordsEngine setReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    public NumberInWordsEngine setPrinter(NumberInWordsPrinter printer) {
        this.printer = printer;
        return this;
    }

    private boolean checkInput(String input) {
        Integer number = NumberInWordsUtils.parseIntOrNull(input);
        return (number != null && number >= 0);
    }


    private String convertNumberToWordUnderThousand(int number) {
        String numberInWords = "";
        if (number == 0){
            return "zero";
        }
        if (number % 100 < 20) {
            numberInWords = nameStartsUnderTen[number % 100];
            number /= 100;
        } else {
            numberInWords = nameStartsUnderTen[number % 10];
            number /= 10;
            numberInWords = namesStartsWithTen[number % 10] + numberInWords;
            number /= 10;
        }
        if (number == 0) {
            return numberInWords;
        }
        return nameStartsUnderTen[number] + " hundred" + numberInWords;
    }


}
