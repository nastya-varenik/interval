package by.verenich.Intervalproject.reader.impl;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.creator.IntervalFactory;
import by.verenich.Intervalproject.reader.FileReaderUtil;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class FileReaderUtilImpl extends FileReaderUtil {

    private static final Logger logger = Logger.getLogger(FileReaderUtilImpl.class.getName());

    public FileReaderUtilImpl(IntervalFactory intervalFactory) {
        super(intervalFactory);
    }

    @Override
    public List<Interval> readFromFile(String filename) {
        List<Interval> intervals = new ArrayList<>();

        logger.info("Starting to read from file: " + filename);

        long startTime = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    Interval interval = getIntervalParser().parseLine(line);
                    intervals.add(interval);
                } catch (NumberFormatException e) {
                    logger.warning("Number format error on line " + lineNumber + ": " + line + " — " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    logger.warning("Parsing error on line " + lineNumber + ": " + line + " — " + e.getMessage());
                }
            }
        } catch (IOException e) {
            logger.severe("File reading error: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        logger.info("Finished reading from file. Total intervals read: " + intervals.size());
        logger.info("Reading took " + (endTime - startTime) + " milliseconds.");

        return intervals;
    }
}
