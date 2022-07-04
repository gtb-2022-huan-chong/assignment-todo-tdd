package com.tw.cn.cap.gtb.todo;

import java.util.Objects;

public class Task {
    private final int id;
    private final String name;
    private final boolean isCompleted;
    private final boolean deleted;


    public Task(int id, String name, boolean isCompleted, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
        this.deleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Task task = (Task) o;
        return id == task.id && isCompleted == task.isCompleted && deleted == task.deleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted);
    }
}
