package com.tw.cn.cap.gtb.todo;

public class TaskMarshaller {
    TaskMarshaller() {
    }

    String marshal(Task task) {

        final var completedSign = task.isCompleted() ? "x" : "+";
        return completedSign + " " + task.getName();
    }

    Task unmarshal(int id, String line) {
        String[] fields = line.split(" ", 2);
        final var name = fields[1];
        boolean isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted, false);
    }
}
