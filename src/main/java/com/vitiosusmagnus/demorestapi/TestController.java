package com.vitiosusmagnus.demorestapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/")
    public String welcome(){
        return "index";
    }
}
