package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveCommand extends Command{
    private final String[] restArgs;

    public RemoveCommand(final String[] restArgs, final TaskRepository taskRepository) {
        super(taskRepository);
        this.restArgs = restArgs;
    }


    @Override
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
