package com.vti.kshop_exam.Reponsity;

import com.vti.kshop_exam.Enity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepon extends JpaRepository<Car,Car.PrimaryKey> {
    void deleteById(Car.PrimaryKey key);
}
