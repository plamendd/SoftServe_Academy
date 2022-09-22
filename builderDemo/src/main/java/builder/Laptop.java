package builder;

public class Laptop extends Computer{
    private double screenSize;
    private int batteryCapacity;

    public Laptop(Builder builder){
        super(builder);
        this.screenSize = builder.screenSize;
        this.batteryCapacity = builder.batteryCapacity;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Computer.Builder<Builder> {
        private double screenSize;
        private int batteryCapacity;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder setScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder setBatteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }
        public Laptop build() {
            return new Laptop(this);
        }

    }

    @Override
    public String toString() {
        return  "Laptop{" + super.toString() +
                "screenSize=" + screenSize +
                ", batteryCapacity=" + batteryCapacity +
                '}';
    }
}
