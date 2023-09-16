package superprice.catalog.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import superprice.catalog.util.ObjectMapperProvider;

import java.util.*;


public class Product {
    private Long id;
    private String name;
    private Store store; 
    private Double price;
    private String description;

    public Product(Long id, String name, Store store, Double price, String description) {
        this.id = id;
        this.name = name;
        this.store = store;
        this.price = price;
        this.description = description;
    }
    
    public Product(String name, Store store, Double price, String description) {
        this.name = name;
        this.store = store;
        this.price = price;
        this.description = description;
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
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for store
    public Store getStore() {
        return store;
    }

    // Setter for store
    public void setStore(Store store) {
        this.store = store;
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
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }


}
