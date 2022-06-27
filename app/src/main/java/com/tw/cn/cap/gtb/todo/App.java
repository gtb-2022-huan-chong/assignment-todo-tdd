package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        List<Task> tasks = loadTasks();

        List<String> result = new ArrayList<>();
        result.add("# To be done");
        for (Task task : tasks) {
            result.add(task.format());
        }


        return result;
    }

    private List<Task> loadTasks() {
        List<String> lines = readTaskLines();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            int id = i + 1;
            String line = lines.get(i);
            String name = line;
            Task task = new Task(id, name);
            tasks.add(task);
        }
        return tasks;
    }

    private List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new ToDOCannotReadFileException();
        }
    }
}
