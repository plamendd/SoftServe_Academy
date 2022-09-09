package core;

public interface Engine {

    boolean start();

    boolean doWork(String input);

    void stop();
}
