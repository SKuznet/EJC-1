package task_03;

import java.util.ArrayList;
import java.util.List;

/**
 * GameBoard represents game board with cells for BattleShip game
 *
 */
class GameBoard {
    private final int BOARD_SIZE = 10;
    private final int SHIPS_TYPES = 4;
    private final int MAX_SHIP_SIZE = 4;

    private final char EMPTY_CELL = '.';
    private final char MISS_SHOT_CELL = 'o';
    private final char SHIP_SHOT_CELL = '*';




    private Cell[][] gameBoardCells;
    /**
     * list with available cells to be parts of the ship
     */
    private List<Cell> availableCellList;
    private List<Ship> shipList;

    GameBoard() {
        this.gameBoardCells = new Cell[this.BOARD_SIZE][this.BOARD_SIZE];
        this.availableCellList = new ArrayList<>(this.BOARD_SIZE * this.BOARD_SIZE);
        this.shipList = new ArrayList<>();
        makeRandomBoard();
    }

    /**
     * Initialize cells, put cells in availableCellList, random arrange each ship on game board
     * <p>In order to avoid the impossibility of arranging ships start arranging from longest ships to shortest
     */
    private void makeRandomBoard() {
        for (int i = 0; i < gameBoardCells.length; ++i) {
            for (int j = 0; j < gameBoardCells[i].length; ++j) {
                if (gameBoardCells[i][j] == null) {
                    gameBoardCells[i][j] = new Cell(i, j);
                } else {
                    gameBoardCells[i][j].clearCell();
                }
                availableCellList.add(gameBoardCells[i][j]);
            }
        }
        int size = this.MAX_SHIP_SIZE;
        for (int count = 0; count < this.SHIPS_TYPES; ++count, --size) {
            for (int i = 0; i <= count; ++i) {
                arrangeShip(new Ship(size));
            }
        }
    }

    /**
     * Put ship on game board
     * <p>create positionList with all possible ship positions, both vertical and horizontal,
     * choose randomly position from positionList, set cells from this position as parts of current ship,
     * remove all ship cells from availableCellList, set shadow of the ship, add ship in shipList
     *
     * @param ship represents ship to arrange on game board
     */
    private void arrangeShip(Ship ship) {
        int shipSize = ship.getShipSize();
        Cell cell = availableCellList.get((int) (Math.random() * availableCellList.size()));
        if (shipSize > 1) {
            List<List<Cell>> positionList = new ArrayList<>(shipSize * 2);
            List<Cell> currentPositionList;
            nextPositionHorizontal:
            for (int i = 0; i < shipSize; ++i) {
                currentPositionList = new ArrayList<>(shipSize);
                for (int j = 0; j < shipSize; ++j) {
                    if (cell.getRow() - i + j < gameBoardCells.length && cell.getRow() - i + j >= 0
                            && availableCellList.contains(gameBoardCells[cell.getRow() - i + j][cell.getCol()])) {
                        currentPositionList.add(gameBoardCells[cell.getRow() - i + j][cell.getCol()]);
                    } else {
                        continue nextPositionHorizontal;
                    }
                }
                positionList.add(currentPositionList);
            }
            nextPositionVertical:
            for (int i = 0; i < shipSize; ++i) {
                currentPositionList = new ArrayList<>(shipSize);
                for (int j = 0; j < shipSize; ++j) {
                    if (cell.getCol() - i + j < gameBoardCells[0].length && cell.getCol() - i + j >= 0
                            && availableCellList.contains(gameBoardCells[cell.getRow()][cell.getCol() - i + j])) {
                        currentPositionList.add(gameBoardCells[cell.getRow()][cell.getCol() - i + j]);
                    } else {
                        continue nextPositionVertical;
                    }
                }
                positionList.add(currentPositionList);
            }
            currentPositionList = positionList.get((int) (Math.random() * positionList.size()));
            for (Cell currCell : currentPositionList) {
                currCell.setPartOfShip(true);
                ship.getCellList().add(currCell);
            }
        } else if (shipSize == 1) {
            cell.setPartOfShip(true);
            ship.getCellList().add(cell);
        }
        availableCellList.removeAll(ship.getCellList());
        setShipShadow(ship);
        shipList.add(ship);
    }

