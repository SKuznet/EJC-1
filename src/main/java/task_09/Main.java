package task_09;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] inputArray;
    private static Random random = new Random();

    public static void main(String[] args) {

        // radix sort
        System.out.println("Radix sort");
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        RadixSort radixSort = new RadixSort();
        radixSort.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));

        System.out.println();

        // selection sort
        System.out.println("Selection sort");
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(inputArray);
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
