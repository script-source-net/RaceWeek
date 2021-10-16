package Adversities;

import Team.Driver;

public class ChanceOfOvertake {

    public static boolean tryOvertake(Driver a, Driver b){

        double chance = Math.random();

        if(a.getSkill() <= b.getSkill()){
            chance += 0.5;
        }

        if(chance > 0.8){
            return true;
        }

        return false;
    }
}
