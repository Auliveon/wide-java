package com.widejava.task.processor.wrapper.commands;

public class Test extends Command {

    public Test() {
        this(new String[0]);
    }

    public Test(String[] parameters) {
        super("test", "test", parameters);
    }

}
