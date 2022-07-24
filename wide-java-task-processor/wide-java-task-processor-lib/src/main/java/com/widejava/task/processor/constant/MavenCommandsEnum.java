package com.widejava.task.processor.constant;

import com.widejava.task.processor.wrapper.commands.Command;
import com.widejava.task.processor.wrapper.commands.Mvn;
import com.widejava.task.processor.wrapper.commands.Test;

public enum MavenCommandsEnum {

    TEST(new Mvn(), new Test());

    private final Command[] commands;

    MavenCommandsEnum(Command... commands) {
        this.commands = commands;
    }

    public Command[] getCommands() {
        return commands;
    }
}
