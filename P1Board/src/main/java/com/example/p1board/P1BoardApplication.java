package com.example.p1board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class P1BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(P1BoardApplication.class, args);
    }

}
