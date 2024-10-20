package com.ruleengine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        // You can initialize some data or perform actions here
        System.out.println("Application started...");
    }
}
