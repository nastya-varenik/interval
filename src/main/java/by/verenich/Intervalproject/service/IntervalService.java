package by.verenich.Intervalproject.service;

import by.verenich.Intervalproject.entity.Interval;

import java.util.Optional;

public interface IntervalService {
    Optional<Interval> intersect(Interval a, Interval b);
    Optional<Interval> union(Interval a, Interval b);
    double distanceBetween(Interval a, Interval b);
}