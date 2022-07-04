package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if (args.length <= 0) {
            return new ListCommand().run();
        }
        final var restArgs = Arrays.copyOfRange(args, 1, args.length);
        if (args[0].equals("add")) {
            return new AddCommand(restArgs, new TaskRepository()).execute();
        }

        if (args[0].equals("remove")) {
            return new RemoveCommand(restArgs, new TaskRepository()).execute();
        }

        return new ListCommand().run();

    }

}
