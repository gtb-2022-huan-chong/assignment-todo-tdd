package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class Section {
    public static final String COMPLETED = "# Completed";
    public static final String TO_BE_DONE = "# To be done";
    private final String title;
    private final boolean flag;

    public Section(String title, boolean flag) {
        this.title = title;
        this.flag = flag;
    }

    static Section completed() {
        return new Section(COMPLETED, true);
    }

    static Section tbd() {
        return new Section(TO_BE_DONE, false);
    }

    public String getTitle() {
        return title;
    }

    public boolean isFlag() {
        return flag;
    }

    List<String> format(List<Task> tasks) {
        final List<String> result = new ArrayList<>();

        result.add(getTitle());
        tasks.stream()
                .filter(this::isTypeMatched)
                .map(Task::format)
                .forEach(result::add);
        return result;
    }

    private boolean isTypeMatched(Task task) {
        return isFlag() == task.isCompleted();
    }
}
