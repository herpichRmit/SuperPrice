package superprice.catalog.model_old;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface Product {

    UUID getUuid ();
    String getName ();
    String getBrand ();
    String getSize ();
    String getDescription ();

    @JsonIgnoreProperties("product")
    @Nonnull
    Collection<StockedProduct> getPrices ();
    void addPrice (StockedProduct price);
    @JsonIgnoreProperties ("products")
    Category getCategory ();
    void setCategory (Category category);
}
