package superprice.catalog.controller;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import superprice.catalog.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ColesSync {

    public static Map <String, Category> categories = new HashMap <String, Category> ();

    public static void main (String [] args) {
        try {
            new ColesSync().scratch();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ManagedProcessException e) {
            throw new RuntimeException(e);
        }
    }
    void scratch () throws IOException, ManagedProcessException {
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(3306); // OR, default: setPort(0); => autom. detect free port
        configBuilder.setDataDir("/tmp/superprice/db"); // just an example
        DB db = DB.newEmbeddedDB(configBuilder.build());
        db.start();
        db.createDB("superprice_catalog");

        InputStream stream = getClass().getResourceAsStream("/coles_search.json");
        ObjectMapper mapper = new ObjectMapper ();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser (stream);
        JsonNode topNode = mapper.readTree(parser);

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

        SessionFactory sessionFactory;
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry )
                    .addAnnotatedClasses(
                            BasicCategory.class,
                            BasicProduct.class,
                            BasicStockedProduct.class
                    )
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            for (Product product : products) {
                session.save(product);
            }
            session.getTransaction().commit ();
            sessionFactory.close();

        }
        catch (NumberFormatException e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }

        System.out.println("DONE");
        while (true) { }
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
            ex.printStackTrace();
            System.err.println(productJ);

            return null;
        }
    }

}
