package com.widejava.task.processor.service;

import com.widejava.task.processor.constant.MavenCommandsEnum;
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

    public ExternalProjectTestService(@Value("${project.external.processor.work.directory:asd}")
                                      String workDirectory) {
        this.workDirectory = workDirectory;
    }

    public void initTests(String projectName) {
        log.debug("Run test: {}", projectName);
        ProcessWrapperBuilder processWrapperBuilder = new ProcessWrapperBuilder();
        ProcessWrapper processWrapper = processWrapperBuilder.setWorkPath(workDirectory + "/" + projectName).setCommandsEnum(MavenCommandsEnum.TEST).build();
        System.out.println(processWrapper.run());
    }
}
