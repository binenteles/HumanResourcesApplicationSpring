package com.sda.humanresourcesapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HumanResourcesApplication {

    public static void main(String[] args) {
        log.info(" Application started");
        SpringApplication.run(HumanResourcesApplication.class, args);
        log.info(" Application ended");
    }

}
