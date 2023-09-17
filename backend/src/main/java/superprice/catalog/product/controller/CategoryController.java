package superprice.catalog.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.StructuredProduct;
import superprice.catalog.product.repository.CategoryRepository;

import java.util.Collection;

@RestController
public class CategoryController {
    CategoryRepository repository;

    @Autowired
    public CategoryController (CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/api/catalog/category")
    public Collection<Category> all () {
        Collection <Category> categories;

        categories = repository.categories();

        return categories;
    }
}
