package task_10;

public class StartJoinUsage {

    /**
     * Shows how to use start and join methods
     *
     * @param args - command line arguments
     * @throws InterruptedException - could be thrown by join method
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.err.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        System.out.println("HI");
        thread.start();
        thread.join();
        System.out.println("GOODBYE");
    }
}
