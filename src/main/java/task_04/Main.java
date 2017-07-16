package task_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringMadeWithOddLetters stringMadeWithOddLetters = new StringMadeWithOddLetters();
            System.out.println(stringMadeWithOddLetters.makeStringFromEvenLetters(reader.readLine()));

            Palindrome palindrome = new Palindrome();
            System.out.println(palindrome.isPalindrome(reader.readLine()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
