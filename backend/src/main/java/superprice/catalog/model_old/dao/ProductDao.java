package superprice.catalog.model_old.dao;

import jakarta.annotation.Nullable;
import superprice.catalog.model_old.BasicProduct;
import superprice.catalog.model_old.Product;
import superprice.catalog.model_old.StockedProduct;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;
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
        Session session = SessionHolder.getInstance().getSession();


        String sql = "from BasicProduct where brand = :brand";
        Query<BasicProduct> query
                = session.createQuery(sql, BasicProduct.class);
        query.setParameter("brand", brand);
        Collection <BasicProduct> products = query.getResultList();
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
        Session session = SessionHolder.getInstance().getSession();

        session.save(product);
    }

    public static void deepSave (Product product) {
        Session session = SessionHolder.getInstance().getSession();

        session.save(product);
        session.save(product.getCategory());
        for (StockedProduct price : product.getPrices()) {
            session.save(price);
        }
    }

    public static void deepSave(Collection<Product> products) {
        Transaction transaction
                = SessionHolder
                .getInstance()
                .getSession()
                .beginTransaction();
        for (Product product : products) {
            deepSave(product);
        }
        transaction.commit();
    }
}
