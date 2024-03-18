package lt.eif.viko.kvisciuna.movieapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {


        private Actor actor;

        @BeforeEach
        public void setUp() {
            actor = new Actor();
        }

        @Test
        public void testSetAndGetId() {
            int testId = 1;
            actor.setId(testId);
            assertEquals(testId, actor.getId());
        }

        @Test
        public void testSetAndGetName() {
            String testName = "John";
            actor.setName(testName);
            assertEquals(testName, actor.getName());
        }

        @Test
        public void testSetAndGetLastName() {
            String testLastName = "Doe";
            actor.setLastName(testLastName);
            assertEquals(testLastName, actor.getLastName());
        }
        @Test
    public void constructorSetsCorrectValue(){
            Actor actor1 = new Actor("Tim" , "James");
            assertEquals("Tim" , actor1.getName());
            assertEquals("James", actor1.getLastName());
        }
    }


