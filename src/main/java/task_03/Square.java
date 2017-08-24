package task_03;

public class Square {
    private boolean hasBeenShot = false;
    private boolean containsShip = false;
    private int row = -1;
    private int column = -1;

    /**
     * Constructs in specified position
     *
     * @param row - vertical of the square
     * @param column - horizontal position of the square
     */
    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Sets square's row
     *
     * @param row - square's vertical position
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Returns square's vertical position
     *
     * @return int - square's vertical position
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Sets square's horizontal position
     *
     * @param column - square's horizontal position to be set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Returns square's horizontal position
     *
     * @return int - square's horizontal position
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Checks if the square has been shot
     *
     * @return boolean - square is dead or alive
     */
    public boolean isShot() {
        return this.hasBeenShot;
    }

    /**
     * Sets square's flag is it's been shot
     *
     * @param isShot - sets specific flag
     */
    public void setShotFlag(boolean isShot) {
        this.hasBeenShot = isShot;
    }

    /**
     * Checks if square is part of the ship
     *
     * @return boolean - square is part of the ship or not
     */
    public boolean containsShip() {
        return this.containsShip;
    }

    public void setPartOfTheShip(boolean isPartOfTheShip) {
        this.containsShip = isPartOfTheShip;
    }

    /**
     * reset cell state by setting cell is not part of ship and is not shot
     */
    public void emptySquare() {
        this.hasBeenShot = false;
        this.containsShip = false;
    }
}
