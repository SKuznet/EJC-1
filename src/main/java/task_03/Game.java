package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BattleShipGame represents simple console BattleShip game implementation
 * <p> In this version of game user have 60 shot attempts to kill all randomly arranged ships on game board
 *
 */
public class Game {
    private final int SHIPS_COUNT = 10;

    private final String LETTERS = "abcdefghij";

    private Board board;
    private int shotAttempts = 60;

    public Game() {
        this.board = new Board();
    }

    /**
     * Start game
     * <p>
     * <p>User can choose between: exit game, reset game, enter shot coordinates
     */
    public void startGame() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            showMenu();

            nextPlayerChoice:
            while (shotAttempts > 0) {
                String playerChoice = reader.readLine().toUpperCase();

                switch (playerChoice) {

                    case "1":
                        this.board.reArrangeGameBoard();
                        shotAttempts = 60;
                        showMenu();
                        break;

                    case "0":
                        System.out.println("Good Bye!");
                        return;

                    default:
                        if (playerChoice.matches("[a-jA-J]([1-9]|10)")) {
                            int col = this.LETTERS.indexOf(playerChoice.charAt(0));
                            int row = Integer.parseInt(playerChoice.substring(1, playerChoice.length())) - 1;
                            int hit = this.board.markShot(row, col);
                            if (hit > -1) {
                                --shotAttempts;
                                if (this.board.getAliveShipsCount() == 0) {
                                    break nextPlayerChoice;
                                }
                                showMenu();
                                if (hit > 0) {
                                    System.out.println("HIT!");
                                } else {
                                    System.out.println("MISS!");
                                }
                                break;
                            }
                        }
                        System.out.println("Invalid input. Try again.");
                        break;
                }
            }
            if (shotAttempts > 0) {
                System.out.println("You won! Congrats");
            } else {
                System.out.println("Game Over. You lost this game. Better luck next time!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show game information and menu
     */
    private void showMenu() {
        System.out.println("\nThe battleship game");
        System.out.println("Options: 1 - reset game, 0 - exit");
        System.out.println("Choose a square like b2, d5 etc.");
        System.out.println();

        System.out.print("   ");
        for (int i = 0, n = this.LETTERS.length(); i < n; ++i) {
            System.out.print(this.LETTERS.charAt(i) + "  ");
        }
        System.out.println();

        this.board.showGameBoard();
        System.out.println();

        System.out.println("Info:\n\".\" - empty cell  \"o\" - miss cell  \"*\" - hit cell");
        System.out.print("Ships alive: " + this.board.getAliveShipsCount() + "  ");
        System.out.print("Ships destroyed: " + (this.SHIPS_COUNT - this.board.getAliveShipsCount()) + "  ");
        System.out.println("Shots remain: " + shotAttempts);
    }
}
