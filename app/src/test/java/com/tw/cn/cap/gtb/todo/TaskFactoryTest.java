package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskFactoryTest {

    @Test
    void should_parse_completed_property_for_task() {
        boolean isCompleted = TaskFactory.createTask(1, "+ foo").isCompleted();
        Assertions.assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        Task task = TaskFactory.createTask(1, "+  foo  bar   ");
        String name = task.getName();
        Assertions.assertEquals(" foo  bar   ", name);
    }

}
