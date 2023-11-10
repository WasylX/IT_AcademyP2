package task3;

public class Category {
    private String name;
    private Product[] products;

    public Category(String name, Product[] products) {
        this.name = name;
        this.products = products;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Product[] getProducts() {
        return products;
    }
}

