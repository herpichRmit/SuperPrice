package superprice.catalog.model.dao;

import org.hibernate.query.Query;
import superprice.catalog.model.BasicCategory;
import superprice.catalog.model.Category;

import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

public class CategoryDao {

    public static Collection <Category> all () {
        return SessionProvider
                .getInstance()
                .withSessionR(session -> {
                    String sql = "from BasicCategory";
                    Query<BasicCategory> query = session.createQuery(
                            sql,
                            BasicCategory.class
                    );

                    return toCategoryCollection(query.getResultList());
                });
    }

    private static Collection<Category> toCategoryCollection(
            Collection <BasicCategory> resultList
    ) {
        LinkedList<Category> returnValue = new LinkedList<>();
        for (Category cat : resultList) {
            returnValue.add(cat);
        }

        return returnValue;
    }

    public static Category byUuid (UUID uuid) {
        return SessionProvider
                .getInstance()
                .withSessionR(session -> {
                    String sql = "from BasicCategory where uuid = :uuid";
                    Query<BasicCategory> query = session.createQuery(
                            sql,
                            BasicCategory.class
                    );
                    query.setParameter("uuid", uuid);

                    return query.uniqueResult();
                });
    }
}
