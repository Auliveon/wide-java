package com.widejava.rest.service;

import com.widejava.task.processor.service.ExternalProjectTestService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final ExternalProjectTestService externalProjectTestService;

    public EventService(ExternalProjectTestService externalProjectTestService) {
        this.externalProjectTestService = externalProjectTestService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationStart() {
        System.out.println(23);
        externalProjectTestService.initTests("test-project");
    }
}
