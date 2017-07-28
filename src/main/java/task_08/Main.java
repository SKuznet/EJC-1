package task_08;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] inputArray;
    private static Random random = new Random();

    public static void main(String[] args) {

        // bubble sort
        System.out.println("Bubble sort");
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));

        System.out.println();

        // merge sort
        System.out.println("Merge sort");
        fillArrayWithRandomIntegers(10);
        System.out.println(Arrays.toString(inputArray));

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));

        System.out.println();

        // binary search
        System.out.println("Binary search");
        fillArrayWithRandomIntegers(10);
        Arrays.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));

        BinarySearch binarySearch = new BinarySearch();
        int elementToFind = inputArray[random.nextInt(10)];
        System.out.println("Element to find: " + elementToFind);
        System.out.println("Result: " + binarySearch.search(elementToFind, inputArray));
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
