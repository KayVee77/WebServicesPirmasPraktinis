package lt.eif.viko.kvisciuna.movieapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a movie within the movie application.
 * This class is annotated for persistence in a database using JPA and for XML serialization/deserialization
 * with JAXB. It includes properties for the movie's unique identifier, name, length, associated actors,
 * producer, language, and category, demonstrating the use of both one-to-many and one-to-one relationships.
 */
@Entity
@Table(name="movie")

@XmlType(propOrder = {"name", "movieLength","categoryName", "actors", "languageName", "producer"})
@XmlRootElement(name = "Movie")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;

    private String movieLength;
    @OneToMany(targetEntity = Actor.class, cascade = CascadeType.ALL)
    private List<Actor> actors = new ArrayList<>();
    @OneToOne(targetEntity = Producer.class, cascade = CascadeType.ALL)
    private Producer producer;
    @OneToOne(targetEntity = Language.class, cascade = CascadeType.ALL)
    private Language languageName;
    @OneToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    private Category categoryName;
    /**
     * Constructs a new Movie with the specified name and movie length.
     *
     * @param name the name of the movie
     * @param movieLength the length of the movie
     */
    public Movie(String name, String movieLength) {
        this.name = name;
        this.movieLength = movieLength;
    }
    /**
     * Default constructor used by JPA and JAXB.
     */
    public Movie() {
    }
    /**
     * Provides a custom string representation of this movie, including its name, length,
     * list of actors, producer, language, and category.
     *
     * @return A string representation of the movie.
     */
    @Override
    public String toString() {
        return String.format("Name: %s \n" +
                "Movie length: %s \n" +
                "Actors: %s \n" +
                "Producer: %s \n" +
                "Language: %s \n" +
                "Category: %s \n", this.name,this.movieLength, constructActorsList(), producer, languageName, categoryName);

    }
    /**
     * Constructs a string listing all actors associated with this movie.
     *
     * @return A concatenated string of actor names.
     */
    private String constructActorsList(){
        String result = "";
        for(Actor actor : actors ){
            result += actor;
        }
        return result;

    }
    // Getters and setters for all properties, with JAXB annotations for XML mapping
    // and JPA annotations for database persistence
    public int getId() {
        return id;
    }
    @XmlTransient

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @XmlElementWrapper(name = "Actors")
    @XmlElement(name = "Actor")

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Language getLanguageName() {
        return languageName;
    }

    @XmlElement (name = "languageName")

    public void setLanguageName(Language languageName) {
        this.languageName = languageName;
    }

    public Category getCategoryName() {
        return categoryName;
    }
    @XmlElement (name = "categoryName")

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

}
