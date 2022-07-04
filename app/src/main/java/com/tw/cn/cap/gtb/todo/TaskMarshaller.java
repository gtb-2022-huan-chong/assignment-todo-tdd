package com.tw.cn.cap.gtb.todo;

public class TaskMarshaller {
    TaskMarshaller() {
    }

    String marshal(Task task) {

        final var completedSign = task.isCompleted() ? "x" : "+";
        final var deletedSign = task.isDeleted() ? "x" : "+";
        return completedSign + " " + deletedSign + " " + task.getName();
    }

    Task unmarshal(int id, String line) {
        String[] fields = line.split(" ", 3);
        boolean isCompleted = fields[0].equals("x");
        final var isDeleted = fields[1].equals("x");
        final var name = fields[2];
        return new Task(id, name, isCompleted, isDeleted);
    }
}
