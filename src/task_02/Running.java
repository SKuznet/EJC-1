package task_02;

import java.util.Random;

public class Running implements MovementBehavior {
    private final int MAX_SPEED = 80;
    private final int MIN_SPEED = 10;
    private Random random = new Random();

    @Override
    public int move() {
        return this.random.nextInt(this.MAX_SPEED - this.MIN_SPEED) + this.MIN_SPEED;
    }
}
