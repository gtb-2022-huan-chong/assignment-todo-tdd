package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskMarshallerTest {

    @Test
    void should_parse_completed_property_for_task() {
        boolean isCompleted = TaskMarshaller.unmarshal(1, "+ foo").isCompleted();
        Assertions.assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        Task task = TaskMarshaller.unmarshal(1, "+  foo  bar   ");
        String name = task.getName();
        Assertions.assertEquals(" foo  bar   ", name);
    }

}
