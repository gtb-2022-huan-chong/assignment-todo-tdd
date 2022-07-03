package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {
    @BeforeEach
    void setUp() {
        writeDataFile(List.of("+ Task 01", "+ Task 02", "x Task 03", "x Task 04"));
    }


    @Nested
    class ListCommandTest {

        @Nested
        class WhenThereAreExistingTasksTest {

            @Test
            void should_list_existing_tasks() {
                List<String> result = new App().run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 Task 01",
                        "2 Task 02",
                        "# Completed",
                        "3 Task 03",
                        "4 Task 04"
                ), result);
            }
        }
    }

    @Nested
    class AddCommandTest {

        @Nested
        class WhenSingleWordProvidedTest {

            @Test
            void should_add_task_with_single_word_as_name() {

                new App().run("add", "foobar");

                List<String> result = new App().run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 Task 01",
                        "2 Task 02",
                        "5 foobar",
                        "# Completed",
                        "3 Task 03",
                        "4 Task 04"
                ), result);
            }
        }
    }


    private void writeDataFile(final List<String> lines) {
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
