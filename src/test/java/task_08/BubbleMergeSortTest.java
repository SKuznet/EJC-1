package task_08;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleMergeSortTest {
    private int[] inputArray;
    private int[] validationArray;
    private Random random = new Random();

    /**
     * Checks bubble sort on elements from 1 to 1000
     */
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        this.testSort(bubbleSort);
    }

    /**
     * Checks merge sort on elements from 1 to 1000
     */
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        this.testSort(mergeSort);
    }

    /**
     * Checks sorting algorithm on elements from 1 to 1000
     */
    private void testSort(SortingAlgorithm sortingAlgorithm) {
        for (int i = 1; i <= 1000 ; i++) {
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
