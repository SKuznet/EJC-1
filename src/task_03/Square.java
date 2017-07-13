package task_03;

public class Square {
  private Ship ship = null;
  private boolean hasBeenHit = false;

  public Square() {
  }

  public boolean hasBeenHit() {
    return hasBeenHit;
  }

  public boolean hasShip() {
    return ship != null;
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public void hit() {
    hasBeenHit = true;
  }
}
