package by.verenich.Intervalproject.parser;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.creator.IntervalFactory;

import java.util.logging.Logger;

public class IntervalParser {
    private static final Logger logger = Logger.getLogger(IntervalParser.class.getName());

    private static final String DELIMITER = ",";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private final IntervalFactory intervalFactory;

    public IntervalParser(IntervalFactory intervalFactory) {
        this.intervalFactory = intervalFactory;
    }

    public Interval parseLine(String line) throws IllegalArgumentException, NumberFormatException {
        String[] parts = line.trim().split(DELIMITER);
        if (parts.length < 4) {
            throw new IllegalArgumentException("Недостаточно данных в строке: " + line);
        }

        double start = Double.parseDouble(parts[0].trim());
        double end = Double.parseDouble(parts[1].trim());
        boolean includeStart = parts[2].trim().equals(LEFT_BRACKET);
        boolean includeEnd = parts[3].trim().equals(RIGHT_BRACKET);

        return intervalFactory.create(start, end, includeStart, includeEnd);
    }
}
