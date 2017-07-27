package task_07;

public class InsertionSort implements SortingAlgorithm {

    /**
     * Implementation of insertion sort
     *
     * @param inputArray - array of integers to sort
     */
    @Override
    public void sort(int[] inputArray) {
        int temp;
        for (int i = 1; i < inputArray.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(inputArray[j] < inputArray[j-1]){
                    temp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = temp;
                }
            }
        }
    }
}
