package com.vitiosusmagnus.demorestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestApiApplication implements CommandLineRunner {

    @Autowired
    TestRepository repo;
    public static void main(String[] args) {
        SpringApplication.run(DemoRestApiApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {
        TestEntity person = new TestEntity();
        person.setId(Long.valueOf(1));
        person.setName("Furkan");
        repo.save(person);
    }
}
