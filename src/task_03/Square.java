package task_03;

public class Square {
    private final int x;
    private final int y;
    private Status status;
    private Ship ship;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = Status.CLEAR;
        this.ship = null;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        this.status = Status.SHIPPED;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
