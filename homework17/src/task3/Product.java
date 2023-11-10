package task3;

import java.text.NumberFormat;
import java.util.Locale;

class Product {
    private String nameEn;
    private String nameRu;
    private String categoryEn;
    private String categoryRu;
    private double price;

    public Product(String nameEn, String nameRu, String categoryEn, String categoryRu, double price) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.categoryEn = categoryEn;
        this.categoryRu = categoryRu;
        this.price = price;
    }

    public String getName(Locale locale) {
        return locale.getLanguage().equals("ru") ? nameRu : nameEn;
    }

    public String getCategory(Locale locale) {
        return locale.getLanguage().equals("ru") ? categoryRu : categoryEn;
    }

    public double getPrice() {
        return price;
    }

    public String getLocalizedPrice(Locale locale, double exchangeRate) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double localPrice = locale.getLanguage().equals("ru") ? price * exchangeRate : price;
        return formatter.format(localPrice);
    }
}

