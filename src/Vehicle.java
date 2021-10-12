public abstract class Vehicle extends Team{

    private String brand;
    private String label;
    private int maxSpeed;
    private int horsepower;

    public abstract String drive();

    public Vehicle(String brand, String label, int maxSpeed, int horsepower){
        this.brand = brand;
        this.label = label;
        this.maxSpeed = maxSpeed;
        this.horsepower = horsepower;
    }

}
