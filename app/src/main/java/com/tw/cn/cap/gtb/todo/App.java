package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class App {

    private final TaskRepository taskRepository = new TaskRepository();
    private final CommandFactory commandFactory = new CommandFactory();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if (args.length <= 0) {
            throw new TodoException();
        }
        return commandFactory.createCommand(this.taskRepository, args).execute();
    }
}
