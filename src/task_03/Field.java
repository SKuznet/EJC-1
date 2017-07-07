package task_03;

import java.util.Random;

public class Field {
    private static final int DIMENSIONS = 12;
    private int[][] field = new int[Field.DIMENSIONS][Field.DIMENSIONS];
    private Random random = new Random();

    public Field() {
        for (int i = 0; i < Field.DIMENSIONS; i++) {
            for (int j = 0; j < Field.DIMENSIONS; j++) {
                this.field[i][j] = 0;
            }
        }
    }

    public void placeShips {

    }
}
