package task1;

class ProductSumThread extends Thread {
    private final int[][] matrix;
    private final boolean useRows;
    private long sum = 0;

    public ProductSumThread(int[][] matrix, boolean useRows) {
        this.matrix = matrix;
        this.useRows = useRows;
    }

    @Override
    public void run() {
        if (useRows) {
            // Вычисляем произведение элементов в каждой строке и суммируем их
            for (int[] row : matrix) {
                long product = 1;
                for (int element : row) {
                    product *= element;
                }
                sum += product;
            }
        } else {
            // Вычисляем произведение элементов в каждом столбце и суммируем их
            for (int j = 0; j < matrix[0].length; j++) {
                long product = 1;
                for (int[] ints : matrix) {
                    product *= ints[j];
                }
                sum += product;
            }
        }
    }

    public long getSum() {
        return sum;
    }
}

