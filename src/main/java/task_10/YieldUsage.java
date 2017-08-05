package task_10;

public class YieldUsage {
    private static final Object key = new Object();

    /**
     * Shows usage of yield method
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.err.println(Thread.currentThread().getName() + " " + i);
                    Thread.yield();
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
