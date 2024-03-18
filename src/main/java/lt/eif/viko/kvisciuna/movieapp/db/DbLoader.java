package lt.eif.viko.kvisciuna.movieapp.db;

import lt.eif.viko.kvisciuna.movieapp.model.*;
import lt.eif.viko.kvisciuna.movieapp.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.Transaction;
/**
 * Provides an initial loading mechanism for database entities.
 * This class contains a static initializer block that is executed once when the class is loaded.
 * It creates sample movie data along with associated actors, categories, languages, and producers,
 * and then persists this data to the database using Hibernate.
 */
public class DbLoader {

    static{
        // Create a new movie instance with basic details
        Movie movie = new Movie("Name ","Movie length ");
        // Create actor instances
        Actor actor = new Actor("First name ", "Last name");
        Category category = new Category("Category ");
        Language language = new Language("Language");
        Producer producer = new Producer("Name", "Last name");

        // Create additional actors
        Actor actor2 = new Actor("First name2", "Last name2");
        Actor actor3 = new Actor("First name3", "Last name3");
        Actor actor4 = new Actor("First name4", "Last name4");
        Actor actor5 = new Actor("First name5", "Last name5");
        // Add actors to the movie
        movie.getActors().add(actor);
        movie.getActors().add(actor2);
        movie.getActors().add(actor3);
        movie.getActors().add(actor4);
        movie.getActors().add(actor5);

        // Set category, language, and producer for the movie
        movie.setCategoryName(category);
        movie.setLanguageName(language);
        movie.setProducer(producer);
        // Output the movie details to console
        System.out.println(movie);
        // Begin a new Hibernate session to persist the movie
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            // Start the transaction and attempt to save the movie to the database
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        } catch (Exception e){
            // If any exception occurs, rollback the transaction
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            // Close the session to free resources
            session.close();
        }


    }
}
