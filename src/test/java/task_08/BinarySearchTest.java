package task_08;

import org.junit.Test;

import java.util.Random;

public class BinarySearchTest {
    private int[] inputArray;
    private Random random = new Random();

    @Test
    public void testBinarySearch() {

    }

    /**
     * Fills array with random integers
     *
     * @param arraySize - size of generated array
     */
    private void fillListWithRandomIntegers(int arraySize) {
        inputArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt(arraySize);
        }
    }
}
