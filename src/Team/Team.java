package Team;

public class Team {
    private String teamname;
    private Driver driver1;
    private Driver driver2;
    private int performanceIndicator;   // int between 1 & 10

    public String getTeamname() {
        return teamname;
    }
    public void setTeamname(String name){
        teamname = name;
    }

    public Driver getDriver1() {
        return driver1;
    }

    public void setDriver1(Driver driver1) {
        this.driver1 = driver1;
    }

    public Driver getDriver2() {
        return driver2;
    }

    public void setDriver2(Driver driver2) {
        this.driver2 = driver2;
    }


    public Team(){};

    public Team(Driver d1, Driver d2, int p){
        driver1 = d1;
        driver2 = d2;
        if(p>1 && p<=10){
            performanceIndicator = p;
        }else{
            performanceIndicator = 5;
        }
    }
}
