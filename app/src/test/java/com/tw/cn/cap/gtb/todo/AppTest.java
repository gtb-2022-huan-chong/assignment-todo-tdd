package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        TestUtil.writeDataFile(List.of(
                "+ + Task 01",
                "+ + Task 02",
                "x + Task 03",
                "x + Task 04"));
        app = new App();
    }


    @Nested
    class ListCommandTest {

        @Nested
        class WhenThereAreExistingTasksTest {

            @Test
            void should_list_existing_tasks() {
                //given

                //when
                List<String> result = app.run("list");
                //then
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

                //given
                //when
                app.run("add", "foobar");
                //then
                final var result = app.run("list");
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

    @Nested
    class RemoveCommandTest {

        @Nested
        class WhenRemoveSingleTaskTest {

            @Test
            void should_remove_one_task() {

                //given
                //when
                app.run("remove", "1");
                //then
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 Task 02",
                        "# Completed",
                        "3 Task 03",
                        "4 Task 04"
                ), result);
            }
        }

        @Nested
        class WhenRemoveMultipleTaskTest {

            @Test
            void should_remove_them_all_task() {

                //given
                //when
                app.run("remove", "1", "3");
                //then
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 Task 02",
                        "# Completed",
                        "4 Task 04"
                ), result);
            }
        }
    }

}
