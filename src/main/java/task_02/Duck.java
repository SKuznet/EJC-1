package task_02;

public abstract class Duck {
    private MovementBehavior movementBehavior;
    private int distanceTraveled;

    /**
     * Create a duck with a specific behavior
     *
     * @param movementBehavior could be Running or Flying
     */
    public Duck(MovementBehavior movementBehavior) {
        this.movementBehavior = movementBehavior;
        this.distanceTraveled = 0;
    }

    /**
     * Checking duck's behavior
     *
     * @return MovementBehavior could be Flying or Running
     */
    public MovementBehavior getMovementBehavior() {
        return this.movementBehavior;
    }

    /**
     * Making a move
     */
    public void move() {
        this.distanceTraveled += this.movementBehavior.move();
    }

    /**
     * Resetting traveled distance
     */
    public void resetDistanceTraveled() {
        this.distanceTraveled = 0;
    }

    /**
     * Getting traveled distance
     *
     * @return int
     */
    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }
}
