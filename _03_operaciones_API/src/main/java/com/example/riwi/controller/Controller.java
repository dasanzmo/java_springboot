
package com.example.riwi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class Controller {

    @GetMapping
    public String greet(){
        return "Hello world!";
    }

}