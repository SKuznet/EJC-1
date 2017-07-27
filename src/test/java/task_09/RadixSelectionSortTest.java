package task_09;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class RadixSelectionSortTest {
        private int[] inputArray;
        private int[] validationArray;
        private Random random = new Random();

        /**
         * Checks radix sort on elements from 1 to 3000
         */
        @Test
        public void testRadixSort() {
            RadixSort radixSort = new RadixSort();
            this.testSort(radixSort);
        }

        /**
         * Checks selection sort on elements from 1 to 3000
         */
        @Test
        public void testSelectionSort() {
            SelectionSort selectionSort = new SelectionSort();
            this.testSort(selectionSort);
        }

        /**
         * Checks sorting algorithm on elements from 1 to 3000
         */
        private void testSort(SortingAlgorithm sortingAlgorithm) {
            for (int i = 1; i <= 3000 ; i++) {
                fillListWithRandomIntegers(i);

                sortingAlgorithm.sort(inputArray);
                Arrays.sort(validationArray);

                Assert.assertArrayEquals(validationArray, inputArray);
            }
        }

        /**
         * Fills array with random integers
         *
         * @param arraySize - size of generated array
         */
        private void fillListWithRandomIntegers(int arraySize) {
            inputArray = new int[arraySize];
            validationArray = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                inputArray[i] = random.nextInt(arraySize);
                validationArray[i] = inputArray[i];
            }
        }
}
