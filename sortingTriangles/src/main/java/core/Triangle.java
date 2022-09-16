package core;


public class Triangle {
    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private String name;

    //calculate area rounded by second sign after the delimeter.
    public double calculateAreaByHeron(double firstSide, double secondSide, double thirdSide) {
        return Math.round((0.25 * Math.sqrt((firstSide + secondSide + thirdSide)
                * (-firstSide + secondSide + thirdSide)
                * (firstSide - secondSide + thirdSide)
                * (firstSide + secondSide - thirdSide))) * 100.0) / 100.0;
    }
    @Override
    public String toString() {
        return "[Triangle " + getName() + "]: " + calculateAreaByHeron(firstSide, secondSide, thirdSide) + "cm.";
    }

    public double getFirstSide() {
        return firstSide;
    }


    public Triangle setFirstSide(double firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public Triangle setSecondSide(double secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public Triangle setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public String getName() {
        return name;
    }

    public Triangle setName(String name) {
        this.name = name;
        return this;
    }
}
