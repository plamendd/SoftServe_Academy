package core;


public class Triangle {
    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private String name;
    private double area;


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

    public double getArea() {
        return area;
    }

    public Triangle setArea(double area) {
        this.area = area;
        return this;
    }

    @Override
    public String toString() {
        return "[Triangle " + getName() + "]: " + getArea() + "cm.";
    }
}
