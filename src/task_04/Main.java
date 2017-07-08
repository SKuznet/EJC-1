package task_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * Reads a string from the command line
     * and prints the new one created
     * with letters in even positions of input string
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = reader.readLine();
            StringBuilder s2 = new StringBuilder();

            for (int i = 0; i < s1.length(); i++) {
                if (i % 2 != 0)
                    s2.append(s1.charAt(i));
            }

            System.out.println(s2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
