public class Driver extends Person{
    private int startnumber;

    public Driver(String firstname, String lastname, char gender, int startnumber) {
        super(firstname, lastname, gender, "Fahrer");
        this.startnumber = startnumber;
    }

    public int getStartnumber() {
        return startnumber;
    }

    @Override
    public String doJob() {
        return "Ich fahre meinen Rennwagen mit der Nummer "+startnumber+" um den Kurs";
    }
}
