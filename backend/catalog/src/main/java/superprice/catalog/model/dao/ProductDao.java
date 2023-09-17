package superprice.catalog.model.dao;

import jakarta.annotation.Nullable;
import org.hibernate.Session;
import org.hibernate.query.Query;
import superprice.catalog.model.BasicProduct;
import superprice.catalog.model.Product;
import superprice.catalog.model.StockedProduct;

import java.util.Collection;
import java.util.Locale;

public class ProductDao {

    private static final int MIN_MATCH_SCORE = 1;

    @Nullable
    public static Product find(String brand, String name) {
        Collection<BasicProduct> products = findAllByBrand(brand);

        Product bestMatch = null;
        int bestMatchScore = MIN_MATCH_SCORE;

        for (Product product : products) {
            int matchScore = matchScore (product, brand, name);
            if (matchScore > bestMatchScore) {
                bestMatchScore = matchScore;
                bestMatch = product;
            }
        }

        return bestMatch;
    }

    private static Collection<BasicProduct> findAllByBrand(String brand) {
        Collection<BasicProduct> products
                = SessionProvider
                .getInstance()
                .withSessionR(session -> {
                    String sql = "from BasicProduct where brand = :brand";
                    Query<BasicProduct> query
                            = session.createQuery(sql, BasicProduct.class);
                    query.setParameter("brand", brand);

                    return query.getResultList();
                });
        return products;
    }

    static int matchScore (Product product, String brand, String name) {
        boolean brandMatch = brand.equalsIgnoreCase(product.getBrand());
        if (!brandMatch) {
            return -1;
        } else {
            return wordsSharedInProductName(product, name);
        }
    }

    private static int wordsSharedInProductName(
            Product product,
            String name
    ) {
        String [] nameWords
                = name
                .toLowerCase(Locale.ROOT)
                .split("/\\W+/");
        String prodNameLwrcase
                = product
                .getName()
                .toLowerCase(Locale.ROOT);

        int matchScore = 0;
        for (String word : nameWords) {
            if (prodNameLwrcase.contains(word)) {
                matchScore ++;
            }
        }
        return matchScore;
    }

    public static void save (Product product) {
        SessionProvider
                .getInstance()
                .withSession(session -> save(product, session));
    }

    private static void save(Product product, Session session) {
        session.save(product);
    }

    public static void deepSave (Product product) {
        SessionProvider.getInstance().withSession(session -> {
            deepSave(product, session);
        });
    }
    public static void deepSave (Product product, Session session) {
        save(product, session);
        session.save(product.getCategory());
        for (StockedProduct price : product.getPrices()) {
            session.save(price);
        }
    }

    public static void deepSave(Collection<Product> products) {
        SessionProvider
                .getInstance()
                .withSession(session -> deepSave(products, session));
    }

    public static void deepSave(Collection<Product> products, Session session) {
        for (Product product : products) {
            deepSave(product, session);
        }
    }
}
