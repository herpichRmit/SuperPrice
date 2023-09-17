package superprice.catalog.model.dao;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

public class DatabaseProvider {
    private static DatabaseProvider instance;

    private DB db;
    private DatabaseProvider () {
        startDatabase();
    }
    public static DatabaseProvider getInstance () {
        init ();

        return instance;
    }

    public DB getDb () {
        return this.db;
    }

    public static void init () {
        if (instance == null) {
            instance = new DatabaseProvider();
        }
    }
    private void startDatabase () {
        if (db != null) {
            return;
        } else try {
            DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
            configBuilder.setPort(3306); // OR, default: setPort(0); => autom. detect free port
            configBuilder.setDataDir("/tmp/superprice/db"); // just an example
            db = DB.newEmbeddedDB(configBuilder.build());
            db.start();
            db.createDB("superprice_catalog");
        } catch (ManagedProcessException e) {
            throw new RuntimeException(e);
        }
    }
}
