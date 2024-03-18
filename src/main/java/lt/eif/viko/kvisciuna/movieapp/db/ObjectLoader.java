package lt.eif.viko.kvisciuna.movieapp.db;

import lt.eif.viko.kvisciuna.movieapp.util.HibernateUtil;
import org.hibernate.Session;
/**
 * Provides generic functionality to load objects from the database.
 * This class utilizes Hibernate to facilitate the retrieval of any entity
 * by its class type and ID, demonstrating a flexible approach to data access.
 */
public class ObjectLoader {
    /**
     * Retrieves an entity of the specified type from the database using its ID.
     * This generic method establishes a Hibernate session and attempts to fetch
     * an entity of the specified type and ID from the database. If the entity is
     * found, it is printed to the console and returned. Otherwise, a message
     * indicating that the entity was not found is printed to the console.
     *
     * @param entityType The Class object of the entity type to load.
     * @param entityId The ID of the entity to retrieve.
     * @param <T> The type of the entity to be loaded.
     * @return The loaded entity if found; otherwise, {@code null}.
     *
     * @throws Exception Propagates any exceptions thrown by the Hibernate session
     * to the caller, typically for handling database access errors.
     */
    public static <T> T loadObject(Class<T> entityType, int entityId) {
        T entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Attempt to fetch the entity by its ID
            entity = session.get(entityType, entityId);
            if (entity != null) {
                // Entity found, print its details
                System.out.println(entity);
            } else {
                // Entity not found, inform the user
                System.out.println(entityType.getSimpleName() + " with ID " + entityId + " not found.");
            }
        } catch (Exception e) {
            // Handle and print any exceptions that occur during the fetch operation
            e.printStackTrace();
        }
        return entity;
    }
}
