package com.nie.csd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcomAppApplication.class, args);
		System.out.println("Server is running on http://localhost:8080");
		System.out.println("running in local profile");
    }
}

