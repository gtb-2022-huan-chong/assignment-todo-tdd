package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Nested
    class EqualsTest {

        @Nested
        class ShouldReturnTrueTest {
            @Test
            void when_all_properties_are_same() {
                assertEquals(new Task(1, "foobar", false, false), new Task(1, "foobar", false, false));
                assertEquals(new Task(1, "foobar", true, false), new Task(1, "foobar", true, false));
                assertEquals(new Task(1, "foobar", true, true), new Task(1, "foobar", true, true));
            }
        }

        @Nested
        class ShouldReturnFalseTest {
            @Test
            void when_all_properties_id_different() {
                assertNotEquals(new Task(1, "foobar", true, false), new Task(1, "foobar", false, false));
                assertNotEquals(new Task(1, "foobar", false, false), new Task(1, "foo", true, false));
                assertNotEquals(new Task(2, "foobar", false, false), new Task(2, "foobar", true, false));
                assertNotEquals(new Task(2, "foobar", true, true), new Task(2, "foobar", true, false));
            }
        }
    }


}
