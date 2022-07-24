package com.widejava.task.processor.wrapper.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Command {

    private final String unixCmd;

    public final String winCmd;

    private final String[] parameters;

    protected Command(String unixCmd, String winCmd) {
       this(unixCmd, winCmd, new String[0]);
    }

    protected Command(String unixCmd, String winCmd, String[] parameters) {
        this.unixCmd = unixCmd;
        this.winCmd = winCmd;
        this.parameters = parameters;
    }

    public String getUnixCmd() {
        return unixCmd;
    }

    public String getWinCmd() {
        return winCmd;
    }

    public String[] getParameters() {
        return parameters;
    }

    public List<String> getCommandAsList() {
        List<String> result = new ArrayList<>();
        result.add(unixCmd);
        result.addAll(Arrays.asList(parameters));
        return result;
    }

    //TODO: Make system type checker
    protected String getSystemType() {
        return "unix";
    }

    @Override
    public String toString() {
        return "Command{" +
                "unixCmd='" + unixCmd + '\'' +
                ", winCmd='" + winCmd + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }

}
