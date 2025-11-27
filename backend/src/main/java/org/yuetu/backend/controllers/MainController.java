package org.yuetu.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/hello")
    public String greeting(@RequestParam(value = "Spring", defaultValue = "World!")String name) {
        return String.format("Hello, %s!", name);
    }
}
