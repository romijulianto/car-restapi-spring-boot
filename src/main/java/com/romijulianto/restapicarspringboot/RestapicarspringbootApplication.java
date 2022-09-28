package com.romijulianto.restapicarspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestapicarspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapicarspringbootApplication.class, args);
    }

}
