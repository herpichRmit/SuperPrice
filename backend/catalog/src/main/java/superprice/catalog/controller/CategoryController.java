package superprice.catalog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import superprice.catalog.model.Category;
import superprice.catalog.model.dao.CategoryDao;
import superprice.catalog.view.JsonView;

import java.util.Collection;
import java.util.UUID;

@RestController
public class CategoryController {

    @GetMapping (value = "/api/catalog/category")
    public ResponseEntity <String> get () {
        Collection <Category> allCategories = CategoryDao.all();

        try {
            JsonView view = new JsonView<>(allCategories);

            return new ResponseEntity<> (view.render(), HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping (value = "/api/catalog/category/{uuid}")
    public ResponseEntity <String> get (@PathVariable String uuid) {
        Category category = CategoryDao.byUuid(UUID.fromString(uuid));

        try {
            JsonView view = new JsonView<>(category);

            return new ResponseEntity<> (view.render(), HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
