package Team.Vehicle;

import Team.Vehicle.Vehicle;
import Team.Vehicle.Parts.Engine;

public class Truck extends Vehicle implements Engine {
    private String licensePlate;
    private int cargoCapacity;

    public Truck(String brand, String label, int maxSpeed, int horsepower, String licensePlate, int cargoCapacity) {
        super(brand, label, maxSpeed, horsepower);
        this.licensePlate = licensePlate;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String drive() {
        return "Der Team.Vehicle.Truck liefert gerade teile aus dem Headquarter an die Strecke...";
    }

}
