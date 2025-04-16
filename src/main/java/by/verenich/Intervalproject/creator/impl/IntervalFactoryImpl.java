package by.verenich.Intervalproject.creator.impl;

import by.verenich.Intervalproject.creator.IntervalFactory;
import by.verenich.Intervalproject.entity.Interval;

public class IntervalFactoryImpl implements IntervalFactory {
    @Override
    public Interval create(double start, double end, boolean includeStart, boolean includeEnd) {
        return new Interval(start, end, includeStart, includeEnd);
    }
}