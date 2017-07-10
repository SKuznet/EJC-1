package task_04;

public class StringMadeWithOddLetters {

    /**
     * Creates a new String made with letters in even positions of input string
     *
     * @param inputString   String to be processed
     */
    public String makeStringFromEvenLetters(String inputString) {
        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            if (i % 2 != 0)
                outputString.append(inputString.charAt(i));
        }

        return outputString.toString();
    }
}
