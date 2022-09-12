package core;

import core.utils.EnvelopAnalysisUtils;

import ui.EnvelopAnalysisPrinter;
import ui.Reader;


public class EnvelopAnalysisEngine implements Engine {
    private Reader reader;
    private EnvelopAnalysisPrinter printer;


    @Override
    public void start() {
        String input;
        do {
            printer.printInstructions();
            input = reader.readLine();
            doWork(input);
            printer.printContinue();
            input = reader.readLine();
        }
        while ("y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input));
        stop();
    }

    @Override
    public boolean doWork(String input) {
        int sideCount = 4;
        Envelop firstEnvelop = new Envelop();
        Envelop secondEnvelop = new Envelop();

        double[] sides = new double[sideCount];
        for (int i = 0; i < sideCount; i++) {
            if (!validateInput(input)) {
                printer.printError();
                printer.printInstructions();
                return false;
            }
            sides[i] = Double.parseDouble(input);
            if (i < sideCount - 1) {
                input = reader.readLine();
            }

        }
        double firstEnvelopShorterSide = (sides[0] - sides[1] > 0) ? sides[1] : sides[0];
        double firstEnvelopLongerSide = (sides[0] - sides[1] > 0) ? sides[0] : sides[1];
        double secondEnvelopShorterSide = (sides[2] - sides[3] > 0) ? sides[3] : sides[2];
        double secondEnvelopLongerSide = (sides[2] - sides[3] > 0) ? sides[2] : sides[3];
        firstEnvelop.setShorterSide(firstEnvelopShorterSide);
        firstEnvelop.setLongerSide(firstEnvelopLongerSide);
        secondEnvelop.setShorterSide(secondEnvelopShorterSide);
        secondEnvelop.setLongerSide(secondEnvelopLongerSide);

        printer.printResultFromEnvelopAnalysis(
                checkIfTwoEnvelopsPass(firstEnvelop, secondEnvelop));
        return true;
    }

    @Override
    public void stop() {
        printer.printExit();
    }


    private boolean validateInput(String input) {
        Double sideSize = EnvelopAnalysisUtils.parseDoubleOrNull(input);
        return (sideSize != null && sideSize > 0);
    }

    private boolean checkIfTwoEnvelopsPass(Envelop firstEnvelop, Envelop secondEnvelop) {
        return ((firstEnvelop.getShorterSide() > secondEnvelop.getShorterSide()
                && firstEnvelop.getLongerSide() > secondEnvelop.getLongerSide())
                || (firstEnvelop.getShorterSide() < secondEnvelop.getShorterSide()
                && firstEnvelop.getLongerSide() < secondEnvelop.getLongerSide()));

    }

    public Reader getReader() {
        return reader;
    }

    public EnvelopAnalysisPrinter getPrinter() {
        return printer;
    }

    public EnvelopAnalysisEngine setReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    public EnvelopAnalysisEngine setPrinter(EnvelopAnalysisPrinter printer) {
        this.printer = printer;
        return this;
    }


}
