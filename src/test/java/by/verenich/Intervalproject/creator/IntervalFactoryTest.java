package by.verenich.Intervalproject.creator;

import by.verenich.Intervalproject.entity.Interval;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntervalFactoryTest {
    @Test
    public void testIntervalFactory() {
        Interval interval = IntervalFactory.create(2.0, 6.0, false, true);
        Assert.assertEquals(interval.getStart(), 2.0);
        Assert.assertEquals(interval.getEnd(), 6.0);
        Assert.assertFalse(interval.isIncludeStart());
        Assert.assertTrue(interval.isIncludeEnd());
    }
}