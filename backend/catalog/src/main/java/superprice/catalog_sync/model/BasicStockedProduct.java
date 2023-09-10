package superprice.catalog_sync.model;

import javax.persistence.*;
import java.util.UUID;

public class BasicStockedProduct implements StockedProduct {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column
    private UUID uuid;
    @Column
    private Store store;
    @Column
    private int priceCents;
    @ManyToOne
    private Product product;

    BasicStockedProduct () {
        this.uuid = UUID.randomUUID();
    }

    public BasicStockedProduct (Product product, Store store, int priceCents) {
        this ();

        this.product = product;
        this.store = store;
        this.priceCents = priceCents;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Store getStore() {
        return store;
    }

    @Override
    public int getPriceCents() {
        return priceCents;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode () {
        return getUuid().hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if (obj instanceof  StockedProduct) {
            StockedProduct product = (StockedProduct) obj;

            return this.uuid.equals(product.getUuid ());
        } else {
            return false;
        }
    }
}
