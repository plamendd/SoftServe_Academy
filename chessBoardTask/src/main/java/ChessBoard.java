import core.Engine;


public class ChessBoard {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public ChessBoard setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public void run() {
        engine.start();
    }
}
