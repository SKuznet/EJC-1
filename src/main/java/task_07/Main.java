package task_07;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] inputArray;
    private static Random random = new Random();

    public static void main(String[] args) {

        // insertion sort
        System.out.println("Insertion sort");
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));

        System.out.println();

        // quick sort
        System.out.println("Quick sort");
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        QuickSort quickSort = new QuickSort();
        quickSort.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    /**
     * Fills input array with random integers
     *
     * @param arraySize - size of the array to create
     */
    private static void fillArrayWithRandomIntegers(int arraySize) {
        inputArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt(100);
        }
    }
}