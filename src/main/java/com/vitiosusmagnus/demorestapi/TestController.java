package com.vitiosusmagnus.demorestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestRepository repo;

    @GetMapping("/")
    public String welcome(){
        String name = repo.findById(Long.valueOf(1)).orElseThrow().getName();

        return  "<h1>" +
                 name +
                "Beyzayi Cok Seviyor" +
                "<h1>";
    }
}
