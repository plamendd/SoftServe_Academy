import core.Engine;


public class ChessBoard {
    private Engine engine;


    public ChessBoard(Engine engine) {
        this.engine = engine;
    }

    public void run() {
        engine.start();
    }
}
