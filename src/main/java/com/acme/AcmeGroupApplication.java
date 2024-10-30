package com.acme;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@EnableWebMvc
@SpringBootApplication
public class AcmeGroupApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcmeGroupApplication.class, args);
    }
}
