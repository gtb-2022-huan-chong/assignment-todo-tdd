package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveCommand {
    private final String[] restArgs;
    private final TaskRepository taskRepository;

    public RemoveCommand(final String[] restArgs, final TaskRepository taskRepository) {
        this.restArgs = restArgs;
        this.taskRepository = taskRepository;
    }


    public List<String> execute() {

        final var ids = Stream.of(restArgs)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        taskRepository.all().stream().
                filter(task -> ids.contains(task.getId()))
                .forEach(task -> taskRepository.delete(task.getId()));
        return List.of();
    }
}
