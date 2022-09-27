package com.romijulianto.restapicarspringboot.services;

import com.romijulianto.restapicarspringboot.entities.CarEntity;

import java.util.List;

public interface CarService {

    /* method addCar moving from Controller */
    CarEntity addCar(CarEntity param);

    List<CarEntity> getAllCar();
}
