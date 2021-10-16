package Team;

import Team.Vehicle.RacingCar;

public class Driver extends Person {
    private int startnumber;
    private boolean dnf = false;
    private RacingCar car;
    private int skill = 5;
    private int pitStops = 0;

    public Driver(String teamname, String firstname, String lastname, char gender, int startnumber, int skill) {
        super(teamname, firstname, lastname, gender, "Fahrer");
        this.startnumber = startnumber;
        this.skill = skill;
        this.car = new RacingCar("","",320,960);
    }

    public int getStartnumber() {
        return startnumber;
    }

    public int getPitStops(){
        return pitStops;
    }

    public void addPitstop(){
        pitStops++;
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

    public int getSkill(){
        return this.skill;
    }

    @Override
    public String doJob() {
        return "Ich fahre meinen Rennwagen mit der Nummer "+startnumber+" um den Kurs";
    }
}
