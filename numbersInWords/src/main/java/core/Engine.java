package core;

public interface Engine {

    void start(String [] args);

    boolean doWork(String input);

    void stop();
}
