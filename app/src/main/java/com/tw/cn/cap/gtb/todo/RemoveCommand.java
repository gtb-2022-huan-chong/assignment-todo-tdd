package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Stream;

public class RemoveCommand {
    private final String[] restArgs;
    private final TaskRepository taskRepository;

    public RemoveCommand(final String[] restArgs, final TaskRepository taskRepository) {
        this.restArgs = restArgs;
        this.taskRepository = taskRepository;
    }


    public List<String> execute() {
        Stream.of(restArgs)
                .map(Integer::valueOf)
                .forEach(this.taskRepository::delete);
        return List.of();
    }
}
