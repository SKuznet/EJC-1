package task_02;

import java.util.Random;

public class Flying implements MovementBehavior {
    private final int MAX_SPEED = 100;
    private final int MIN_SPEED = 40;
    private Random random = new Random();

    @Override
    public int move() {
        return this.random.nextInt(this.MAX_SPEED - this.MIN_SPEED) + this.MIN_SPEED;
    }
}
