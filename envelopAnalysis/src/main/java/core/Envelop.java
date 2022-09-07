package core;

public class Envelop {
    private double shorterSide;
    private double longerSide;

    public double getShorterSide() {
        return shorterSide;
    }

    public Envelop setShorterSide(double shorterSide) {
        this.shorterSide = shorterSide;
        return this;
    }

    public double getLongerSide() {
        return longerSide;
    }

    public Envelop setLongerSide(double longerSide) {
        this.longerSide = longerSide;
        return this;
    }
}
