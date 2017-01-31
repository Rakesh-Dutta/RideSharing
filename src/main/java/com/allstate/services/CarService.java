package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private ICarRepository carRepository;

    @Autowired
    public void setCarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car){
        return this.carRepository.save(car);
    }

    public Car findById(int id){
        return this.carRepository.findOne(id);
    }

    public Car findByModel(String model){
        return this.carRepository.findByModel(model);
    }

    public List<Car> findByYearGreaterThanEqual(int year){
        return this.carRepository.findByYearGreaterThanEqual(year);
    }

    void deleteById(int id){
        this.carRepository.delete(id);
    }
}
