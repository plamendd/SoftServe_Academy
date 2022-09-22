package builder;

public class Computer {
    private String CPU;
    private String motherboard;
    private String GPU;
    private String HDD;
    private String operatingSystem;
    private int powerSupply;
    private int amountOfRAM;

//    public Computer(String CPU, String motherboard, String GPU, String HDD, String operatingSystem, int powerSupply, int amountOfRAM) {
//        this.CPU = CPU;
//        this.motherboard = motherboard;
//        this.GPU = GPU;
//        this.HDD = HDD;
//        this.operatingSystem = operatingSystem;
//        this.powerSupply = powerSupply;
//        this.amountOfRAM = amountOfRAM;
//    }

    Computer(Builder<?> builder) {
        this.CPU = builder.CPU;
        this.motherboard = builder.motherboard;
        this.GPU = builder.GPU;
        this.HDD = builder.HDD;
        this.operatingSystem = builder.operatingSystem;
        this.powerSupply = builder.powerSupply;
        this.amountOfRAM = builder.amountOfRAM;
    }


    public String getCPU() {
        return CPU;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getGPU() {
        return GPU;
    }

    public String getHDD() {
        return HDD;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    public int getAmountOfRAM() {
        return amountOfRAM;
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    public abstract static class Builder<T extends Builder<T>> {
        private String CPU;
        private String motherboard;
        private String GPU;
        private String HDD;
        private String operatingSystem;
        private int powerSupply;
        private int amountOfRAM;


        public abstract T getThis();

        public T setPowerSupply(int powerSupply) {
            this.powerSupply = powerSupply;
            return (T) this;
        }

        public T setAmountOfRAM(int amountOfRAM) {
            this.amountOfRAM = amountOfRAM;
            return (T) this;
        }

        public T setCPU(String CPU) {
            this.CPU = CPU;
            return (T) this;
        }

        public T setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return (T) this;
        }

        public T setGPU(String GPU) {
            this.GPU = GPU;
            return (T) this;
        }

        public T setHDD(String HDD) {
            this.HDD = HDD;
            return (T) this;
        }

        public T setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return (T) this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", GPU='" + GPU + '\'' +
                ", HDD='" + HDD + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", powerSupply=" + powerSupply +
                ", amountOfRAM=" + amountOfRAM +
                '}';
    }
}
