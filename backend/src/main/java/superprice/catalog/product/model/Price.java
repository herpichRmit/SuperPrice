package superprice.catalog.product.model;

import superprice.catalog.model.Store;

public class Price {
    Store store;
    int priceCents;

    public Price(Store store, int priceCents) {
        this.store = store;
        this.priceCents = priceCents;
    }

    public Store getStore() {
        return store;
    }

    public int getPriceCents() {
        return priceCents;
    }
}
