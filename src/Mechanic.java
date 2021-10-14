public class Mechanic extends Person{
    public Mechanic(String firstname, String lastname, char gender) {
        super(firstname, lastname, gender, "Mechanic");
    }

    @Override
    public String doJob() {
        return "Ich repariere den Wagen";
    }
}
