package com.widejava.task.processor.wrapper.commands;

public class Clean extends Command {

    public Clean() {
        this(new String[0]);
    }

    public Clean(String[] parameters) {
        super("clean", "clean", parameters);
    }

}
