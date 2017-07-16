package task_03;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Square[][] board = null;
    private List<Ship> ships = null;
    private int size = 0;

    /**
     * Sets up the board
     *
     * @param size size of the board
     */
    public Board(int size) {
        this.size = size;
        board = new Square[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Square();
            }
        }
        ships = new ArrayList<>();
    }

    /**
     * Places a ship on the board
     *
     * @param s ship
     * @param x x coordinate
     * @param y y coordinate
     * @throws ArrayIndexOutOfBoundsException is thrown if coordinates are incorrect
     */
    public void placeShip(Ship s, int x, int y) throws ArrayIndexOutOfBoundsException {
        if (x < 0 || x >= size || y < 0 || y >= size)
            throw new ArrayIndexOutOfBoundsException("Position out of bounds!");

        if (s.isVertical()) {
            for (int i = 0; i < s.getSize(); i++) {
                if (y + i >= size || board[x][y + i].hasShip()) {
                    throw new ArrayIndexOutOfBoundsException("Cannot place ship here!");
                }
                board[x][y + i].setShip(s);
            }
        } else {
            for (int i = 0; i < s.getSize(); i++) {
                if (x + i >= size || board[x + i][y].hasShip()) {
                    throw new ArrayIndexOutOfBoundsException("Cannot place ship here!");
                }
                board[x + i][y].setShip(s);
            }
        }

        ships.add(s);
    }

    /**
     * Performs an attack
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return State    result of attack
     * @throws ArrayIndexOutOfBoundsException is thrown if coordinates are incorrect
     */
    public State fire(int x, int y) throws ArrayIndexOutOfBoundsException {
        if (x < 0 || x >= size || y < 0 || y >= size)
            throw new ArrayIndexOutOfBoundsException("Position out of bounds!");

        Square s = board[x][y];
        if (s.hasBeenHit()) {
            throw new ArrayIndexOutOfBoundsException("This position has been hit already!");
        }

        s.hit();

        if (s.hasShip()) {
            Ship ship = s.getShip();
            ship.hit();
            if (ship.isSunk()) {
                return hasWon() ? State.WIN : State.SINK;
            } else {
                return State.HIT;
            }
        } else {
            return State.MISS;
        }
    }

    /**
     * Checks if player has won
     *
     * @return boolean  true - win,
     * false - battle continues
     */
    private boolean hasWon() {
        for (Ship s : ships) {
            if (!s.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
