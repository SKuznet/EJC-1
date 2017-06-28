package task_02;

import java.util.ArrayList;

public class Game {
    private ArrayList<Duck> ducks = new ArrayList<>();
    private int flyingDucksNumber = 3;
    private int runningDucksNumber = 2;
    private int funds;
    private int prize;

    public Game(int funds, int prize) {
        this.funds = funds;
        this.prize = prize;
    }

    public void setDucksNumber(int flyingDucksNumber, int runningDucksNumber) {
        this.flyingDucksNumber = flyingDucksNumber;
        this.runningDucksNumber = runningDucksNumber;
    }

    public void play() {
        // add 3 flying ducks
        for (int i = 0; i < this.flyingDucksNumber; i++) {
            ducks.add(new Duck(new Flying()));
        }

        // add 2 running ducks
        for (int i = 0; i < this.runningDucksNumber; i++) {
            ducks.add(new Duck(new Running()));
        }


    }
}
