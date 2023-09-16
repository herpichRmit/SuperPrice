package superprice.catalog.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import superprice.catalog.util.ObjectMapperProvider;

import java.util.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="store")
    private String store; 
    
    @Column(name="category")
    private String category; 

    @Column(name="price")
    private Double price;

    @Column(name="item_description")
    private String item_description;

    public Product(Long id, String title, String store, String category, 
    		       Double price, String item_description) {
        this.id = id;
        this.title = title;
        this.store = store;
        this.category = category;
        this.price = price;
        this.item_description = item_description;
    }
    
    public Product(String title, String store, String category, Double price, String item_description) {
        this.title = title;
        this.store = store;
        this.category = category;	
        this.price = price;
        this.item_description = item_description;
    }

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Getter for name
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for store
    public String getStore() {
        return store;
    }

    // Setter for store
    public void setStore(String store) {
        this.store = store;
    }
    
    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }
    
    // Getter for category
    public String getCategory() {
        return category;
    }

    // Getter for price
    public Double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter for description
    public String getDescription() {
        return item_description;
    }

    // Setter for description
    public void setDescription(String item_description) {
        this.item_description = item_description;
    }


}
