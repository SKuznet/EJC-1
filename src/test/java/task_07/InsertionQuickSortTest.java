package task_07;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionQuickSortTest {
    private int[] inputArray;
    private int[] validationArray;
    private Random random = new Random();

    /**
     * Checks insertion sort on elements from 1 to 2000
     */
    @Test
    public void testInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        this.testSort(insertionSort);
    }

    /**
     * Checks quick sort on elements from 1 to 2000
     */
    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        this.testSort(quickSort);
    }

    /**
     * Checks sorting algorithm on elements from 1 to 2000
     */
    private void testSort(SortingAlgorithm sortingAlgorithm) {
        for (int i = 1; i <= 2000 ; i++) {
            fillArrayWithRandomIntegers(i);

            sortingAlgorithm.sort(inputArray);
            Arrays.sort(validationArray);

            Assert.assertArrayEquals(validationArray, inputArray);
        }
    }

    /**
     * Fills array with random integers
     *
     * @param arraySize - size of generated array
     */
    private void fillArrayWithRandomIntegers(int arraySize) {
        inputArray = new int[arraySize];
        validationArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt(arraySize);
            validationArray[i] = inputArray[i];
        }
    }
}
