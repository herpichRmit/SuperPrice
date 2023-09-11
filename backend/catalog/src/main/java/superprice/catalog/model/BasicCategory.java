package superprice.catalog.model;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Entity
public class BasicCategory implements Category {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column
    private UUID uuid;
    @Column
    private String name;
    @OneToMany (targetEntity = BasicProduct.class)
    private Set<Product> products;

    BasicCategory () {
        this.uuid = UUID.randomUUID();
    }
    public BasicCategory (String name){
        this ();

        this.name = name;
    }

    public void addProduct (Product product) {
        this.products.add(product);
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(this.getProducts());
    }

    @Override
    public Image getImage() {
        // TODO

        return null;
    }
}
