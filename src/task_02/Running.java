package task_02;

import java.util.Random;

public class Running implements MovementBehavior {
    private final int MAX_SPEED = 80;
    private final int MIN_SPEED = 50;
    private Random random = new Random();

    /**
     * Running behavior is implemented to
     * compete with Flying one
     *
     * @return int  step size
     */
    @Override
    public int move() {
        int step = this.random.nextInt(this.MAX_SPEED - this.MIN_SPEED) + this.MIN_SPEED;
        if (step < 60) step <<= 1;
        else step >>= 1;
        return step;
    }
}
