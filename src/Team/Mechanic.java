package Team;

public class Mechanic extends Person {
    public Mechanic(String teamname, String firstname, String lastname, char gender) {
        super(teamname, firstname, lastname, gender, "Team.Mechanic");
    }

    @Override
    public String doJob() {
        return "Ich repariere den Wagen";
    }
}
