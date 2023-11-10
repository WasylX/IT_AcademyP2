package task1;

class FindMaxRunnable implements Runnable {
    private final int[] array;
    private int max;

    FindMaxRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
    }

    public int getMax() {
        return max;
    }
}

