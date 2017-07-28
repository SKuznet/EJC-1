package task_09;

import java.util.Arrays;

public class RadixSort implements SortingAlgorithm{

    /**
     * Calls radix sort
     *
     * @param inputArray - array of integers to sort
     */
    @Override
    public void sort(int[] inputArray) {
        radixSort(inputArray);
    }

    /**
     * Finds maximum number in the array
     *
     * @param inputArray - array where to search
     * @return int - maximum number
     */
    private int getMaxNumber(int[] inputArray) {
        int maxNumber = inputArray[0];
        for (int i = 1; i < inputArray.length; i++)
            if (inputArray[i] > maxNumber)
                maxNumber = inputArray[i];
        return maxNumber;
    }

    /**
     * Implementation of counting sort
     *
     * @param inputArray - array to sort
     * @param rank - max rank of number
     */
    private void countSort(int inputArray[], int rank) {
        int outputArray[] = new int[inputArray.length];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < inputArray.length; i++)
            count[(inputArray[i] / rank) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = inputArray.length - 1; i >= 0; i--)
        {
            outputArray[count[(inputArray[i] / rank) % 10 ] - 1] = inputArray[i];
            count[(inputArray[i] / rank) % 10]--;
        }

        for (i = 0; i < inputArray.length; i++)
            inputArray[i] = outputArray[i];
    }

    /**
     * Implementation of radix sort
     *
     * @param inputArray - array to sort
     */
    private void radixSort(int inputArray[]) {
        int maxNumber = getMaxNumber(inputArray);

        for (int rank = 1; maxNumber / rank > 0; rank *= 10)
            countSort(inputArray, rank);
    }
}
