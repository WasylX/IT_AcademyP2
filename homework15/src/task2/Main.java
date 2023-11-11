package task2;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        // Инициализация массива для сортировки
        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};

        // Создание ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Запуск алгоритма сортировки
        pool.invoke(new MergeSort(array));

        // Вывод отсортированного массива
        System.out.println(Arrays.toString(array));
    }
}

