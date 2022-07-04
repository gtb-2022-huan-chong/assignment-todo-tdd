package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if (args.length > 0 && args[0].equals("add")) {
            return new AddCommand(args, new TaskRepository()).execute();
        }
        return new ListCommand().run();

    }

}
