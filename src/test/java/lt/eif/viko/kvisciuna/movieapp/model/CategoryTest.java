package lt.eif.viko.kvisciuna.movieapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {


        private Category category;

        @BeforeEach
        public void setUp() {
            category = new Category();
        }

        @Test
        public void testSetAndGetId() {
            int testId = 100;
            category.setId(testId);
            assertEquals(testId, category.getId());
        }

        @Test
        public void testSetAndGetCategory() {
            String testCategory = "Drama";
            category.setCategoryName2(testCategory);
            assertEquals(testCategory, category.getCategoryName2());
        }
        @Test
    public void constructorSetsCorrectValue(){
        Category category1 = new Category("Drama");
        assertEquals("Drama" , category1.getCategoryName2());
    }
    }


