package lt.eif.viko.kvisciuna.movieapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
/**
 * Represents a language for movies within the movie application.
 * This class is annotated for persistence in a database using JPA,
 * facilitating storage and retrieval of language information. It includes
 * properties for the language's ID (auto-generated) and name. The ID field
 * is annotated with {@link XmlTransient} to exclude it from XML serialization
 * and deserialization processes, focusing on the essential, domain-specific data.
 */
@Entity
@Table(name="language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String languageName2;
    /**
     * Constructs a new Language with the specified name.
     *
     * @param languageName2 the name of the language
     */
    public Language(String languageName2) {
        this.languageName2 = languageName2;
    }
    /**
     * Constructs a new Language without specifying details.
     * This no-argument constructor is useful for JPA and JAXB,
     * which require it for their operations.
     */
    public Language() {
    }
    /**
     * Returns a string representation of this Language, including its name.
     *
     * @return A formatted string containing the language's name.
     */
    @Override
    public String toString() {
        return String.format("Language: %s \n" , this.languageName2);
    }
    /**
     * Gets the ID of the language.
     *
     * @return The ID of the language.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the language.
     * This method is marked with {@link XmlTransient} to avoid
     * marshalling the ID property to XML, thus keeping the serialized
     * data focused on meaningful, domain-specific information.
     *
     * @param id the new ID of the language
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the name of the language.
     *
     * @return The name of the language.
     */
    public String getLanguageName2() {
        return languageName2;
    }
    /**
     * Sets the name of the language.
     *
     * @param languageName2 the new name of the language
     */
    public void setLanguageName2(String languageName2) {
        this.languageName2 = languageName2;
    }

}
