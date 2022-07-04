package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {


    List<Task> loadTasks() {
        List<String> lines = readTaskLines();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(TaskFactory.createTask(i + 1, lines.get(i)));
        }
        return tasks.stream().filter(task -> !task.isDelete()).collect(Collectors.toList());
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void create(final Task task) {
        final var taskName = task.getName();
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            bw.write("+ + " + taskName);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void delete(final Integer id) {
        final var tasks = loadTasks();
        tasks.stream().filter(task -> task.getId() == id).forEach(Task::delete);

        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Task task : tasks) {

                final var completeSign = task.isCompleted() ? "x" : "+";
                final var deleteSign = task.isDelete() ? "x" : "+";
                bw.write(completeSign + " " + deleteSign + " " + task.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new TodoException();
        }
    }
}
