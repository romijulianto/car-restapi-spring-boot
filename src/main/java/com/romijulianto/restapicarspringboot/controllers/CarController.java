package com.romijulianto.restapicarspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // to use rest api project
@RequestMapping(value = "/car") // mapping url to call rest api
public class CarController {

    // method getCar
    @GetMapping(value = "checkAPI")
    public String checkApi() {
        return "Hello World";
    }
}
