package task3;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

class Basket {
    private Product[] products;
    private Locale locale;
    private double exchangeRate;

    public Basket(Product[] products, Locale locale, double exchangeRate) {
        this.products = products;
        this.locale = locale;
        this.exchangeRate = exchangeRate;
    }

    public void printReceipt() {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(dateFormatter.format(Calendar.getInstance().getTime()));

        String productHeader = locale.getLanguage().equals("ru") ? "Продукты" : "Product";
        String categoryHeader = locale.getLanguage().equals("ru") ? "Категория" : "Category";
        String priceHeader = locale.getLanguage().equals("ru") ? "Цена" : "Price";

        System.out.println(String.format("%-10s %-20s %-10s", productHeader, categoryHeader, priceHeader));

        System.out.println("----------------------------------------------------------");

        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
            System.out.println(
                    String.format("%-10s %-20s %-10s",
                            product.getName(locale),
                            product.getCategory(locale),
                            product.getLocalizedPrice(locale, exchangeRate)
                    ));
        }

        System.out.println("----------------------------------------------------------");

        System.out.println(
                        String.format("%-32s %-10s",
                        (locale.getLanguage().equals("ru") ? "Итого:" : "Total:"),
                        NumberFormat.getCurrencyInstance(locale).format(locale.getLanguage().equals("ru")
                                ? total * exchangeRate : total
                        )));
    }
}

