package task_08;

public class BubbleSort implements SortingAlgorithm{

    /**
     * Implementation of bubble sort
     *
     * @param inputArray - array of integers to sort
     */
    @Override
    public void sort(int[] inputArray) {
        while (true) {
            int numberOfElementsInPlace = 0;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    int elementToSwap = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = elementToSwap;
                }
                else {
                    numberOfElementsInPlace++;
                }
            }
            if (numberOfElementsInPlace == inputArray.length - 1) {
                break;
            }
        }
    }
}
