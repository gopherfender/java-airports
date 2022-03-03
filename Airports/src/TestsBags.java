package Airports.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestsBags {
    @Test
    public void test_weight() {
        Bag bag = new Bag(13, "Not drugs");
        assertEquals(bag.getWeight(), 13);
    }

    @Test
    public void test_weight_errors() {
        Bag bag = new Bag(12, "Might be drugs");
        assertTrue(bag instanceof Bag);
    }
}
