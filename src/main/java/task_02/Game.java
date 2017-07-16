package task_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {
    private static final int flyingDucksNumber = 3;
    private static final int runningDucksNumber = 2;
    private static final int runningRange = 500;
    private ArrayList<Duck> ducks = new ArrayList<>();
    private int funds;
    private int prize;

    /**
     * Initializing the game with funds and prize
     * which is added or removed depending on how's
     * game going
     *
     * @param funds your starting money
     * @param prize money your can get (or lose)
     */
    public Game(int funds, int prize) {
        this.funds = funds;
        this.prize = prize;
    }

    /**
     * Huge pile of shitty code
     * <p>
     * In case of the Apocalypse shoot the author
     */
    public void play() {
        // add 3 flying ducks
        for (int i = 0; i < Game.flyingDucksNumber; i++) {
            ducks.add(new FlyingDuck(new Flying()));
        }

        // add 2 running ducks
        for (int i = 0; i < Game.runningDucksNumber; i++) {
            ducks.add(new RunningDuck(new Running()));
        }

        int option;
        String command;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("RUNNING RANGE: " + Game.runningRange);
                System.out.println("YOUR MONEY: " + this.funds);
                System.out.println("PRIZE: " + this.prize);
                System.out.println("CHOOSE YOUR DUCK: 0-" + (flyingDucksNumber + runningDucksNumber - 1));
                this.printDucks();
                System.out.print("> ");
                option = Integer.parseInt(reader.readLine());
                System.out.println();

                int winner = -1;
                for (int i = 0; i < 10; i++) {
                    this.moveAllDucks();
                    winner = this.checkWinner();
                    if (winner != -1) break;
                }

                if (option == winner) {
                    this.funds += this.prize;
                    System.out.println("YOU WIN! YOUR MONEY: " + this.funds);
                } else {
                    this.funds -= this.prize;
                    System.out.println("DUCK #" + winner + " WINS!");
                    System.out.println("HAHA GET REKT SCRUB, YOUR MONEY: " + this.funds);
                }

                if (this.funds == 0) {
                    System.out.println("YOU HAVE NO MONEY, BYE!");
                    break;
                }

                System.out.print("CONTINUE? (y/n): ");
                command = reader.readLine();
                System.out.println();

                if (!command.equals("y")) break;
                else resetDucks();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * It prints ...
     * <p>
     * ducks
     */
    public void printDucks() {
        String type;
        for (int i = 0; i < this.ducks.size(); i++) {
            type = (this.ducks.get(i).getMovementBehavior() instanceof Flying) ? "flying" : "running";
            System.out.println("duck #" + i + " is " + type);
        }
    }

    /**
     * Wow, ducks can move
     */
    public void moveAllDucks() {
        for (Duck duck : this.ducks) {
            duck.move();
        }
    }

    /**
     * Resetting traveled distance for each duck
     * <p>
     * if it's not dead already
     */
    public void resetDucks() {
        for (Duck duck : this.ducks) {
            duck.resetDistanceTraveled();
        }
    }

    /**
     * Checking which duck survived the massacre
     *
     * @return int  duck's index
     */
    public int checkWinner() {
        for (int i = 0; i < this.ducks.size(); i++) {
            if (this.ducks.get(i).getDistanceTraveled() >= Game.runningRange)
                return i;
        }
        return -1;
    }
}
