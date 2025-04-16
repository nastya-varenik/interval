package by.verenich.Intervalproject.util;

import by.verenich.Intervalproject.creator.IntervalFactory;
import by.verenich.Intervalproject.creator.impl.intervalFactoryImpl;
import by.verenich.Intervalproject.entity.Interval;
import by.verenich.Intervalproject.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderUtilTest {

    @Test
    void testReadFromFile() throws IOException {
        // Подготовка тестового файла
        String fileName = "test_intervals.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("1.0,5.0,[,]\n");
            writer.write("6.0,10.0,[,]\n"); // поправил на корректные скобки
        }

        // Создание фабрики и утилиты
        IntervalFactory factory = new intervalFactoryImpl();
        FileReaderUtil readerUtil = new FileReaderUtil(factory);

        // Вызов метода
        List<Interval> intervals = readerUtil.readFromFile(fileName);

        // Проверка результата
        assertEquals(2, intervals.size());

        assertEquals(1.0, intervals.get(0).getStart());
        assertEquals(5.0, intervals.get(0).getEnd());
        assertTrue(intervals.get(0).isIncludeStart());
        assertTrue(intervals.get(0).isIncludeEnd());
    }
}
