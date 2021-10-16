package Team.Vehicle;

public abstract class Vehicle {

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
