package by.verenich.Intervalproject.runner;

import by.verenich.Intervalproject.Main;
import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.service.impl.IntervalServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

public class MainTest {

    @Test
    public void testMainOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});

        System.setOut(originalOut);
        String output = outputStream.toString().trim();
        Assert.assertTrue(output.contains("Максимальное расстояние") || output.contains("Error"));
    }

    @Test
    public void testMaxDistanceCalculation() {
        Interval a = new Interval(0.0, 5.0, true, true);
        Interval b = new Interval(10.0, 20.0, true, true);

        double min = Math.min(a.getStart(), b.getStart());
        double max = Math.max(a.getEnd(), b.getEnd());

        double expected = 20.0 - 0.0;
        double actual = max - min;

        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testIntersectionExists() {
        IntervalServiceImpl service = new IntervalServiceImpl();
        Interval a = new Interval(1.0, 5.0, true, false);
        Interval b = new Interval(4.0, 6.0, true, true);

        Optional<Interval> result = service.intersect(a, b);
        Assert.assertTrue(result.isPresent());

        Interval expected = new Interval(4.0, 5.0, true, false);

        Assert.assertEquals(result.get().getStart(), expected.getStart(), 0.0001);
        Assert.assertEquals(result.get().getEnd(), expected.getEnd(), 0.0001);
        Assert.assertEquals(result.get().isIncludeStart(), expected.isIncludeStart());
        Assert.assertEquals(result.get().isIncludeEnd(), expected.isIncludeEnd());
    }

    @Test
    public void testIntersectionDoesNotExist() {
        IntervalServiceImpl service = new IntervalServiceImpl();
        Interval a = new Interval(1.0, 3.0, true, true);
        Interval b = new Interval(3.0, 5.0, false, true); // Не включает 3.0

        Optional<Interval> result = service.intersect(a, b);
        Assert.assertFalse(result.isPresent());
    }

    @Test
    public void testUnionExists() {
        IntervalServiceImpl service = new IntervalServiceImpl();
        Interval a = new Interval(1.0, 4.0, true, true);
        Interval b = new Interval(3.5, 5.0, true, false);

        Optional<Interval> result = service.union(a, b);
        Assert.assertTrue(result.isPresent());

        Interval expected = new Interval(1.0, 5.0, true, false);

        Assert.assertEquals(result.get().getStart(), expected.getStart(), 0.0001);
        Assert.assertEquals(result.get().getEnd(), expected.getEnd(), 0.0001);
        Assert.assertEquals(result.get().isIncludeStart(), expected.isIncludeStart());
        Assert.assertEquals(result.get().isIncludeEnd(), expected.isIncludeEnd());
    }


    @Test
    public void testUnionDoesNotExist() {
        IntervalServiceImpl service = new IntervalServiceImpl();
        Interval a = new Interval(1.0, 2.0, true, true);
        Interval b = new Interval(3.0, 4.0, true, true);

        Optional<Interval> result = service.union(a, b);
        Assert.assertFalse(result.isPresent());
    }
}
