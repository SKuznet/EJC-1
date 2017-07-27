package task_08;

public class BinarySearch {

    /**
     * Searches element in the array
     *
     * @param elementToFind - element which needs to be found
     * @param targetArray - array where we need to find element
     * @return int - position of the element in the array,
     *               -1 if it hasn't been found
     */
    public int search(int elementToFind, int[] targetArray) {
        int low = 0;
        int high = targetArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (elementToFind < targetArray[mid]) {
                high = mid - 1;
            }
            else if (elementToFind > targetArray[mid]) {
                low = mid + 1;
            }
            else return mid;
        }

        return -1;
    }
}
