package superprice.catalog.product.model;

import java.util.Collection;

public class StructuredProduct {
    String name;
    String brand;
    String size;
    Collection<Price> prices;

    public StructuredProduct(String name, String brand, String size, Collection<Price> prices) {
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    public Collection<Price> getPrices() {
        return prices;
    }
}
