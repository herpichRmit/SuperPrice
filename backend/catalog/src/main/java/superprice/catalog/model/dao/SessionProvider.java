package superprice.catalog.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import superprice.catalog.model.*;

public class SessionProvider {

    private static SessionProvider instance = null;

    private SessionFactory sessionFactory;

    private SessionProvider() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry )
                .addAnnotatedClasses(
                        BasicCategory.class,
                        BasicProduct.class,
                        BasicStockedProduct.class
//                        BasicImage.class
                )
                .buildMetadata()
                .buildSessionFactory();
    }
    public static SessionProvider getInstance() {
        init();

        return instance;
    }

    public static void init() {
        if (instance == null) {
            DatabaseProvider.init();
            instance = new SessionProvider();
        }
    }

//    public Session getSession () {
//        return sessionFactory.openSession();
//    }

    public interface TransactionLambdaRx<T, X extends Throwable> {
        public T transact (Session session) throws X;
    }
    public interface TransactionLambdaR<T> {
        public T transact (Session session);
    }

    public <T> T withSessionR(TransactionLambdaR<T> lambda) {
        return withSessionRx(lambda::transact);
    }

    public <T, X extends Throwable> T withSessionRx(
            TransactionLambdaRx<T, X> lambda
    ) throws X {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            T result = lambda.transact(session);

            transaction.commit();
            return result;
        }
    }

    public interface TransactionLambda {
        public void transact (Session session);
    }

    public void withSession (TransactionLambda lambda) {
        withSessionR(session -> {
                lambda.transact(session);
                return null;
        });
    }
}
