package com.romijulianto.restapicarspringboot.repositories;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<CarEntity, Integer> {
}
