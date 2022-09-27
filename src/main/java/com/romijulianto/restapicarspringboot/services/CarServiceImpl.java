package com.romijulianto.restapicarspringboot.services;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    /* load repository here */
    @Autowired
    CarRepository carRepository;

    /* implement from interface CarService */
    @Override
    public CarEntity addCar(CarEntity param) {
        return carRepository.save(param); // from CarController
    }

    @Override
    public List<CarEntity> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {

        /* add method to findCar updated by Id */
        CarEntity findCarById = carRepository.findById(param.getId()).get();
        findCarById.setCarName(param.getCarName());
        findCarById.setColor(param.getColor());
        findCarById.setNumber(param.getNumber());
        findCarById.setType(param.getType());

        return carRepository.save(param);
    }

    @Override
    public void deleteCar(int id) {

    }
}
