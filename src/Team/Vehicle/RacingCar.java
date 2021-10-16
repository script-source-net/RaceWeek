package Team.Vehicle;

import Team.Driver;
import Team.Vehicle.Parts.*;

public class RacingCar extends Vehicle implements Engine {
    private int number;
    private boolean drives;
    private boolean isDefect;
    private int lapsUsed;

    public RacingCar(String brand, String label, int maxSpeed, int horsepower) {
        super(brand, label, maxSpeed, horsepower);
        drives = true;
        isDefect = false;
        lapsUsed = (int) (Math.random() * 10) + (int) (Math.random() * 10);
    }

    public int getRacingCarEngineLaps(){
        return lapsUsed;
    }

    public void chanceOfDefect(){
        //
        if(Math.random() > 0.99){
            this.isDefect = true;
            this.drives = false;
        }
    }

    public boolean isDrives() {
        return drives;
    }

    public void setDrives(boolean drives) {
        this.drives = drives;
    }

    public boolean isDefect() {
        return isDefect;
    }

    public void setDefect(boolean defect) {
        isDefect = defect;
    }

    public int getLapsUsed() {
        return lapsUsed;
    }

    public void setLapsUsed(int lapsUsed) {
        this.lapsUsed = lapsUsed;
    }

    @Override
    public String drive() {
        return null;
    }


}
