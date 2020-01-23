package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newww {
    @GetMapping("/")
    public String show(){

        return "I am in app";

    }
}
