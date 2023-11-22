package com.julioluis.amystudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorAwareRef")
public class AmyStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmyStudioApplication.class, args);
    }

}
