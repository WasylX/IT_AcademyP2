package task1;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 4; // Задаем количество строк
        int m = 5; // Задаем количество столбцов
        int[][] matrix = new int[n][m]; // Инициализируем матрицу
        Random random = new Random();

        // Заполняем матрицу случайными значениями
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(10) + 1; // Значения от 1 до 10
            }
        }

        // Создаем и запускаем потоки
        ProductSumThread rowThread = new ProductSumThread(matrix, true);
        ProductSumThread columnThread = new ProductSumThread(matrix, false);
        rowThread.start();
        columnThread.start();

        // Ждем завершения потоков
        rowThread.join();
        columnThread.join();

        // Получаем и сравниваем суммы
        long rowSum = rowThread.getSum();
        long columnSum = columnThread.getSum();

        System.out.println("Sum of the products of rows: " + rowSum);
        System.out.println("Sum of the products of columns: " + columnSum);

        if (rowSum > columnSum) {
            System.out.println("Row sum is greater.");
        } else if (columnSum > rowSum) {
            System.out.println("Column sum is greater.");
        } else {
            System.out.println("Both sums are equal.");
        }
    }
}

