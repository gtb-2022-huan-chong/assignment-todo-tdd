package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tw.cn.cap.gtb.todo.TestUtil.writeDataFile;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {
    @BeforeEach
    void setUp() {
        writeDataFile(List.of(
                "+ + Task 01",
                "+ + Task 02",
                "x + Task 03",
                "x + Task 04"));
    }
    @Test
    void should_delete_multiple_tasks() {
        final var taskRepository = new TaskRepository();
        taskRepository.delete(1);
        taskRepository.delete(3);
        final var result = taskRepository.loadTasks();
        assertEquals(List.of(
                new Task(2, "Task 02", false, false),
                new Task(4, "Task 04", true, false)
        ), result);
    }

}
