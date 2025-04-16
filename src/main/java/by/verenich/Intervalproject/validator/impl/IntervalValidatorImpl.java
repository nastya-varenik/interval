package by.verenich.Intervalproject.validator.impl;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.validator.IntervalValidator;

public class IntervalValidatorImpl implements IntervalValidator {

    @Override
    public boolean isValid(Interval interval) {
        boolean booleanFlag = false;

        if (interval == null) {
            return booleanFlag;
        }

        if (interval.getStart() == interval.getEnd()
                && interval.isIncludeStart()
                && interval.isIncludeEnd()) {
            booleanFlag = true;
        }

        return booleanFlag;
    }
}
