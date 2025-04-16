package by.verenich.Intervalproject.test;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.service.impl.IntervalServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalServiceImplTest {

    private final IntervalServiceImpl service = new IntervalServiceImpl();

    @Test
    void testIntersection() {
        Interval a = new Interval(1.0, 5.0, true, true);
        Interval b = new Interval(3.0, 7.0, true, true);

        Optional<Interval> result = service.intersect(a, b);
        assertTrue(result.isPresent());
        assertEquals(3.0, result.get().getStart());
        assertEquals(5.0, result.get().getEnd());
    }

    @Test
    void testUnion() {
        Interval a = new Interval(1.0, 5.0, true, false);
        Interval b = new Interval(4.0, 6.0, true, true);

        Optional<Interval> result = service.union(a, b);
        assertTrue(result.isPresent());
        assertEquals(1.0, result.get().getStart());
        assertEquals(6.0, result.get().getEnd());
    }

    @Test
    void testDistanceBetweenNonIntersecting() {
        Interval a = new Interval(1.0, 2.0, true, true);
        Interval b = new Interval(4.0, 6.0, true, true);

        double distance = service.distanceBetween(a, b);
        assertEquals(2.0, distance);
    }

    @Test
    void testDistanceBetweenIntersecting() {
        Interval a = new Interval(1.0, 5.0, true, true);
        Interval b = new Interval(3.0, 6.0, true, true);

        double distance = service.distanceBetween(a, b);
        assertEquals(0.0, distance);
    }
}
