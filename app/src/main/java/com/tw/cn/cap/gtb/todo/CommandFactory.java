package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;

public class CommandFactory {
    public CommandFactory() {
    }

    Command createCommand(final TaskRepository repository, final String[] args) {
        final var restArgs = Arrays.copyOfRange(args, 1, args.length);
        final var commandName = args[0];

        Command command = new UnknownCommand(repository, commandName);
        if (commandName.equals("list")) {
            command = new ListCommand(repository);
        }
        if (commandName.equals("add")) {
            command = new AddCommand(restArgs, repository);
        }
        if (args[0].equals("remove")) {
            command = new RemoveCommand(restArgs, repository);
        }
        return command;
    }
}
