package task_02;

public class Duck {
    private MovementBehavior movementBehavior;
    private int distanceTraveled;

    public Duck(MovementBehavior movementBehavior) {
        this.movementBehavior = movementBehavior;
        this.distanceTraveled = 0;
    }

    public void setMovementBehavior(MovementBehavior movementBehavior) {
        this.movementBehavior = movementBehavior;
    }

    public void move() {
        this.distanceTraveled += this.movementBehavior.move();
    }

    public void resetDistanceTraveled() {
        this.distanceTraveled = 0;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }
}
