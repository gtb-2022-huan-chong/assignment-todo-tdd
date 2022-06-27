package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {
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
