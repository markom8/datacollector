package com.arc.dataapi;


import com.arc.dataevents.events.MyEvent;
import com.arc.dataevents.events.MySagaEndEvent;
import com.arc.dataevents.events.MySagaStartEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

import java.util.concurrent.TimeUnit;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class DataApiApplication{
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(DataApiApplication.class, args);

    }

//    @Override
//    public void run(String... args) throws Exception {
//        LOGGER.info("Start sending");
//        final long processId = 1234;
//        for (int i = 0; i < 20; i++) {
//            TimeUnit.SECONDS.sleep(5);
//            sender.send(new MyEvent(String.format("Hi there %d", i)));
//            if (i == 5) {
//                sender.send(new MySagaStartEvent(processId));
//            }
//        }
//        sender.send(new MySagaEndEvent(processId));
//        LOGGER.info("Send completed");
//    }
}
