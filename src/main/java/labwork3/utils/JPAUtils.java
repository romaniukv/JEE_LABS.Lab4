package labwork3.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    private static final EntityManagerFactory entityManagerFactory = createEntityManagerFactory();

     private static EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory( "Labwork3" );

    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        entityManagerFactory.close();
    }
}
