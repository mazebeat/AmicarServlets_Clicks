package cl.intelidata.amicar.conf;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase Singleton para manejo de EntityManagerFactory con ObjectDB<br>
 * <p>
 * @author Juan Astorga
 */
public class EntityHelper {

    private static EntityHelper entityHelper = null;
    private static final EntityManagerFactory entityManagerFactory;

    static {
        Map<String, String> propiedades = new HashMap<String, String>();
        propiedades.put("javax.persistence.jdbc.url", Configuracion.getInstance().getInitParameter("javax.persistence.jdbc.url"));
        propiedades.put("javax.persistence.jdbc.user", Configuracion.getInstance().getInitParameter("javax.persistence.jdbc.user"));
        propiedades.put("javax.persistence.jdbc.password", Configuracion.getInstance().getInitParameter("javax.persistence.jdbc.password"));
        entityManagerFactory = Persistence.createEntityManagerFactory("ClicksPU", propiedades);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static EntityHelper getInstance() throws Exception {
        if (entityHelper == null) {
            entityHelper = new EntityHelper();
        }
        return entityHelper;
    }

    /**
     * *
     * Utiliza solo una instancia de EntityManagerFactory<br>
     * mas de una satura las conexiones a la BD
     * <p>
     * @return EntityManagerFactory
     * @throws java.lang.Exception
     */
    public EntityManager getEntityManager() throws Exception {
        return entityManagerFactory.createEntityManager();
    }

}
