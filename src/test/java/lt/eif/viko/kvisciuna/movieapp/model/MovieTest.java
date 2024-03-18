package lt.eif.viko.kvisciuna.movieapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {


        private Movie movie;
        private Actor actor;
        private Producer producer;
        private Language language;
        private Category category;

        @BeforeEach
        public void setUp() {
            movie = new Movie();
            actor = new Actor(); // Assuming you have a no-arg constructor
            actor.setName("John Doe"); // Assuming Actor class has this method
            producer = new Producer(); // Assuming Producer class has a no-arg constructor
            producer.setName("Jane Doe"); // Assuming Producer class has this method
            language = new Language(); // Assuming Language class has a no-arg constructor
            language.setLanguageName2("English"); // Assuming Language class has this method
            category = new Category(); // Assuming Category class has a no-arg constructor
            category.setCategoryName2("Drama"); // Assuming Category class has this method
        }

        @Test
        public void testNameSetterGetter() {
            movie.setName("The Great Movie");
            assertEquals("The Great Movie", movie.getName());
        }

        @Test
        public void testMovieLengthSetterGetter() {
            movie.setMovieLength("120 mins");
            assertEquals("120 mins", movie.getMovieLength());
        }

        @Test
        public void testActorsSetterGetter() {
            List<Actor> actors = Arrays.asList(actor);
            movie.setActors(actors);
            assertEquals(actors, movie.getActors());
            assertEquals("John Doe", movie.getActors().get(0).getName()); // Validate actor's name
        }

        @Test
        public void testProducerSetterGetter() {
            movie.setProducer(producer);
            assertEquals(producer, movie.getProducer());
            assertEquals("Jane Doe", movie.getProducer().getName()); // Validate producer's name
        }

        @Test
        public void testLanguageSetterGetter() {
            movie.setLanguageName(language);
            assertEquals(language, movie.getLanguageName());
            assertEquals("English", movie.getLanguageName().getLanguageName2()); // Validate language name
        }

        @Test
        public void testCategorySetterGetter() {
            movie.setCategoryName(category);
            assertEquals(category, movie.getCategoryName());
            assertEquals("Drama", movie.getCategoryName().getCategoryName2()); // Validate category name
        }
    @Test
    public void constructorSetsCorrectValue(){
        Movie movie1 = new Movie("Home Alone", "1h:37min");
        assertEquals("Home Alone" , movie1.getName());
        assertEquals("1h:37min" , movie1.getMovieLength());
    }
    }






