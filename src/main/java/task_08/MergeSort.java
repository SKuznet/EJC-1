package task_08;

public class MergeSort implements SortingAlgorithm {
    private int[] inputArray;
    private int[] helperArray;

    /**
     * Starts the merge sort
     *
     * @param inputArray - array of integers to sort
     */
    @Override
    public void sort(int[] inputArray) {
        this.inputArray = inputArray;
        this.helperArray = new int[inputArray.length];
        mergeSort(0, inputArray.length - 1);
    }

    /**
     * Implementation of merge sort
     *
     * @param lowerBoundary - lower boundary
     * @param higherBoundary - upper boundary
     */
    private void mergeSort(int lowerBoundary, int higherBoundary) {
        if (lowerBoundary < higherBoundary) {
            int middleBoundary = lowerBoundary + (higherBoundary - lowerBoundary) / 2;
            mergeSort(lowerBoundary, middleBoundary);
            mergeSort(middleBoundary + 1, higherBoundary);
            merge(lowerBoundary, middleBoundary, higherBoundary);
        }
    }

    /**
     * Merges two sub-arrays
     *
     * @param lowerBoundary - lower boundary
     * @param middleBoundary - middle boundary
     * @param higherBoundary - upper boundary
     */
    private void merge(int lowerBoundary, int middleBoundary, int higherBoundary) {

        for (int i = lowerBoundary; i <= higherBoundary; i++) {
            this.helperArray[i] = this.inputArray[i];
        }

        int i = lowerBoundary;
        int j = middleBoundary + 1;
        int k = lowerBoundary;

        while (i <= middleBoundary && j <= higherBoundary) {
            if (this.helperArray[i] <= this.helperArray[j]) {
                this.inputArray[k] = this.helperArray[i];
                i++;
            } else {
                this.inputArray[k] = this.helperArray[j];
                j++;
            }
            k++;
        }

        while (i <= middleBoundary) {
            this.inputArray[k] = this.helperArray[i];
            k++;
            i++;
        }

    }
}
