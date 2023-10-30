package task2;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] array3 = {11, 12, 13, 14, 15};

        SaveAsThread thread1 = new SaveAsThread("array1.txt", array1);
        SaveAsThread thread2 = new SaveAsThread("array2.txt", array2);
        SaveAsThread thread3 = new SaveAsThread("array3.txt", array3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все массивы записаны в файлы.");
    }
}

