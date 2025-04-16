package by.verenich.Intervalproject;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.service.impl.IntervalServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IntervalServiceImpl service = new IntervalServiceImpl();

        List<Interval> intervals = List.of(
                new Interval(1.0, 5.0, true, false),
                new Interval(4.5, 10.0, true, true),
                new Interval(11.0, 13.0, false, true),
                new Interval(20.0, 25.0, true, true),
                new Interval(0.0, 0.0, true, true)
        );

        double min = intervals.stream().mapToDouble(Interval::getStart).min().orElse(0);
        double max = intervals.stream().mapToDouble(Interval::getEnd).max().orElse(0);

        double maxDistance = max - min;
        System.out.println("Максимальное расстояние между самыми удаленными концами: " + maxDistance);

        // Пример пересечения и объединения
        var a = intervals.get(0);
        var b = intervals.get(1);
        System.out.println("Пересечение " + a + " и " + b + ": " + service.intersect(a, b).orElse(null));
        System.out.println("Объединение " + a + " и " + b + ": " + service.union(a, b).orElse(null));
    }
}
