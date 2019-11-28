package com.gemframework.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaAuditing
public class GemBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(GemBasicApplication.class, args);
    }

}
