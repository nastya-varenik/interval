package by.verenich.Intervalproject.util;

import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.creator.IntervalFactory;

import java.io.*;
import java.util.*;

public class FileReaderUtil {

    private static final String FILE_READ_ERROR = "Ошибка чтения файла: ";
    private static final String PARSE_ERROR = "Ошибка разбора строки: ";
    private static final String NUMBER_FORMAT_ERROR = "Ошибка преобразования числа в строке: ";

    private final IntervalParser intervalParser;

    public FileReaderUtil(IntervalFactory intervalFactory) {
        this.intervalParser = new IntervalParser(intervalFactory);
    }

    public List<Interval> readFromFile(String filename) {
        List<Interval> intervals = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Interval interval = intervalParser.parseLine(line);
                    intervals.add(interval);
                } catch (NumberFormatException e) {
                    System.err.println(NUMBER_FORMAT_ERROR + line + " — " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println(PARSE_ERROR + line + " — " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(FILE_READ_ERROR + e.getMessage());
        }

        return intervals;
    }
}
