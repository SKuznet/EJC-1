package task_09;

public class SelectionSort implements SortingAlgorithm {

    /**
     * Calls selection sort
     *
     * @param inputArray - array to sort
     */
    @Override
    public void sort(int[] inputArray) {
        selectionSort(inputArray);
    }

    /**
     * Implementation of selection sort
     *
     * @param inputArray - array to sort
     */
    private void selectionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < inputArray.length; j++)
                if (inputArray[j] < inputArray[index])
                    index = j;

            int smallerNumber = inputArray[index];
            inputArray[index] = inputArray[i];
            inputArray[i] = smallerNumber;
        }
    }
}
