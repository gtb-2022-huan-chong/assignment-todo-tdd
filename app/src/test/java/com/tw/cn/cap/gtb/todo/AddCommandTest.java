package com.tw.cn.cap.gtb.todo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddCommandTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        final var command = new AddCommand(new String[]{"fizz", "buzz"}, taskRepository);

        command.execute();

        verify(taskRepository).create(new Task(0,"fizz buzz",false, false));
    }

    @Test
    void should_use_empty_name_no_args_provided() {
        final var command = new AddCommand(new String[]{}, taskRepository);

        command.execute();

        verify(taskRepository).create(new Task(0,"",false, false));
    }
}
