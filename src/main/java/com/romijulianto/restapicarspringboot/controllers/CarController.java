package com.romijulianto.restapicarspringboot.controllers;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // to use rest api project
@RequestMapping(value = "/car") // mapping url to call rest api
public class CarController {

    /* call CarRepository here */
    @Autowired
    CarRepository carRepository;

    /* method getCar */
    @GetMapping(value = "checkAPI")
    public String checkApi() {
        return "Hello World";
    }

    /* method addNewCar */
    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param) {

        /* save body from CarEntity to CarRepository */
        carRepository.save(param);
        return param;
    }
}
