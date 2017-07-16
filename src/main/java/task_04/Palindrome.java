package task_04;

public class Palindrome {

    /**
     * Reads a string from the command line
     * and checks if it's a palindrome or not
     *
     * @param inputString String to be checked
     * @return boolean  true - palindrome, false - not palindrome
     */
    public boolean isPalindrome(String inputString) {
        String inputWithoutSpaces = inputString.replace(" ", "");
        StringBuilder reversedString = new StringBuilder(inputWithoutSpaces).reverse();

        return inputWithoutSpaces.equals(reversedString.toString());
    }
}
