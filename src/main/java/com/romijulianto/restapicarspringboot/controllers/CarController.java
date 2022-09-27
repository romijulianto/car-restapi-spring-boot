package com.romijulianto.restapicarspringboot.controllers;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping(value = "add")
    public CarEntity addNewCar(@RequestBody CarEntity param) {

        /* save body from CarEntity to CarRepository */
        carRepository.save(param);
        return param;
    }

    /* method getAllCar */
    @GetMapping(value = "")
    public List<CarEntity> getAllcar() {
        return carRepository.findAll();
    }

    /* method getCarById */
    @GetMapping(value = "getCarId")
    public CarEntity getCarById(@RequestParam int id) {
        return carRepository.findById(id).get();
    }

    /* method updateCar */
    @PostMapping(value = "update")
    /* option 1 to updateCar
    public String updateCar(@RequestBody CarEntity param) {
        return carRepository.save(param).toString();
    }
     */

    /* option 2 to updateCar */
    public CarEntity updateCar(@RequestBody CarEntity param) {
        return carRepository.save(param);
    }

    /* method deleteCar */

    /* option 1 with return message
    @GetMapping(value = "delete")
    public String deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);
        return "Deleted Car with ID: " + id;
    }
    */

    /* option 2 with return data has been deleted */
    @GetMapping(value = "delete")
    public CarEntity deleteCar(@RequestParam int id) {
        CarEntity car = carRepository.findById(id).get();
        carRepository.deleteById(id);
        return car;
    }
}
