package com.allstate.services;


import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private IPassengerRepository passengerRepository;

    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger create(Passenger passenger){
            return this.passengerRepository.save(passenger);
    }

    public Passenger findById(int id){
        return this.passengerRepository.findOne(id);
    }

    public Passenger findByName(String name) {
        return this.passengerRepository.findByName(name);
    }

    public List<Passenger> findByGender(Gender gender) {
        return this.passengerRepository.findByGender(gender);
    }

    public List<Passenger> findByAgeGreaterThanEqual(int age){
        return this.passengerRepository.findByAgeGreaterThanEqual(age);
    }

    void deleteById(int id){
        this.passengerRepository.delete(id);
    }
}
