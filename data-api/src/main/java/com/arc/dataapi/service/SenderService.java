package com.arc.dataapi.service;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.GenericEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenderService.class);

    @Qualifier("eventBus")
    @Autowired
    private EventBus eventBus;

    public <T> void send(T event) {
        LOGGER.info("publishing event {}", event);
        EventMessage<T> eventMessage = GenericEventMessage.asEventMessage(event);

        eventBus.publish(eventMessage);
    }
}
