package com.tw.cn.cap.gtb.todo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommandTest {

    private MyTaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new MyTaskRepository();
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        final var command = new AddCommand(new String[]{"add", "fizz", "buzz"}, taskRepository);
        command.execute();
        final var taskName = taskRepository.getTaskName();
        assertEquals("fizz buzz", taskName);
    }


    @Test
    void should_use_empty_name_no_args_provided() {
        final var command = new AddCommand(new String[]{"add"}, taskRepository);
        command.execute();
        final var taskName = taskRepository.getTaskName();
        assertEquals("", taskName);
    }

    private static class MyTaskRepository extends TaskRepository {
        private Task task;

        @Override
        List<String> create(final Task task) {
            this.task = task;
            return List.of();
        }

        public String getTaskName() {
            return this.task.getName();
        }
    }
}
