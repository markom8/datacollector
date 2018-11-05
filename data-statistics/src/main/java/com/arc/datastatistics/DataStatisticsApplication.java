package com.arc.datastatistics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class DataStatisticsApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DataStatisticsApplication.class, args);
    }

    private CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void run(String... args) throws Exception {
        latch.await();
    }
}
