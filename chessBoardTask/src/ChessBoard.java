import core.Engine;
import core.MatrixEngine;


public class ChessBoard {
    private Engine engine;


    public ChessBoard() {
        this.engine = new MatrixEngine();
    }

    public void run() {
        engine.start();
    }
}
