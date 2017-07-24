package task_08;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTest {
    private static int[] inputArray;
    private static int[] validationArray;
    private static Random random = new Random();

    /**
     * Checks bubble sort on elements from 1 to 1000
     */
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();

        for (int i = 1; i <= 1000 ; i++) {
            fillListWithRandomIntegers(i);

            bubbleSort.sort(inputArray);
            Arrays.sort(validationArray);

            Assert.assertArrayEquals(validationArray, inputArray);
        }
    }

    /**
     * Fills array with random integers
     *
     * @param arraySize - size of generated array
     */
    private static void fillListWithRandomIntegers(int arraySize) {
        inputArray = new int[arraySize];
        validationArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt(arraySize);
            validationArray[i] = inputArray[i];
        }
    }
}
