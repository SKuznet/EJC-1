package task_02;

import java.util.Random;

public class Flying implements MovementBehavior {
    private static final int MAX_SPEED = 100;
    private static final int MIN_SPEED = 30;
    private Random random = new Random();

    /**
     * Flying behavior has wider range of values
     * and its movement is implemented in a certain way
     * allowing fair competition with Running behavior
     *
     * @return int  step size
     */
    @Override
    public int move() {
        int step = this.random.nextInt(Flying.MAX_SPEED - Flying.MIN_SPEED) + Flying.MIN_SPEED;
        if (step > 80) step >>= 1;
        else step <<= 1;
        return step;
    }
}
