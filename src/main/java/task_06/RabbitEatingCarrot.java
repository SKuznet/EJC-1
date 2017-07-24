package task_06;

import java.io.IOException;

public class RabbitEatingCarrot {
    private static volatile boolean isEating = false;

    /**
     * Starts 2 threads: eating and stopping eating
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        new RabbitEatingCarrot.StartEating().start();
        new RabbitEatingCarrot.EatingInterrupted().start();
    }

    public static class StartEating extends Thread {

        /**
         * If the flag for eating is true then
         * prints the phrase that the rabbit is eating
         */
        @Override
        public void run() {
            isEating = true;
            System.err.println("The rabbit is eating...");
        }
    }

    public static class EatingInterrupted extends Thread {

        /**
         * Reads a byte from standard input stream
         * and marks the eating flag with false value
         */
        @Override
        public void run() {
            try {
                int input = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            isEating = false;
            System.err.println("The rabbit stopped eating,");
            System.err.println("because he was a heavy smoker and died of lung cancer");
        }
    }
}
