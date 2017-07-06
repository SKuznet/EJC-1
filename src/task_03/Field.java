package task_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private static final int dimensions = 10;
    private Random random = new Random();
    private ArrayList<Ship> ships = new ArrayList<>();
    private Square[][] squares = new Square[Field.dimensions][Field.dimensions];

    public Field() {
        for (int i = 0; i < Field.dimensions; i++) {
            for (int j = 0; j < Field.dimensions; j++) {
                squares[i][j] = new Square(i, j);
            }
        }

        // adding 4 one deck ships
        for (int i = 0; i < 4; i++) {
            this.ships.add(new Ship(DeckSize.ONE_DECK));
        }

        // adding 3 two deck ships
        for (int i = 0; i < 3; i++) {
            this.ships.add(new Ship(DeckSize.TWO_DECKS));
        }

        // adding 2 three deck ships
        for (int i = 0; i < 2; i++) {
            this.ships.add(new Ship(DeckSize.THREE_DECKS));
        }

        // adding 1 four deck ship
        for (int i = 0; i < 1; i++) {
            this.ships.add(new Ship(DeckSize.FOUR_DECKS));
        }
    }

    public void placeShip(Ship ship) {

        if (this.random.nextDouble() > 0.5) this.rotate();
    }

    public void rotate() {
        for (int i = 0; i < Field.dimensions; i++) {
            for (int j = 0; j < Field.dimensions; j++) {
                this.squares[i][j] = this.squares[j][i];
            }
        }
    }

    public void placeShips(List<Ship> ships) {
        for (Ship ship: ships) {
            this.placeShip(ship);
        }
    }
}
