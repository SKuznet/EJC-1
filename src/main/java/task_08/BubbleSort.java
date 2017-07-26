package task_08;

public class BubbleSort {

    /**
     * Implementation of bubble sort
     *
     * @param inputArray - array of integers to sort
     */
    public void sort(int[] inputArray) {
        while (true) {
            boolean swapped = false;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    int elementToSwap = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = elementToSwap;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
