package com.smartpass.smartpassbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class SmartpassBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartpassBackendApplication.class, args);
    }

}
