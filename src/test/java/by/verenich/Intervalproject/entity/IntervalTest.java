package by.verenich.Intervalproject.test;

import by.verenich.Intervalproject.entity.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalTest {

    @Test
    void testIntervalCreation() {
        Interval interval = new Interval(1.0, 5.0, true, false);
        assertEquals(1.0, interval.getStart());
        assertEquals(5.0, interval.getEnd());
        assertTrue(interval.isIncludeStart());
        assertFalse(interval.isIncludeEnd());
    }

    @Test
    void testInvalidIntervalCreation() {
        assertThrows(IllegalArgumentException.class, () ->
                new Interval(5.0, 1.0, true, true));
    }
}
