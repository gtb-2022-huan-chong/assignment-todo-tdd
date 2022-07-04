package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class RemoveCommand {
    private final String[] args;
    private final TaskRepository taskRepository;

    public RemoveCommand(String[] args, TaskRepository taskRepository) {

        this.args = args;
        this.taskRepository = taskRepository;
    }

    public List<String> execute() {
        this.taskRepository.delete(Integer.valueOf(args[0]));
        return List.of();
    }
}
