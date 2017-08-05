package task_10;

public class NotifyAllWaitUsage {
    private static final Object key = new Object();

    /**
     * Shows usage of Object's notifyAll, wait methods
     * within synchronized block
     *
     * @param args - command line arguments
     * @throws InterruptedException - could be thrown by wait method
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i == 3) {
                        synchronized (key) {
                            key.notifyAll();
                        }
                    }

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
        synchronized (key) {
            key.wait();
        }
        System.out.println("GOODBYE");
    }
}
