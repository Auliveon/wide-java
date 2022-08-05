package com.widejava.task.processor.wrapper.commands;

public class WithoutColor extends Command {

    public WithoutColor() {
        this(new String[0]);
    }

    public WithoutColor(String[] parameters) {
        super("-B", "-B", parameters);
    }

}
