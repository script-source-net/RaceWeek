public class Truck extends Vehicle{
    private String licensePlate;
    private int cargoCapacity;

    public Truck(String brand, String label, int maxSpeed, int horsepower, String licensePlate, int cargoCapacity) {
        super(brand, label, maxSpeed, horsepower);
        this.licensePlate = licensePlate;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String drive() {
        return "Der Truck liefert gerade teile aus dem Headquarter an die Strecke...";
    }

}
