package task_08;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] inputArray;
    private static Random random = new Random();

    public static void main(String[] args) {

        // bubble sort
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));

        // merge sort
//        fillArrayWithRandomIntegers(10);
//        System.out.println(inputArray);
//
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(inputArray);
//        System.out.println(inputArray);
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
