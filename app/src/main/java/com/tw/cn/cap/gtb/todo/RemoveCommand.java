package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class RemoveCommand {
    private final String[] restArgs;
    private final TaskRepository taskRepository;

    public RemoveCommand(final String[] restArgs, final TaskRepository taskRepository) {
        this.restArgs = restArgs;
        this.taskRepository = taskRepository;
    }


    public List<String> execute() {
        this.taskRepository.delete(Integer.parseInt(restArgs[0]));
        return List.of();
    }
}
