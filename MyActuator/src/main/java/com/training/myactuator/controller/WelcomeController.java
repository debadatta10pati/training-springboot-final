package com.training.myactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome to Spring boot on IntelliJ";
    }

    @GetMapping("/bye")
    public String bye()
    {
        return "Bye bye Spring boot on IntelliJ";
    }

}
