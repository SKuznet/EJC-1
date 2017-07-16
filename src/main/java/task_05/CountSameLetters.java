package task_05;

public class CountSameLetters {

    /**
     * Counts maximum equal consequent letters size
     *
     * @param inputString   string to process
     * @return  int maximum sequence size
     */
    public int countSameLetters(String inputString) {
        int tempCounter = 0;
        int maxCounter = 0;

        if (inputString.length() >= 1) {
            tempCounter = 1;
            maxCounter = 1;

            for (int i = 1; i < inputString.length(); i++) {
                if (inputString.charAt(i) == inputString.charAt(i-1)) {
                    tempCounter++;
                }
                else {
                    if (tempCounter > maxCounter) {
                        maxCounter = tempCounter;
                    }
                    tempCounter = 1;
                }
            }

            if (tempCounter > maxCounter) {
                maxCounter = tempCounter;
            }
        }

        return maxCounter;
    }
}
