package task3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Product {
    private String key;
    private double price;

    public Product(String key, double price) {
        this.key = key;
        this.price = price;
    }

    public String getName(Locale locale) {
        ResourceBundle labels = ResourceBundle.getBundle("labels", locale);
        return labels.getString(key + ".name");
    }

    public String getCategory(Locale locale) {
        ResourceBundle labels = ResourceBundle.getBundle("labels", locale);
        return labels.getString(key + ".category");
    }

    public double getPrice() {
        return price;
    }

    public String getLocalizedPrice(Locale locale, double exchangeRate) {
        double localPrice = locale.getLanguage().equals(
                new Locale("ru").getLanguage()) ? price * exchangeRate : price;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(localPrice);
    }
}

