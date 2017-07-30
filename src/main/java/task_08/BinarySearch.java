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
        int lowerBoundary = 0;
        int higherBoundary = targetArray.length - 1;

        while (lowerBoundary <= higherBoundary) {
            int middleBoundary = lowerBoundary + (higherBoundary - lowerBoundary) / 2;

            if (elementToFind < targetArray[middleBoundary]) {
                higherBoundary = middleBoundary - 1;
            }
            else if (elementToFind > targetArray[middleBoundary]) {
                lowerBoundary = middleBoundary + 1;
            }
            else {
                return middleBoundary;
            }
        }

        return -1;
    }
}
