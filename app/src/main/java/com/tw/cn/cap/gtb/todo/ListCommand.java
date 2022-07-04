package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command {

    public ListCommand(final TaskRepository taskRepository) {
        super(taskRepository);
    }


    @Override
    List<String> execute() {
        List<Task> tasks = taskRepository.all();
        List<String> result = new ArrayList<>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));

        return result;
    }
}
