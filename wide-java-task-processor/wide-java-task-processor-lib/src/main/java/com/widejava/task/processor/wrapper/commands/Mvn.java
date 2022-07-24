package com.widejava.task.processor.wrapper.commands;

public class Mvn extends Command {

    public Mvn() {
        this(new String[0]);
    }

    public Mvn(String[] parameters) {
        super("mvn", "mvn.cmd", parameters);
    }

}
