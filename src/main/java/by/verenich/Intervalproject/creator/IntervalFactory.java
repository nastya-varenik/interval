package by.verenich.Intervalproject.creator;

import by.verenich.Intervalproject.entity.Interval;

public interface IntervalFactory {
    Interval create(double start, double end, boolean includeStart, boolean includeEnd);
}
