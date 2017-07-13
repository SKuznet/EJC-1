package task_03;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private Square[][] board = null;
  private List<Ship> ships = null;
  private int size = 0;

  public Board(int size) {
    this.size = size;
    board = new Square[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = new Square();
      }
    }
    ships = new ArrayList<Ship>();
  }

  public void placeShip(Ship s, int x, int y) throws Exception {
    if (x < 0 || x >= size || y < 0 || y >= size)
      throw new Exception("Position out of bounds. ");

    if (s.isVertical()) {
       for (int i = 0; i < s.getSize(); i++) {
         if (y + i >= size || board[x][y + i].hasShip()) {
           throw new Exception("Cannot place ship here");
         }
         board[x][y+i].setShip(s);
       }
    } else {
      for (int i = 0; i < s.getSize(); i++) {
        if (x + i >= size || board[x + i][y].hasShip()) {
          throw new Exception("Cannot place ship here");
        }
        board[x + i][y].setShip(s);
      }
    }

    ships.add(s);
  }

  public State fire(int x, int y) throws Exception {
    if (x < 0 || x >= size || y < 0 || y >= size)
      throw new Exception("Position out of bounds. ");

    Square s = board[x][y];
    if (s.hasBeenHit()) {
      throw new Exception("This position has been hit already!");
    }

    s.hit();

    if (s.hasShip()) {
      Ship ship = s.getShip();
      ship.hit();
      if (ship.isSunk()) {
        return hasWon()? State.WIN : State.SINK;
      } else {
        return State.HIT;
      }
    } else {
      return State.MISS;
    }
  }

  private boolean hasWon() {
    for (Ship s : ships) {
      if (!s.isSunk()) {
        return false;
      }
    }

    return true;
  }
}
