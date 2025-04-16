package by.verenich.Intervalproject.service.impl;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.service.IntervalService;

import java.util.Optional;

public class IntervalServiceImpl implements IntervalService {

    @Override
    public Optional<Interval> intersect(Interval a, Interval b) {
        double maxStart = Math.max(a.getStart(), b.getStart());
        double minEnd = Math.min(a.getEnd(), b.getEnd());

        boolean includeStart = (a.getStart() == maxStart && a.isIncludeStart()) ||
                (b.getStart() == maxStart && b.isIncludeStart());

        boolean includeEnd = (a.getEnd() == minEnd && a.isIncludeEnd()) ||
                (b.getEnd() == minEnd && b.isIncludeEnd());

        if (maxStart < minEnd || (maxStart == minEnd && includeStart && includeEnd)) {
            return Optional.of(new Interval(maxStart, minEnd, includeStart, includeEnd));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Interval> union(Interval a, Interval b) {
        if (intersect(a, b).isEmpty() && distanceBetween(a, b) > 0) return Optional.empty();

        double newStart = Math.min(a.getStart(), b.getStart());
        double newEnd = Math.max(a.getEnd(), b.getEnd());

        boolean includeStart = (a.getStart() == newStart && a.isIncludeStart()) ||
                (b.getStart() == newStart && b.isIncludeStart());

        boolean includeEnd = (a.getEnd() == newEnd && a.isIncludeEnd()) ||
                (b.getEnd() == newEnd && b.isIncludeEnd());

        return Optional.of(new Interval(newStart, newEnd, includeStart, includeEnd));
    }

    @Override
    public double distanceBetween(Interval a, Interval b) {
        if (intersect(a, b).isPresent()) return 0.0;
        return Math.max(0, Math.max(a.getStart(), b.getStart()) - Math.min(a.getEnd(), b.getEnd()));
    }
}