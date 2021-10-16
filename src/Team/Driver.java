package Team;

import Team.Vehicle.RacingCar;

public class Driver extends Person {
    private int startnumber;
    private boolean dnf = false;
    private RacingCar car;

    public Driver(String teamname, String firstname, String lastname, char gender, int startnumber) {
        super(teamname, firstname, lastname, gender, "Fahrer");
        this.startnumber = startnumber;
        this.car = new RacingCar("","",320,960);
    }

    public int getStartnumber() {
        return startnumber;
    }

    public String getTeamName(){
        return this.getTeamname();
    }

    public void calculateDnf(){
        car.chanceOfDefect();   // Chance of car defect
        if(!car.isDrives()){
            dnf = true;
        }
    }

    public boolean getDNFStatus() {
        return dnf;
    }

    @Override
    public String doJob() {
        return "Ich fahre meinen Rennwagen mit der Nummer "+startnumber+" um den Kurs";
    }
}
