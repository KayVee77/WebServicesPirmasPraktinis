package lt.eif.viko.kvisciuna.movieapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {


        private Producer producer;

        @BeforeEach
        public void setUp() {
            producer = new Producer();
        }

        @Test
        public void testNameSetterGetter() {
            String testName = "John";
            producer.setName(testName);
            assertEquals(testName, producer.getName());
        }

        @Test
        public void testLastNameSetterGetter() {
            String testLastName = "Doe";
            producer.setLastName(testLastName);
            assertEquals(testLastName, producer.getLastName());
        }

        @Test
        public void testIdSetterGetter() {
            int testId = 1;
            producer.setId(testId);
            assertEquals(testId, producer.getId());
        }
    @Test
    public void constructorSetsCorrectValue(){
        Producer producer1 = new Producer("Vadim", "Cook");
        assertEquals("Vadim" , producer1.getName());
        assertEquals("Cook" , producer1.getLastName());
    }
    }


