package com.romijulianto.restapicarspringboot.controllers;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to use rest api project
@RequestMapping(value = "/car") // mapping url to call rest api
public class CarController {

    /* call CarService */
    @Autowired
    CarService carService;

    /* method getCar */
    @GetMapping(value = "checkAPI")
    public String checkApi() {
        return "Hello World";
    }

    /* method addNewCar */
    @PostMapping(value = "add")
    public CarEntity addNewCar(@RequestBody CarEntity param) {

        /* use CarService to safe data repository */
        CarEntity car =  carService.addCar(param);
        return car;
    }

    /* method getAllCar */
    @GetMapping(value = "")
    public List<CarEntity> getAllCar() {

        /* initiate list for need to CarService */
        List<CarEntity> carList = carService.getAllCar();
        return carList;
    }

    /* method getCarById */
    @GetMapping(value = "getCarId")
    public CarEntity getCarById(@RequestParam int id) {

        CarEntity car = carService.getCarById(id);
        return car;
    }

    /* method updateCar */
    @PostMapping(value = "update")
    public CarEntity updateCar(@RequestBody CarEntity param) {

        CarEntity car = carService.updateCar(param);
        return car;
    }

    /* method deleteCar */
    @GetMapping(value = "delete")
    public List<CarEntity> deleteCar(@RequestParam int id) {

        carService.deleteCar(id);
        List<CarEntity> carList = carService.getAllCar();
        return carList;
    }
}
