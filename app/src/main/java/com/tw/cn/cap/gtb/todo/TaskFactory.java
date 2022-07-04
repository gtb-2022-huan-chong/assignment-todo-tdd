package com.tw.cn.cap.gtb.todo;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        String[] fields = line.split(" ", 3);
        final var name = fields[2];
        boolean isCompleted = fields[0].equals("x");
        boolean isDeleted = fields[1].equals("x");
        return new Task(id, name, isCompleted, isDeleted);
    }
}
