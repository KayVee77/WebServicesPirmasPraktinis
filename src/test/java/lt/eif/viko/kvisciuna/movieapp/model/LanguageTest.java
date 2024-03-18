package lt.eif.viko.kvisciuna.movieapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageTest {
        private Language language;

        @BeforeEach
        public void setUp() {
            language = new Language();
        }

        @Test
        public void testSetAndGetId() {
            int testId = 200;
            language.setId(testId);
            assertEquals(testId, language.getId());
        }

        @Test
        public void testSetAndGetLanguage() {
            String testLanguage = "English";
            language.setLanguageName2(testLanguage);
            assertEquals(testLanguage, language.getLanguageName2());
        }

    @Test
    public void constructorSetsCorrectValue(){
        Language language1 = new Language("English");
        assertEquals("English" , language1.getLanguageName2());
    }
    }



