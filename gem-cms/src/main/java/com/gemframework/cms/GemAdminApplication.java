package com.gemframework.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//开启jpa审计功能
@EnableJpaAuditing
public class GemAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GemAdminApplication.class, args);
    }

}
