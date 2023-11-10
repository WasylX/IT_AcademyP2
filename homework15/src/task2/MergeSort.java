package task2;

import java.util.concurrent.RecursiveAction;
import java.util.Arrays;

public class MergeSort extends RecursiveAction {
    private final int[] array;
    private final int left;
    private final int right;

    public MergeSort(int[] array) {
        this(array, 0, array.length - 1);
    }

    private MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int middle = (left + right) / 2;

            // Выполнить сортировку для двух половинок
            invokeAll(new MergeSort(array, left, middle), new MergeSort(array, middle + 1, right));

            // Слить отсортированные половинки
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Скопировать оставшиеся элементы, если они есть
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}