    /**
     * Add cells which surround ship into ship.cellShadowList and remove these cells from availableCellList
     * <p>Determines ship surrounding cells taking into account the bounds of game board
     *
     * @param ship represents ship to set ship.cellShadowList
     */
    private void setShipShadow(Ship ship) {
        boolean isExistMinRow = ship.getMinShipRow() > 0;
        boolean isExistMaxRow = ship.getMaxShipRow() + 1 != gameBoardCells.length;
        boolean isExistMinCol = ship.getMinShipCol() > 0;
        boolean isExistMaxCol = ship.getMaxShipCol() + 1 != gameBoardCells[0].length;
        int minShadowRow = isExistMinRow ? ship.getMinShipRow() - 1 : ship.getMinShipRow();
        int maxShadowRow = isExistMaxRow ? ship.getMaxShipRow() + 1 : ship.getMaxShipRow();
        int minShadowCol = isExistMinCol ? ship.getMinShipCol() - 1 : ship.getMinShipCol();
        int maxShadowCol = isExistMaxCol ? ship.getMaxShipCol() + 1 : ship.getMaxShipCol();
        int verticalStartPos = isExistMinRow ? 1 : 0;
        int verticalLength = isExistMaxRow ? maxShadowRow - minShadowRow : maxShadowRow - minShadowRow + 1;
        int horLength = maxShadowCol - minShadowCol + 1;

        for (int i = 0; i < horLength; ++i) {
            if (isExistMinRow) {
                ship.getCellShadowList().add(gameBoardCells[minShadowRow][minShadowCol + i]);
            }
            if (isExistMaxRow) {
                ship.getCellShadowList().add(gameBoardCells[maxShadowRow][minShadowCol + i]);
            }
        }
        for (int i = verticalStartPos; i < verticalLength; ++i) {
            if (isExistMinCol) {
                ship.getCellShadowList().add(gameBoardCells[minShadowRow + i][minShadowCol]);
            }
            if (isExistMaxCol) {
                ship.getCellShadowList().add(gameBoardCells[minShadowRow + i][maxShadowCol]);
            }
        }
        availableCellList.removeAll(ship.getCellShadowList());
    }

    /**
     * Clear game board and randomly make new game board ready to play
     */
    void reArrangeGameBoard() {
        availableCellList.clear();
        shipList.clear();
        makeRandomBoard();
    }

    /**
     * Mark cell after shot and find out information about shot result
     *
     * @param row row index of the cell
     * @param col column index of the cell
     * @return <code>-1</code> if cell has been already shot
     * <code>0</code> if cell is empty and has not been already shot
     * <code>1</code> if cell is part of the ship and has not been already shot
     */
    int markShot(int row, int col) {
        if (gameBoardCells[row][col].isShot()) {
            return -1;
        }
        gameBoardCells[row][col].setShot(true);
        if (gameBoardCells[row][col].isPartOfShip()) {
            Ship currentShip = null;
            for (Ship ship : shipList) {
                if (ship.getCellList().contains(gameBoardCells[row][col])) {
                    currentShip = ship;
                }
            }
            if (currentShip != null && !currentShip.isAlive()) {
                for (Cell shadowCell : currentShip.getCellShadowList()) {
                    shadowCell.setShot(true);
                }
                shipList.remove(currentShip);
            }
            return 1;
        }
        return 0;
    }

    /**
     * Count alive ships
     *
     * @return count of alive ships
     */
    int getAliveShipsCount() {
        return shipList.size();
    }

    /**
     * Print game board in console
     */
    void showGameBoard() {
        for (int i = 0; i < this.BOARD_SIZE; ++i) {
            int rowNum = i + 1;
            if (rowNum != this.BOARD_SIZE) {
                System.out.print(rowNum + "  ");
            } else {
                System.out.print(rowNum + " ");
            }
            for (int j = 0; j < this.BOARD_SIZE; ++j) {
                if (gameBoardCells[i][j].isShot()) {
                    if (gameBoardCells[i][j].isPartOfShip()) {
                        System.out.print(this.SHIP_SHOT_CELL + "  ");
                    } else {
                        System.out.print(this.MISS_SHOT_CELL + "  ");
                    }
                } else {
                    System.out.print(this.EMPTY_CELL + "  ");
                }
            }
            System.out.println();
        }
    }
}
