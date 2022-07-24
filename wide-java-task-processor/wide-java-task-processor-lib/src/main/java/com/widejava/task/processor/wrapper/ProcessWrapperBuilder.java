package com.widejava.task.processor.wrapper;

import com.widejava.task.processor.constant.MavenCommandsEnum;
import com.widejava.task.processor.wrapper.commands.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProcessWrapperBuilder {

    private String workPath;

    private MavenCommandsEnum commandsEnum;

    private Command[] commands;

    public ProcessWrapperBuilder() {
    }

    public ProcessWrapperBuilder(String workPath, MavenCommandsEnum commandsEnum) {
        this.workPath = workPath;
        this.commandsEnum = commandsEnum;
    }

    public String getWorkPath() {
        return workPath;
    }

    public ProcessWrapperBuilder setWorkPath(String workPath) {
        this.workPath = workPath;
        return this;
    }

    public MavenCommandsEnum getCommandsEnum() {
        return commandsEnum;
    }

    public ProcessWrapperBuilder setCommandsEnum(MavenCommandsEnum commandsEnum) {
        this.commandsEnum = commandsEnum;
        return this;
    }

    public Command[] getCommands() {
        return commands;
    }

    public ProcessWrapperBuilder setCommands(Command[] commands) {
        this.commands = commands;
        return this;
    }

    public ProcessWrapper build() {
        List<Command> commandList;
        if (Objects.nonNull(commands)) {
            commandList = Arrays.asList(commands);
        } else if (Objects.nonNull(commandsEnum)) {
            commandList = Arrays.asList(commandsEnum.getCommands());
        } else {
            throw new RuntimeException();
        }
        return new ProcessWrapper(workPath, commandList);
    }

}
