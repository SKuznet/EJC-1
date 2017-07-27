package task_07;

public class QuickSort implements SortingAlgorithm {
    private int[] inputArray;

    /**
     * Starts the quick sort
     *
     * @param inputArray - array of integers to sort
     */
    @Override
    public void sort(int[] inputArray) {
        this.inputArray = inputArray;
        quickSort(0, inputArray.length - 1);
    }

    /**
     * Implementation of quick sort
     *
     * @param low - lower boundary
     * @param high - higher boundary
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = this.inputArray[low + (high-low) / 2];

        while (i <= j) {
            while (this.inputArray[i] < pivot) {
                i++;
            }

            while (this.inputArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    /**
     * Exchanges two elements
     *
     * @param i - element in position i
     * @param j - element in position j
     */
    private void exchange(int i, int j) {
        int temp = this.inputArray[i];
        this.inputArray[i] = this.inputArray[j];
        this.inputArray[j] = temp;
    }
}
