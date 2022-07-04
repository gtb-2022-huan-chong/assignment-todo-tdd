package com.tw.cn.cap.gtb.todo;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommandTest {

    @Test
    void should_compose_task_name_using_multiple_args() {
        final var taskRepository = new TaskRepository() {
            private Task task;

            @Override
            List<String> create(final Task task) {
                this.task = task;
                return List.of();
            }

            public String getTaskName() {
                return this.task.getName();
            }
        };
        final var command = new AddCommand(new String[]{"add", "fizz", "buzz"}, taskRepository);

        command.execute();

        final var taskName = taskRepository.getTaskName();
        assertEquals("fizz buzz", taskName);
    }
}
