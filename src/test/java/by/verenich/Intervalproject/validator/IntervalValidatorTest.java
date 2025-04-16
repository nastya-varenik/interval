package by.verenich.Intervalproject.validator;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.validator.IntervalValidator;
import by.verenich.Intervalproject.validator.impl.IntervalValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalValidatorTest {

    private final IntervalValidator validator = new IntervalValidatorImpl();

    @Test
    void testValidInterval() {
        Interval valid = new Interval(1.0, 5.0, true, true);
        assertTrue(validator.isValid(valid));
    }

    @Test
    void testInvalidInterval() {
        Interval invalid = new Interval(5.0, 1.0, true, true);
        assertFalse(validator.isValid(invalid));
    }
}


