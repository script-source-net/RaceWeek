public class RacingCar extends Vehicle{
    private int number;
    private Driver driver;

    public RacingCar(String brand, String label, int maxSpeed, int horsepower, Driver driver) {
        super(brand, label, maxSpeed, horsepower);
        this.number = driver.getStartnumber();
        this.driver = driver;
    }

    @Override
    public String drive() {
        return null;
    }
}
