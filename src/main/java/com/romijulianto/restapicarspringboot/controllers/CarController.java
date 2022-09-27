package com.romijulianto.restapicarspringboot.controllers;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.repositories.CarRepository;
import com.romijulianto.restapicarspringboot.response.CommonResponse;
import com.romijulianto.restapicarspringboot.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to use rest api project
@RequestMapping(value = "/car") // mapping url to call rest api
public class CarController {

    /* call CarRepository here */
    @Autowired
    CarRepository carRepository;

    /* call generator to use CommonResponse */
    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    /* method getCar */
    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi() {
        return commonResponseGenerator.successResponse("Hello World", "Success Running Server Java Backend");
    }

    /* method addNewCar */
    @PostMapping(value = "add")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param) {

        /* save body from CarEntity to CarRepository */
        carRepository.save(param);
        return commonResponseGenerator.successResponse(param, "Success add new car");
    }

    /* method getAllCar */
    @GetMapping(value = "")
    public CommonResponse<List<CarEntity>> getAllcar() {
        return commonResponseGenerator.successResponse(carRepository.findAll(), "Success get all data");
    }

    /* method getCarById */
    @GetMapping(value = "getCarId")
    public CommonResponse<CarEntity> getCarById(@RequestParam int id) {
        return commonResponseGenerator.successResponse(carRepository.findById(id).get(), "Success get car by ID");
    }

    /* method updateCar */
    @PostMapping(value = "update")
    /* option 1 to updateCar
    public String updateCar(@RequestBody CarEntity param) {
        return carRepository.save(param).toString();
    }
     */

    /* option 2 to updateCar */
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {
        return commonResponseGenerator.successResponse(carRepository.save(param), "Success update car");
    }

    /* method deleteCar */

    /* option 1 with return message
    @GetMapping(value = "delete")
    public String deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);
        return "Deleted Car with ID: " + id;
    }
    */

    /* option 2 with return data has been deleted
    @GetMapping(value = "delete")
    public CarEntity deleteCar(@RequestParam int id) {
        CarEntity car = carRepository.findById(id).get();
        carRepository.deleteById(id);
        return car;
    }
    */

    /* option 3 with return data list Car Available */
    @GetMapping(value = "delete")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);
        List<CarEntity> carList = carRepository.findAll();
        return commonResponseGenerator.successResponse(carList, "Success delete car with id: " + id);
    }
}
