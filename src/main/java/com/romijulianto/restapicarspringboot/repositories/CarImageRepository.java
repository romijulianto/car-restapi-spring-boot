package com.romijulianto.restapicarspringboot.repositories;

import com.romijulianto.restapicarspringboot.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
}
