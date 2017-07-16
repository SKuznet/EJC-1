package task_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * Reads string, prints maximum number of same consequent letters
     * and number of unique letters
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = reader.readLine();

            CountDifferentLetters differentLetters = new CountDifferentLetters();
            CountSameLetters sameLetters = new CountSameLetters();

            System.out.println("Different letters: " + differentLetters.countDifferentLetters(inputString));
            System.out.println("Same consequent letters: " + sameLetters.countSameLetters(inputString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
