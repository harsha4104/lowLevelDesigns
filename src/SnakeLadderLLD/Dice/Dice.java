package SnakeLadderLLD.Dice;

import java.util.Random;

public class Dice {

    int number;
    Random rand;

    public Dice(int number){
        this.number = number;
        this.rand = new Random();
    }

    public int rollDice(){
        return 1+(rand.nextInt(6)%6);
    }
}
