package superprice.catalog.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import superprice.catalog.util.ObjectMapperProvider;

import java.util.*;


@Entity
public class BasicProduct implements Product{
    private static ObjectMapper jsonMapper = ObjectMapperProvider.mapper();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private String size; // TODO update data type for size
    @Column
    private String description;
    @OneToMany (targetEntity = BasicStockedProduct.class)
    private Collection<StockedProduct> prices;

    @ManyToOne (targetEntity = BasicCategory.class)
    private Category category;


    private Map<Store, StockedProduct> pricesMap;

    BasicProduct () {
        this.uuid = UUID.randomUUID();
    }
    public BasicProduct (
            String name,
            String brand,
            String size,
            String description
    ) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.description = description;

        this.pricesMap = new HashMap<Store, StockedProduct>();
        this.prices = pricesMap.values();
    }

    @Override
    public String toString () {
        try {
            return jsonMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.toString();
        }
    }

    @Override
    public void addPrice(StockedProduct price) {
        pricesMap.put (price.getStore(), price);
        prices = pricesMap.values();
    }

    @Override
    public Category getCategory() { return this.category; }

    @Override
    public void setCategory(Category category) { this.category = category; }

    @Override
    public Collection <StockedProduct> getPrices() {
         return Collections.unmodifiableCollection (this.prices);
    }

    @Override
    public UUID getUuid () {
        return this.uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode () {
        return getUuid().hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        } else {
            Product product = (Product) obj;
            return product.getUuid().equals(this.getUuid());
        }
    }
}
