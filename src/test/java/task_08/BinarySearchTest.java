package task_08;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {
    private int[] inputArray;
    private Random random = new Random();

    @Test
    public void testBinarySearch() {
        fillArrayWithRandomIntegers(100);
        Arrays.sort(inputArray);

        BinarySearch binarySearch = new BinarySearch();
        int elementToFind = inputArray[random.nextInt(100)];
        Assert.assertEquals(Arrays.binarySearch(inputArray, elementToFind), binarySearch.search(elementToFind, inputArray));

        elementToFind = Integer.MAX_VALUE;
        Assert.assertEquals(-1, binarySearch.search(elementToFind, inputArray));
    }

    /**
     * Fills array with random integers
     *
     * @param arraySize - size of generated array
     */
    private void fillArrayWithRandomIntegers(int arraySize) {
        inputArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt(arraySize);
        }
    }
}
