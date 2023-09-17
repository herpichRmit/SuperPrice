package superprice.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.UUID;

public interface Category {
    public UUID getUuid ();
    public String getName ();
    @JsonIgnoreProperties ("category")
    public Collection <Product> getProducts ();
    //public Image getImage ();

    public void addProduct (Product product);
}
