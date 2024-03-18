package lt.eif.viko.kvisciuna.movieapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
/**
 * Represents a producer within the movie application.
 * This class is annotated for persistence in a database using JPA and for XML serialization/deserialization
 * with JAXB. It includes properties for the producer's unique identifier, name, and last name.
 */
@Entity
@Table(name="producer")
public class Producer {
    /**
     * Identifier of the producer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * Name of the producer.
     */
    private String name;
    /**
     * Last name of the producer.
     */
    private String lastName;
    /**
     * Constructor with name and last name parameters.
     * @param name Name of the producer.
     * @param lastName Last name of the producer.
     */

    public Producer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    /**
     * Default constructor.
     */
    public Producer() {
    }
    /**
     * Returns a string with the producer's name and last name.
     * @return String with the producer's data.
     */
    @Override
    public String toString() {
        return String.format("Name: %s \n" +
                             "Last name: %s \n", this.name, this.lastName);
    }
    /**
     * Returns the identifier of the producer.
     * @return Producer's identifier.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the identifier of the producer.
     * @param id Producer's identifier.
     */
    @XmlTransient

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Returns the name of the producer.
     * @return Producer's name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the producer.
     * @param name Producer's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the last name of the producer.
     * @return Producer's last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the producer.
     * @param lastName Producer's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
