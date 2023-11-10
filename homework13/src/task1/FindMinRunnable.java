package task1;

class FindMinRunnable implements Runnable {
    private final int[] array;
    private int min;

    FindMinRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        min = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
    }

    public int getMin() {
        return min;
    }
}

