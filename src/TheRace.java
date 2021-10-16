import Adversities.Weather;
import Race.RaceStart;
import Team.Team;
import Track.Track;
import Team.Person;
import Team.Driver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheRace {
    public static void main(String[] args) {
        int laps = 58;
        Track track = new Track("Albert Park","Australia",6,14,2);
        Weather w = new Weather("sunny");

        // Create Teams and add Drivers
        Team[] teams = new Team[10];
        // Mercedes
        Driver valteri = new Driver("Mercedes AMG F1", "Valteri","Bottas",'m', 77);
        Driver lewis = new Driver("Mercedes AMG F1", "Lewis","Hamilton",'m', 44);
        teams[0] = new Team(lewis, valteri, 9);
        // McLaren
        Driver lando = new Driver("McLaren","Lando","Norris",'m', 4);
        Driver daniel = new Driver("McLaren","Daniel","Ricciardo",'m', 3);
        teams[1] = new Team(lando, daniel, 8);
        // RedBull
        Driver max = new Driver("RedBull Racing","Max","Verstappen",'m', 33);
        Driver sergio = new Driver("RedBull Racing","Sergio","Perez",'m', 11);
        teams[2] = new Team( max, sergio, 9);
        // Aston Martin
        Driver seb = new Driver("Aston Martin","Sebastian","Vettel",'m', 5);
        Driver lance = new Driver("Aston Martin","Lance","Stroll",'m', 18);
        teams[3] = new Team( seb, lance, 6);
        // AlphaTauri
        Driver pierre = new Driver("AlphaTauri","Pierre","Gasly",'m', 10);
        Driver yuki = new Driver("AlphaTauri","Yuki","Tsunoda",'m', 22);
        teams[4] = new Team( pierre, yuki, 5);

        // Count drivers
        int drivers = 0;
        for (Team t: teams) {
            if(t != null) {
                drivers += 2;
            }
        }

        // The Grid
        System.out.println(drivers);
        Driver[] grid = new Driver[drivers];
        int place = 0;
        for (Team t: teams) {
            if(t != null) {
                grid[place] = t.getDriver1();
                place++;
                grid[place] = t.getDriver2();
                place++;
            }
        }

        // Noch nicht gelernt: Shuffle Arrays
        List<Driver> gridList = Arrays.asList(grid);
        Collections.shuffle(gridList);
        // Higher chance of frontrow for driver 1 of top teams (as always ;>))
        int placeLewis = Math.random() > 0.5 ? 0 : 1;
        int placeMax = Math.random() > 0.5 ? 0 : 1;
        int placeValteri = (int) (Math.random() * 10);
        Collections.swap(gridList, placeLewis, gridList.indexOf(teams[0].getDriver1()));
        Collections.swap(gridList, placeMax, gridList.indexOf(teams[2].getDriver1()));
        Collections.swap(gridList, placeValteri, gridList.indexOf(teams[0].getDriver2()));
        gridList.toArray(grid);

        doRace(track, grid, w, teams,laps);

    }

    private static void doRace(Track track, Driver[] grid, Weather w, Team[] teams, int laps) {
        Driver[] dnfArray = new Driver[grid.length]; //Prepare the DNF Array
        RaceStart start = new RaceStart();
        start.printCountdown(track,w);
        start.printGrid(grid);

        for (int i = 0; i <= laps; i++) {
            if(i == 0){
                System.out.println(">>>>>>>>>>>>>>>>>>>>>> WarmUp Lap <<<<<<<<<<<<<<<<<<<<<");
                System.out.println();
                System.out.println("ooooo");
                System.out.println("xoooo");
                System.out.println("xxooo");
                System.out.println("xxxoo");
                System.out.println("xxxxo");
                System.out.println("xxxxx");
                System.out.println("ooooo");
                System.out.println();
                System.out.println(">>>>>>>>>>> It's lights out and away we go! <<<<<<<<<<<");
            }

            if(i>0){
                System.out.println("######################## LAP "+i+" ########################");
                if(i == laps) System.out.println(">>>>>>>>>>>>>>>>>>>>>> FINAL LAP <<<<<<<<<<<<<<<<<<<<<<");
                System.out.println();
                int gridPos = 1;
                for (Driver driver:grid) {
                    Driver d = driver;
                    if(d == null || d.getDNFStatus()){continue;}
                    d.calculateDnf();
                    if(!d.getDNFStatus()) {
                        String append = d.getStartnumber() < 10 ? " " : "";
                        String place = gridPos < 10 ? gridPos + ". " : gridPos + ".";
                        System.out.println(place + " #" + d.getStartnumber() + append + " | " + d.getLastname());
                        gridPos++;
                    }else{
                        System.out.println("----------------> DNF for: " +d.getFirstname()+" "+d.getLastname()+", oh no!");
                        Driver temp = d;
                        boolean set = false;
                        for (int dr = 0; dr < dnfArray.length; dr++) {
                            if(dnfArray[dr] == null){
                                dnfArray[dr] = temp;
                                break;
                            }
                        }
                        driver = null;
                    }
                }


                System.out.println();
                System.out.print(">>>>>>>>>>");
                System.out.print(">>> Drivers out: ");
                for (Driver dnfDriver: dnfArray) {
                    if(dnfDriver != null){
                        System.out.print(dnfDriver.getFirstname() + " " + dnfDriver.getLastname() + " | ");
                    }else{
                        //System.out.println(dnfDriver);
                    }
                }
                System.out.println(">>>>>>>>>>");
                System.out.println();
            }
        }

        System.out.println("####################################");
        System.out.println("############## RESULT ##############");
        System.out.println("####################################");
        int finalPlace = 1;
        for (Driver driver:grid){
            if(driver.getDNFStatus()){continue;}
            String p = finalPlace < 10 ? finalPlace+". " : finalPlace+".";
            System.out.println(p + "    " + driver.getFirstname()+" "+driver.getLastname() + " #" + driver.getStartnumber());
            if(finalPlace ==3){
                System.out.println("------------------------------");
            }
            finalPlace++;
        }
        for (Driver dnfDriver: dnfArray) {
            if(dnfDriver != null){
                System.out.println("DNF    " + dnfDriver.getFirstname() + " " + dnfDriver.getLastname() + " #" + dnfDriver.getStartnumber() + " " +dnfDriver.getTeamname());
            }else{
                //System.out.println(dnfDriver);
            }
        }

    }
}
