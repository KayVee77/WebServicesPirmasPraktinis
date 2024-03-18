package lt.eif.viko.kvisciuna.movieapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
/**
 * Represents a category of movies within the movie application.
 * This class is annotated for database persistence using JPA, allowing
 * it to be stored and retrieved from a relational database. It includes
 * properties for the category's ID (automatically generated) and name.
 * The ID field is excluded from XML serialization/deserialization
 * processes using the {@link XmlTransient} annotation.
 */
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String categoryName2;
    /**
     * Constructs a new Category with the specified name.
     *
     * @param categoryName2 the name of the category
     */
    public Category(String categoryName2) {
        this.categoryName2 = categoryName2;
    }
    /**
     * Constructs a new Category without specifying details.
     * Useful for JPA and JAXB, which require a no-argument constructor.
     */
    public Category() {
    }
    /**
     * Returns a string representation of this Category, including its name.
     *
     * @return A formatted string containing the category's name.
     */
    @Override
    public String toString() {
        return String.format("Category: %s \n" , this.categoryName2);
    }
    /**
     * Gets the ID of the category.
     *
     * @return The ID of the category.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the category.
     * This method is marked with {@link XmlTransient} to prevent the
     * marshalling of the ID property to XML, maintaining the focus on
     * domain-specific data rather than database-specific details.
     *
     * @param id the new ID of the category
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the name of the category.
     *
     * @return The name of the category.
     */
    public String getCategoryName2() {
        return categoryName2;
    }
    /**
     * Sets the name of the category.
     *
     * @param categoryName2 the new name of the category
     */
    public void setCategoryName2(String categoryName2) {
        this.categoryName2 = categoryName2;
    }

}

