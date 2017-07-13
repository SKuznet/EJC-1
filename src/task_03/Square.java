package task_03;

public class Square {
    private Ship ship = null;
    private boolean hasBeenHit = false;

    /**
     * Checks if the square was hit
     *
     * @return boolean  true - was hit,
     *                  false - still alive
     */
    public boolean hasBeenHit() {
          return hasBeenHit;
    }

    /**
     * Checks if a ship was placed
     * on the square
     *
     * @return boolean  true - contains ship,
     *                  false - no ship
     */
    public boolean hasShip() {
        return ship != null;
    }

    /**
     * Gets a link to the ship
     * contained by the square
     *
     * @return Ship link to the ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Sets a ship on the square
     *
     * @param ship  ships to be set here
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Marks the square as hit
     */
    public void hit() {
        hasBeenHit = true;
    }
}
