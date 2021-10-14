public class RacingTeamFactory {
    public static void main(String[] args) {
        // First create a Driver
        Driver driver1 = new Driver("Valteri","Bottas",'m', 77);
        Driver driver2 = new Driver("Lewis","Hamilton",'m', 44);

        Mechanic mech1 = new Mechanic("Hans","Wurst",'m');
        System.out.println(driver1);
        System.out.println(driver1.doJob());
        System.out.println(driver2);
        System.out.println(driver2.doJob());
        System.out.println(mech1.doJob());

        System.out.println(driver1.getTeamname());
    }
}
