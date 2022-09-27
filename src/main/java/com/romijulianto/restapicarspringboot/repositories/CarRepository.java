package com.romijulianto.restapicarspringboot.repositories;

import com.romijulianto.restapicarspringboot.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // to define this file is repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
