package task_03;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final int SHIPS_TYPES = 4;
    private List<Square> squares;
    private List<Square> surroundingSquares;
    private int shipSize;

    public Ship() {
        this.squares = new ArrayList<>(4);
        this.surroundingSquares = new ArrayList<>(14);
    }

    public Ship(int shipSize) {
        this();
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return this.shipSize;
    }

    public List<Square> getSquares() {
        return this.squares;
    }

    public List<Square> getSurroundingSquares() {
        return this.surroundingSquares;
    }

    /**
     * Check whether the ship is alive
     *
     * @return <code>true</code> if at least one cell from cellList isn't shot otherwise <code>false</code>
     */
    public boolean isAlive() {
        for (Square square : this.squares) {
            if (!square.isShot()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get maximum ship row index
     *
     * @return maximum ship row index
     */
    public int getMaxShipRow() {
        int maxShipRow = -1;
        for (Square square : this.squares) {
            if (maxShipRow < square.getRow()) {
                maxShipRow = square.getRow();
            }
        }
        return maxShipRow;
    }

    /**
     * Get minimum ship row index
     *
     * @return minimum ship row index
     */
    public int getMinShipRow() {
        int minShipRow = 100;
        for (Square square : this.squares) {
            if (minShipRow > square.getRow()) {
                minShipRow = square.getRow();
            }
        }
        return minShipRow;
    }

    /**
     * Get maximum ship column index
     *
     * @return maximum ship column index
     */
    public int getMaxShipCol() {
        int maxShipCol = -1;
        for (Square square : this.squares) {
            if (maxShipCol < square.getColumn()) {
                maxShipCol = square.getColumn();
            }
        }
        return maxShipCol;
    }

    /**
     * Get minimum ship column index
     *
     * @return minimum ship column index
     */
    public int getMinShipCol() {
        int minShipCol = 100;
        for (Square square : this.squares) {
            if (minShipCol > square.getColumn()) {
                minShipCol = square.getColumn();
            }
        }
        return minShipCol;
    }
}
