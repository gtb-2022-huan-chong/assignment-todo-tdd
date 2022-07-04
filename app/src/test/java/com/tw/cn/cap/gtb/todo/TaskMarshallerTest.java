package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TaskMarshallerTest {

    private TaskMarshaller taskMarshaller;

    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_marshal_to_plain_string(String line, Task task) {
        assertEquals(line, taskMarshaller.marshal(task));
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_unmarshal_from_text(String line, Task task) {
        assertEquals(task, taskMarshaller.unmarshal(1, line));
    }

    public static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ + foo", new Task(1, "foo", false, false)),
                Arguments.of("+ x foo", new Task(1, "foo", false, true)),
                Arguments.of("x + foo", new Task(1, "foo", true, false)),
                Arguments.of("x x foo", new Task(1, "foo", true, true)),
                Arguments.of("+ +  foo  bar   ", new Task(1, " foo  bar   ", false, false))
        );
    }
}
