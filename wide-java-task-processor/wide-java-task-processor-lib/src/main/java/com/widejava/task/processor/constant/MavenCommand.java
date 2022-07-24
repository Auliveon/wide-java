package com.widejava.task.processor.constant;

public enum MavenCommand {

    MAVEN_BASE("mvn", false, true, true),
    WIN_MAVEN_BASE("mvn.cmd", true, false, false),
    MVN_TEST("test", false, false, true),
    MVN_CLEAN("clean", false, false, true),
    MVN_INSTALL("install", false, false, true);
    private final String command;

    private final boolean windows;

    private final boolean unix;

    private final boolean general;

    MavenCommand(String command, boolean windows, boolean unix, boolean general) {
        this.command = command;
        this.windows = windows;
        this.unix = unix;
        this.general = general;
    }

    public String getCommand() {
        return command;
    }

    public boolean isWindows() {
        return windows;
    }

    public boolean isUnix() {
        return unix;
    }

    public boolean isGeneral() {
        return general;
    }
}
