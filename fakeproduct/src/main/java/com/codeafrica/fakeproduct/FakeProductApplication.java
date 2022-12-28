package com.codeafrica.fakeproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FakeProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeProductApplication.class,args);
    }
}
