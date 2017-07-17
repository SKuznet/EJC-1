package task_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Square[][] board = null;
    private List<Ship> ships = null;
    private int size = 0;
    private Random random = new Random();

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

    /**
     * Initializing the board with ships
     */
    public void initialize() {
        // 1 4-square ship
        this.ships.add(new Ship(4, this.random.nextBoolean()));

        // 2 3-square ships
        for (int i = 0; i < 2; i++) {
            this.ships.add(new Ship(3, this.random.nextBoolean()));
        }

        // 3 2-square ships
        for (int i = 0; i < 3; i++) {
            this.ships.add(new Ship(2, this.random.nextBoolean()));
        }

        // 4 1-square ships
        for (int i = 0; i < 4; i++) {
            this.ships.add(new Ship(1, this.random.nextBoolean()));
        }

        // temporary position for placing ship
        int x = 0;
        int y = 0;
        for (Ship ship: this.ships) {
            x = this.random.nextInt(size);
            y = this.random.nextInt(size);
            while (true) {
                try {
                    this.placeShip(ship, x, y);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    x = this.random.nextInt(size);
                    y = this.random.nextInt(size);
                }
            }
        }
    }

    /**
     * String representation of the board
     *
     * @return String   representation of the board
     */
    @Override
    public String toString() {
        return "";
    }
}
