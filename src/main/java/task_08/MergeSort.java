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
     * @param low - lower boundary
     * @param high - upper boundary
     */
    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    /**
     * Merges two sub-arrays
     *
     * @param low - lower boundary
     * @param middle - middle boundary
     * @param high - upper boundary
     */
    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            this.helperArray[i] = this.inputArray[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (this.helperArray[i] <= this.helperArray[j]) {
                this.inputArray[k] = this.helperArray[i];
                i++;
            } else {
                this.inputArray[k] = this.helperArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            this.inputArray[k] = this.helperArray[i];
            k++;
            i++;
        }

    }
}
