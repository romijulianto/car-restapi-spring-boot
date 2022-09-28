package com.romijulianto.restapicarspringboot.services;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.entities.CarImage;
import com.romijulianto.restapicarspringboot.wrappers.CarImageWrapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface CarService {

    /* method moving from Controller */
    CarEntity addCar(CarEntity param);

    List<CarEntity> getAllCar();

    CarEntity getCarById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);

    CarImage uploadImage(CarImageWrapper carImageWrapper);
}
