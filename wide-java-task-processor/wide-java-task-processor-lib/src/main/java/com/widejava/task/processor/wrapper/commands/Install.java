package com.widejava.task.processor.wrapper.commands;

public class Install extends Command {

    public Install() {
        this(new String[0]);
    }

    public Install(String[] parameters) {
        super("install", "install", parameters);
    }

}
