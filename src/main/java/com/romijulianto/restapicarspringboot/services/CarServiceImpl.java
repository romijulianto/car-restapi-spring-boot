package com.romijulianto.restapicarspringboot.services;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import com.romijulianto.restapicarspringboot.entities.CarImage;
import com.romijulianto.restapicarspringboot.repositories.CarImageRepository;
import com.romijulianto.restapicarspringboot.repositories.CarRepository;
import com.romijulianto.restapicarspringboot.wrappers.CarImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    /* load repository here */
    @Autowired
    CarRepository carRepository;

    /* load CarImageRepository here */
    @Autowired
    CarImageRepository carImageRepository;

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
        /* add method delete */
        carRepository.deleteById(id);
    }

    @Override
    public CarImage uploadImage(CarImageWrapper carImageWrapper) {

        /* create new object for save */
        CarImage carImage = new CarImage();
        /* find CarById in table Car */
        carImage.setCar(carRepository.findById(carImageWrapper.getCarId()).get());
        carImage.setContentType(carImageWrapper.getContentType());
        carImage.setBase64(carImageWrapper.getBase64());
        return carImageRepository.save(carImage);
    }
}
