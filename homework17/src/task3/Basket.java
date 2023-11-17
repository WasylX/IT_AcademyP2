package task3;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Basket {
    private Product[] products;
    private Locale locale;
    private double exchangeRate;

    public Basket(Product[] products, Locale locale, double exchangeRate) {
        this.products = products;
        this.locale = locale;
        this.exchangeRate = exchangeRate;
    }

    private String getLocalizedString(String key) {
        ResourceBundle labels = ResourceBundle.getBundle("labels", locale);
        return labels.getString(key);
    }

    public void printReceipt() {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(dateFormatter.format(Calendar.getInstance().getTime()));

        String productHeader = getLocalizedString("product");
        String categoryHeader = getLocalizedString("category");
        String priceHeader = getLocalizedString("price");

        System.out.println(String.format("%-10s %-20s %-10s", productHeader, categoryHeader, priceHeader));
        System.out.println("----------------------------------------------------------");

        double total = 0;
        for (Product product : products) {
            double productPrice = product.getPrice();
            total += productPrice;
            System.out.println(
                    String.format("%-10s %-20s %-10s",
                            product.getName(locale),
                            product.getCategory(locale),
                            product.getLocalizedPrice(locale, exchangeRate)
                    ));
        }

        System.out.println("----------------------------------------------------------");
        double totalLocalized = locale.getLanguage().equals(
                new Locale("ru").getLanguage()) ? total * exchangeRate : total;
        System.out.println(
                String.format("%-32s %-10s", getLocalizedString("total"), formatCurrency(totalLocalized))
        );
    }

    private String formatCurrency(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(amount);
    }
}

