package com.widejava.task.processor.wrapper;

import com.widejava.task.processor.wrapper.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessWrapper {

    Logger log = LoggerFactory.getLogger(ProcessWrapper.class);

    private String workPath;

    private List<Command> commands = new ArrayList<>();

    public ProcessWrapper(String workPath, List<Command> commands) {
        this.workPath = workPath;
        this.commands = commands;
    }

    public String run() {
        log.debug("Running command: {}", Arrays.toString(transformCommands()));
        Process process = null;
        String result = null;
        try {
            final String[] transformedCommands = transformCommands();
            final ProcessBuilder processBuilder = new ProcessBuilder(transformedCommands);
            processBuilder.directory(new File(workPath));
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            result = new BufferedReader(new InputStreamReader(process.getInputStream()))
                    .lines().collect(Collectors.joining("\n"));
            process.waitFor();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(process)) {
                process.destroy();
            }
        }
    }

    private String[] transformCommands() {
       return commands.stream().map(Command::getCommandAsList).flatMap(Collection::stream).toArray(String[]::new);
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "ProcessWrapper{" +
                "workPath='" + workPath + '\'' +
                ", commands=" + commands +
                '}';
    }

}
