package task3;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Product pen = new Product("pen", 1.99);
        Product notebook = new Product("notebook", 4.99);

        double exchangeRate = 100.0;

        Basket basketRu = new Basket(
                new Product[]{pen, notebook},
                new Locale("ru", "RU"),
                exchangeRate
        );
        basketRu.printReceipt();

        System.out.println();

        Basket basketEn = new Basket(
                new Product[]{pen, notebook},
                Locale.US,
                exchangeRate
        );
        basketEn.printReceipt();
    }
}

