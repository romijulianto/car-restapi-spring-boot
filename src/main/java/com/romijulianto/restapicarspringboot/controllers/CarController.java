package com.romijulianto.restapicarspringboot.controllers;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.entities.CarImage;
import com.romijulianto.restapicarspringboot.response.CommonResponse;
import com.romijulianto.restapicarspringboot.response.CommonResponseGenerator;
import com.romijulianto.restapicarspringboot.services.CarService;
import com.romijulianto.restapicarspringboot.wrappers.CarImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to use rest api project
@RequestMapping(value = "/car") // mapping url to call rest api
public class CarController {

    /* call CarService */
    @Autowired
    CarService carService;

    /* call CommonResponse */
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

        try {
            /* use CarService to safe data repository */
            CarEntity car =  carService.addCar(param);
            return commonResponseGenerator.successResponse(car, "Success add new car");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* method getAllCar */
    @GetMapping(value = "")
    public CommonResponse<List<CarEntity>> getAllCar() {
        try {
            /* initiate list for need to CarService */
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Success get all data");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* method getCarById */
    @GetMapping(value = "getCarId")
    public CommonResponse<CarEntity> getCarById(@RequestParam int id) {

        try {
            CarEntity car = carService.getCarById(id);
            return commonResponseGenerator.successResponse(car, "Success get car by ID");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* method updateCar */
    @PostMapping(value = "update")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {
        try {
            CarEntity car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Success update car with Id : " + car.getId());
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage() + " for Id : " + param.getId());
        }
    }

    /* method deleteCar */
    @GetMapping(value = "delete")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id) {

        try {
            carService.deleteCar(id);
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Success delete car with Id : " + id);
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* method upload carImage*/
    @PostMapping(value = "upload-image")
    public CommonResponse<CarImage> uploadImage(@RequestBody CarImageWrapper param){
        try {

            CarImage car = carService.uploadImage(param);
            return commonResponseGenerator.successResponse(car, "Success upload image");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
