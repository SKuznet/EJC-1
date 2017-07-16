package task_03;

public class Ship {
    private int size = 0;
    private int hits = 0;

    // vertical == true; horizontal == false
    private boolean orientation = false;

    /**
     * Ship's constructor
     *
     * @param size        ship size
     * @param orientation orientation,
     *                    true - vertical
     *                    false - horizontal
     */
    public Ship(int size, boolean orientation) {
        this.size = size;
        this.orientation = orientation;
    }

    /**
     * Checks if ship is sunk
     *
     * @return boolean  true - ship is sunk,
     * false - is alive
     */
    public boolean isSunk() {
        return hits == size;
    }

    /**
     * Ship's got a hit
     */
    public void hit() {
        hits++;
    }

    /**
     * Checks ship's orientation
     *
     * @return boolean  true - vertical,
     * false - horizontal
     */
    public boolean isVertical() {
        return orientation;
    }

    /**
     * Gets ship's size
     *
     * @return int  ship's size
     */
    public int getSize() {
        return size;
    }
}
