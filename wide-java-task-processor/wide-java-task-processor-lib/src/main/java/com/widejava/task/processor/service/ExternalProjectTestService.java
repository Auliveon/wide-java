package com.widejava.task.processor.service;

import com.widejava.task.processor.constant.MavenCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@Service
public class ExternalProjectTestService {

    Logger log = LoggerFactory.getLogger(ExternalProjectTestService.class);

    private final String workDirectory;

    public ExternalProjectTestService(@Value("${project.external.processor.work.directory:asd}")
                                      String workDirectory) {
        this.workDirectory = workDirectory;
    }

    public void initTests(String projectName) {
        log.debug("asdasd");
        Process process = null;
        BufferedReader br = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(MavenCommand.MAVEN_BASE.getCommand(), "-q", MavenCommand.MVN_TEST.getCommand());
            processBuilder.directory(new File(workDirectory + "/" + projectName));
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            process.destroy();
        }
    }
}
