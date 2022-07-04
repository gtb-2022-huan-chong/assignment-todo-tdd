package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TestUtil {
    static void writeDataFile(final List<String> lines) {
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for (final String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
