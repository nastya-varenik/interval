package by.verenich.Intervalproject.util;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.creator.IntervalFactory;

public class IntervalParser {

    private static final String DELIMITER = ",";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private final IntervalFactory intervalFactory;

    public IntervalParser(IntervalFactory intervalFactory) {
        this.intervalFactory = intervalFactory;
    }

    public Interval parseLine(String line) throws IllegalArgumentException, NumberFormatException {
        String[] parts = line.split(DELIMITER);
        if (parts.length < 4) {
            throw new IllegalArgumentException("Недостаточно данных в строке: " + line);
        }

        double start = Double.parseDouble(parts[0]);
        double end = Double.parseDouble(parts[1]);
        boolean startInclusive = parts[2].equals(LEFT_BRACKET);
        boolean endInclusive = parts[3].equals(RIGHT_BRACKET);

        return intervalFactory.create(start, end, startInclusive, endInclusive);
    }
}
