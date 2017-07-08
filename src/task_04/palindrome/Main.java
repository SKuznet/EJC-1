package task_04.palindrome;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * Reads a string from the command line
     * and checks if it's a palindrome or not
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = reader.readLine().replace(" ", "");
            StringBuilder s2 = new StringBuilder(s1).reverse();

            System.out.println(s1.equals(s2.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
