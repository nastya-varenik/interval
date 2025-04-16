package by.verenich.Intervalproject;

import by.verenich.Intervalproject.creator.IntervalFactory;
import by.verenich.Intervalproject.creator.impl.IntervalFactoryImpl;
import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.reader.impl.FileReaderUtilImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IntervalFactory factory = new IntervalFactoryImpl();
        FileReaderUtilImpl fileReaderUtil = new FileReaderUtilImpl(factory);

        String filename = "src/main/java/by/verenich/Intervalproject/runner/intervals.txt";

        List<Interval> intervals = fileReaderUtil.readFromFile(filename);

        System.out.println("✅ Read intervals\n:");
        for (Interval interval : intervals) {
            System.out.println(interval);
        }
    }
}
