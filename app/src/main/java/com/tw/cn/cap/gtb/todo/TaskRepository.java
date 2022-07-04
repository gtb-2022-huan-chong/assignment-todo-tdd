package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {


    private final TaskMarshaller taskMarshaller = new TaskMarshaller();

    List<Task> loadTasks() {
        List<Task> tasks = loadsAllTasks();
        return tasks.stream().filter(task -> !task.isDeleted()).collect(Collectors.toList());
    }

    private List<Task> loadsAllTasks() {
        List<String> lines = readTaskLines();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshaller.unmarshal(i + 1, lines.get(i)));
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void create(final Task task) {
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            final String line = taskMarshaller.marshal(task);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void delete(int id) {
        final var tasks = loadsAllTasks();
        tasks.stream().filter(task -> id == task.getId()).forEach(Task::delete);

        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for (final Task task : tasks) {
                bw.write(taskMarshaller.marshal(task));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new TodoException();
        }
    }
}
