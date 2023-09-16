package superprice.catalog.model.dao;

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
import superprice.catalog.model.BasicCategory;
import superprice.catalog.model.BasicProduct;
import superprice.catalog.model.BasicStockedProduct;
import superprice.catalog.model.Product;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class SessionHolder {

    private static SessionHolder instance = null;

    private SessionFactory sessionFactory;
    private DB db;

    private SessionHolder () {
        try {
            DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
            configBuilder.setPort(3306); // OR, default: setPort(0); => autom. detect free port
            configBuilder.setDataDir("/tmp/superprice/db"); // just an example
            db = DB.newEmbeddedDB(configBuilder.build());
            db.start();
            db.createDB("superprice_catalog");

            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources( registry )
                    .addAnnotatedClasses(
                            BasicCategory.class,
                            BasicProduct.class,
                            BasicStockedProduct.class
                    )
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (ManagedProcessException e) {
            throw new RuntimeException(e);
        }
    }
    public static SessionHolder getInstance() {
        if (instance == null) {
            instance = new SessionHolder();
        }

        return instance;
    }

    public Session getSession () {
        return sessionFactory.getCurrentSession();
    }
}
