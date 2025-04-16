package by.verenich.Intervalproject.reader;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.creator.IntervalFactory;
import by.verenich.Intervalproject.parser.IntervalParser;

import java.util.List;

public abstract class FileReaderUtil {

    protected final IntervalParser intervalParser;

    // Constructor to initialize the intervalParser
    public FileReaderUtil(IntervalFactory intervalFactory) {
        this.intervalParser = new IntervalParser(intervalFactory);
    }

    // Getter for the intervalParser (so it can be used in subclasses)
    public IntervalParser getIntervalParser() {
        return intervalParser;
    }

    // Abstract method for reading from a file. Subclasses must implement this method.
    public abstract List<Interval> readFromFile(String filename);
}
