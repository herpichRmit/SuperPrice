package superprice.catalog.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="store")
    private String store; 

    @Column(name="brand")
    private String brand;

    @Column(name="category")
    private String category;

    @Column(name="price")
    private Double price;

    @Column(name="item_description")
    private String description;

    public Product(Long id, String title, String store, String brand, String category, Double price, String description) {
        this.id = id;
        this.title = title;
        this.store = store; 
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Product(String title, String store, String brand, String category, Double price, String description) {
        this.title = title;
        this.store = store; 
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
