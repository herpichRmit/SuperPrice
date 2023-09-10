package superprice.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.UUID;

public interface Product {

    public UUID getUuid ();
    public String getName ();
    public String getBrand ();
    public String getSize ();
    public String getDescription ();

    @JsonIgnoreProperties("product")
    public Collection<StockedProduct> getPrices ();
    public void addPrice (StockedProduct price);
    @JsonIgnoreProperties ("products")
    public Category getCategory ();
    public void setCategory (Category category);
}
