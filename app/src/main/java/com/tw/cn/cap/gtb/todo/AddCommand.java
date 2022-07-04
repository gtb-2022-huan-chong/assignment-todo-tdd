package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddCommand {
    private final String[] args;
    final TaskRepository taskRepository;

    public AddCommand(final String[] args, final TaskRepository taskRepository) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

    List<String> execute() {
        final var taskName = Stream.of(args)
                .skip(1).collect(Collectors.joining(" "));
        return taskRepository.create(new Task(0, taskName, false));
    }

}
