package com.tw.cn.cap.gtb.todo;

import java.util.List;

public abstract class Command {
    final TaskRepository taskRepository;

    public Command(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    abstract List<String> execute();
}
