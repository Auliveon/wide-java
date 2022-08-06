package com.widejava.task.processor.service;

import com.widejava.task.processor.constant.MavenCommandsEnum;
import com.widejava.task.processor.constant.RegexConstant;
import com.widejava.task.processor.wrapper.ProcessWrapper;
import com.widejava.task.processor.wrapper.ProcessWrapperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class ExternalProjectTestService {

    Logger log = LoggerFactory.getLogger(ExternalProjectTestService.class);

    private final String workDirectory;

    private final MavenOutputParseService mavenOutputService;

    public ExternalProjectTestService(@Value("${project.external.processor.work.directory:}")
                                      String workDirectory, MavenOutputParseService mavenOutputService) {
        this.workDirectory = workDirectory;
        this.mavenOutputService = mavenOutputService;
    }

    public void initTests(String projectName) {
        log.info("Run test: {}", projectName);
        final ProcessWrapperBuilder processWrapperBuilder = new ProcessWrapperBuilder();
        final ProcessWrapper processWrapper = processWrapperBuilder.setWorkPath(workDirectory + "/" + projectName)
                .setCommandsEnum(MavenCommandsEnum.TEST).build();
        final String result = processWrapper.run();
        System.out.println(result);
    }
}
