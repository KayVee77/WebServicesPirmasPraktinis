package lt.eif.viko.kvisciuna.movieapp.db;

import lt.eif.viko.kvisciuna.movieapp.model.Movie;
import lt.eif.viko.kvisciuna.movieapp.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
/**
 * Facilitates loading of movie information from the database.
 * This class provides functionality to retrieve a list of movies stored within
 * the database using Hibernate, demonstrating a basic implementation of data retrieval
 * with Hibernate sessions.
 */
public class MovieLoader {
    /**
     * Retrieves a list of all movies from the database and prints their details to the console.
     * This method establishes a Hibernate session, executes a query to fetch all instances
     * of {@link Movie} from the database, and iterates over the list to print each movie's details.
     *
     * Exception handling is incorporated to catch and print any errors that occur during
     * the process of fetching movies from the database. This ensures that the application
     * can gracefully handle failures and provide feedback for troubleshooting.
     */
    public static void loadMovies(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // Execute a query to fetch all movies
            List<Movie> movieList = session.createQuery("from Movie", Movie.class).list();
            // Iterate over the fetched movies and print their details
            movieList.forEach(movie -> System.out.println(movie));
        }
        catch (Exception e){
            // Print any exceptions that occur to standard error
            e.printStackTrace();
        }
    }
}
