import Adversities.ChanceOfOvertake;
import Adversities.Weather;
import Race.RaceStart;
import Team.Team;
import Track.Track;
import Team.Person;
import Team.Driver;

import java.util.*;

public class TheRace {
    public static void main(String[] args) {
        int laps = 58;

        Track track = new Track("Albert Park","Australia",6,14,2);

        // Set weather
        String[] weatherArr = {"sunny","rainy","rain","thunderstorm"};
        Random wrand = new Random();
        String weather = weatherArr[wrand.nextInt(weatherArr.length)];
        Weather w = new Weather(weather);

        // Create Teams and add Drivers
        Team[] teams = new Team[10];
        // Mercedes
        Driver valteri = new Driver("Mercedes AMG F1", "Valteri","Bottas",'m', 77, 8);
        Driver lewis = new Driver("Mercedes AMG F1", "Lewis","Hamilton",'m', 44, 10);
        teams[0] = new Team(lewis, valteri, 9);
        // McLaren
        Driver lando = new Driver("McLaren","Lando","Norris",'m', 4, 7);
        Driver daniel = new Driver("McLaren","Daniel","Ricciardo",'m', 3, 7);
        teams[1] = new Team(lando, daniel, 8);
        // RedBull
        Driver max = new Driver("RedBull Racing","Max","Verstappen",'m', 33, 10);
        Driver sergio = new Driver("RedBull Racing","Sergio","Perez",'m', 11, 7);
        teams[2] = new Team( max, sergio, 9);
        // Aston Martin
        Driver seb = new Driver("Aston Martin","Sebastian","Vettel",'m', 5, 8);
        Driver lance = new Driver("Aston Martin","Lance","Stroll",'m', 18, 4);
        teams[3] = new Team( seb, lance, 6);
        // AlphaTauri
        Driver pierre = new Driver("AlphaTauri","Pierre","Gasly",'m', 10, 6);
        Driver yuki = new Driver("AlphaTauri","Yuki","Tsunoda",'m', 22, 3);
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
        double difficulty = 1.00 -(1.00 / track.getDifficulty());
        Driver[] dnfArray = new Driver[grid.length]; //Prepare the DNF Array
        RaceStart start = new RaceStart();
        start.printCountdown(track,w);
        start.printGrid(grid);
        String[] highlights = new String[laps];

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
                String rundenHighlights = new String();
                if(i == laps) System.out.println(">>>>>>>>>>>>>>>>>>>>>> FINAL LAP <<<<<<<<<<<<<<<<<<<<<<");
                System.out.println();
                int gridPos = 1;
                Driver inFront = null;
                for (Driver driver:grid) {
                    Driver d = driver;
                    if(d == null || d.getDNFStatus()){continue;}

                    d.calculateDnf();
                    if(!d.getDNFStatus()) {
                        String append = d.getStartnumber() < 10 ? " " : "";
                        String place = gridPos < 10 ? gridPos + ". " : gridPos + ".";
                        System.out.println(place + " #" + d.getStartnumber() + append + " | " + d.getLastname());

                        //Overtaking
                        if(inFront != null && Math.random() > difficulty){
                            if(ChanceOfOvertake.tryOvertake(inFront,d)){
                                List<Driver> gridList = Arrays.asList(grid);
                                Collections.swap(gridList, gridList.indexOf(d)-1, gridList.indexOf(d));
                                gridList.toArray(grid);
                                System.out.println(d.getLastname() + " setzt gerade zum Überholmanöver gegen " + inFront.getLastname() + " an!");
                                if(rundenHighlights.length() == 0){
                                    rundenHighlights = "Runde "+i+":\n";
                                }
                                rundenHighlights += d.getLastname() + " hat " + inFront.getLastname() + " überholt und ist jetzt auf Platz "+ (gridPos-1) +"!\n";
                            }
                        }
                        //Box Box!
                        boolean pitThisLap = false;
                        if(i>10 && d.getPitStops() == 0 && Math.random() > 0.7){
                            d.addPitstop();
                            pitThisLap = true;
                        }else if(i > (laps-10) && d.getPitStops() == 0){
                            d.addPitstop();
                            pitThisLap = true;
                        }
                        if(pitThisLap){
                            // auch noch nicht gelernt:
                            ArrayList<Driver> gridList = new ArrayList(Arrays.asList(grid));
                            int oldIndex = gridList.indexOf(d);
                            int newIndex = (gridList.indexOf(d)+4) < (grid.length-1) ? gridList.indexOf(d)+4 : grid.length-1;
                            Driver object = gridList.get(oldIndex);
                            gridList.remove(oldIndex);
                            gridList.add(newIndex,object);
                            grid = gridList.toArray(grid);

                            if(rundenHighlights.length() == 0){
                                rundenHighlights = "Runde "+i+":\n";
                            }
                            rundenHighlights += d.getLastname() + " geht an die Box!\n";
                        }
                        gridPos++;
                    }else{
                        if(rundenHighlights.length() == 0){
                            rundenHighlights = "Runde "+i+":\n";
                        }
                        rundenHighlights += d.getLastname() + " ist an Platz "+gridPos+" liegend ausgeschieden!\n";
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
                    if(driver != null){
                        inFront = driver;
                    }

                    highlights[i-1] = rundenHighlights;
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

        System.out.println();
        System.out.println("########### Highlights in diesem Rennen: ###########");
        for (String highlight:highlights) {
            if(highlight.length() > 0){
                System.out.println(highlight);
            }
        }
    }
}
