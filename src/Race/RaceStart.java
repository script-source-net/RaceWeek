package Race;
import Track.Track;
import Adversities.Weather;
import Team.Driver;

public class RaceStart {

    public static void printCountdown(Track track, Weather w){
        System.out.println();
        System.out.println("###################################");
        System.out.println("Welcome in " + track.getName() + ", " + track.getLocation());
        System.out.println(w + track.getName());
        System.out.println("###################################");
        System.out.println("");

    }

    public static void printGrid(Driver[] grid){
        System.out.println("################################ GRID ################################");
        int startingbox = 1;
        for (Driver d: grid) {
            if(d != null) {
                String append = d.getStartnumber() < 10 ? " ":"";
                if(startingbox %2 !=0) {
                    System.out.print("        ");
                    System.out.print(d.getStartnumber() + append +" " + d.getLastname());
                }else{
                    System.out.print("                ");
                    System.out.print(d.getStartnumber() + append +" " + d.getLastname());
                }
                System.out.println();
            }
            startingbox++;
        }
        System.out.println("################################ #### ################################");
        System.out.println();
    }
}
