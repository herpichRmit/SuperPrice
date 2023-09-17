package superprice.catalog.product.model;

import java.util.Collection;

public class Category {
    String name;
    Collection<StructuredProduct> products;

    public Category(String name, Collection<StructuredProduct> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Collection<StructuredProduct> getProducts() {
        return products;
    }
}
