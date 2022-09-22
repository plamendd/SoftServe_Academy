import builder.Computer;
import builder.GamingPC;
import builder.Laptop;

public class Shop {
    public static void main(String[] args) {
           // Computer computer = new Computer("Intel i7", "MSI B360M-MORTAR","gtx 1050ti", "samsung evo 870","windows 10", 500, 16);


        Computer computer = Computer.builder()
                .setPowerSupply(500)
                .setAmountOfRAM(16)
                .setOperatingSystem("windows 10")
                .setMotherboard("MSI B360")
                .setHDD("1000gb Samsung")
                .setCPU("intel i7")
                .setGPU("GTX 1050ti")
                .build();

        Laptop laptop = Laptop.builder()
                .setScreenSize(15.4)
                .setBatteryCapacity(5000)
                .setPowerSupply(500)
                .setAmountOfRAM(16)
                .setOperatingSystem("windows 10")
                .setMotherboard("MSI B360")
                .setHDD("1000gb Samsung")
                .setCPU("intel i7")
                .setGPU("GTX 1050ti")
                .build();

        GamingPC gamingPC = GamingPC.builder()
                .setKeyboard("Logitech g500")
                .setMouse("Razer Mamba")
                .setAmountOfRAM(32)
                .setOperatingSystem("windows 10")
                .setMotherboard("MSI B360")
                .setHDD("1000gb Samsung")
                .setCPU("intel i7")
                .setGPU("GTX 1050ti")
                .build();

        System.out.println(computer);
        System.out.println(laptop);
        System.out.println(gamingPC);
    }

}
