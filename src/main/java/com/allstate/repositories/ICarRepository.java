package com.allstate.repositories;


import com.allstate.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICarRepository extends CrudRepository<Car,Integer>{
    Car findByModel(String model);
    List<Car> findByYearGreaterThanEqual(int year);
}
