package task3;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Продукты с именами и категориями на двух языках
        Product pen = new Product(
                "Pen",
                "Ручка",
                "Stationery",
                "Канцелярия",
                1.99
        );
        Product notebook = new Product(
                "Notebook",
                "Тетрадь",
                "Stationery",
                "Канцелярия",
                4.99
        );

        double exchangeRate = 100.0; // 1 USD = 100 RUB

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

