package task5;

public class Main {
    private static final Object monitor = new Object();
    private static boolean state = false;
    private static int countdown = 30;

    public static void main(String[] args) {
        Thread sThread = new Thread(new SThread());
        Thread wThread = new Thread(new WThread());

        sThread.start();
        wThread.start();
    }

    static class SThread implements Runnable {
        @Override
        public void run() {
            while (countdown > 0) {
                synchronized (monitor) {
                    state = !state;
                    monitor.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class WThread implements Runnable {
        @Override
        public void run() {
            while (countdown > 0) {
                synchronized (monitor) {
                    while (!state) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (state) {
                        System.out.println(countdown);
                        countdown--;
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

