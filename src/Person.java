public abstract class Person extends Team {
    private String firstname;
    private String lastname;
    private char gender;
    private String role;

    public abstract String doJob();

    public Person(String firstname, String lastname, char gender, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.role = role;
    }


    @Override
    public String toString(){
        return "Das ist " + firstname + " "+lastname + " er ist "+role;
    }
}
