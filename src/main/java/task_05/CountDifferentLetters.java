package task_05;

import java.util.HashSet;

public class CountDifferentLetters {

    /**
     * Counts unique letters
     *
     * @param inputString   string to process
     * @return  int number of unique letters
     */
    public int countDifferentLetters(String inputString) {
        HashSet<String> letters = new HashSet<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isLetter(inputString.charAt(i))) {
                letters.add(String.valueOf(inputString.charAt(i)));
            }
        }

        return letters.size();
    }
}
