package lt.eif.viko.kvisciuna.movieapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents an actor within the movie application.
 * This class is annotated for persistence in a relational database using JPA annotations,
 * as well as for XML serialization/deserialization using JAXB annotations.
 *
 * It includes properties for the actor's ID (auto-generated), name, and last name.
 * The ID field is marked with {@link XmlTransient} to exclude it from XML serialization.
 */
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String name;
    private String lastName;
    /**
     * Constructs a new Actor with specified name and last name.
     *
     * @param name the first name of the actor
     * @param lastName the last name of the actor
     */
    public Actor(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    /**
     * Constructs a new Actor without specifying details.
     * Useful for JPA and JAXB which require a no-argument constructor.
     */
    public Actor() {
        /**
         * Returns a string representation of this Actor, including name and last name.
         *
         * @return A formatted string containing the actor's name and last name.
         */
    }
    @Override
    public String toString() {
        return String.format("Name: %s \n" +
                             "Last name: %s \n", this.name,this.lastName);
    }
    /**
     * Gets the ID of the actor.
     *
     * @return The ID of the actor.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the actor.
     * This method is marked with {@link XmlTransient} to prevent the marshalling
     * of the ID property to XML.
     *
     * @param id the new ID of the actor
     */
    @XmlTransient

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the name of the actor.
     *
     * @return The name of the actor.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the actor.
     *
     * @param name the new name of the actor
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the last name of the actor.
     *
     * @return The last name of the actor.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the actor.
     *
     * @param lastName the new last name of the actor
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

