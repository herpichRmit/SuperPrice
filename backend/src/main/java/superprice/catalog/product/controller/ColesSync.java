package superprice.catalog.product.controller;
/* 
package superprice.catalog.controller;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import superprice.catalog.model_old.*;
import superprice.catalog.model_old.dao.ProductDao;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping (value = "/api/catalog/sync/coles")
public class ColesSync {

    public static Map <String, Category> categories = new HashMap <String, Category> ();

    @PostMapping
    public ResponseEntity post (@RequestBody String request) {
        try {
            JsonNode jsonRoot = parseJson (request);
            List<Product> products = parseProducts(jsonRoot);
            ProductDao.deepSave(products);

            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (JsonParseException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        catch (IOException ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private JsonNode parseJson (String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper ();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser (jsonStr);

        return mapper.readTree(parser);
    }

    private static List<Product> parseProducts(JsonNode topNode) {
        JsonNode results = topNode.get ("pageProps").get("searchResults").get ("results");
        List<Product> products = new LinkedList<Product>();
        if (! results.isArray())
        {
            System.err.println ("results not array");
        }
        else {
            for (JsonNode productJ : results)
            {

                if (productJ.get("_type").asText().equals("PRODUCT")) {
                    Product product = readProduct(productJ);
                    products.add(product);
                }
            }
        }
        return products;
    }

    private static void deepSaveProduct(Session session, Product product) {
        session.save(product);
        session.save(product.getCategory());
        for (StockedProduct price : product.getPrices()) {
            session.save(price);
        }
    }

    private static Product readProduct(JsonNode productJ) {
        try {
            String name = productJ.get("name").asText();
            String brand = productJ.get("brand").asText();
            String size = productJ.get("size").asText();
            String description = productJ.get("description").asText();

            Product product = new BasicProduct(name, brand, size, description);

            double priceDollars = productJ.get ("pricing").get ("now").asDouble();
            int priceCents = (int) (priceDollars * 100);

            StockedProduct price = new BasicStockedProduct (product, Store.COLES, priceCents);
            product.addPrice(price);

            String categoryName = productJ.get("merchandiseHeir").get("category").asText();
            if (!categories.containsKey(categoryName)) {
                categories.put(categoryName, new BasicCategory(categoryName));
            }

            Category category = categories.get(categoryName);
            product.setCategory(category);

            return product;
        }
        catch (NullPointerException ex)
        {
            throw new RuntimeException(ex);
        }
    }

}
*/