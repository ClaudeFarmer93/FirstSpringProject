package org.example.firstspringproject.controller;

import org.example.firstspringproject.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

//    @GetMapping("/german")
//    public String sagHallo() {
//        return "Hallo Welt";
//    }

    @GetMapping("/{name}")
    public String greetUser(@PathVariable String name) {
        return "Welcome back " + name;
    }

}
