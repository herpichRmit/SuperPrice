package superprice.catalog.model_old;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

public interface StockedProduct {
    public UUID getUuid ();
    public Store getStore ();
    public int getPriceCents ();
    @JsonIgnoreProperties("prices")
    public Product getProduct ();
}
