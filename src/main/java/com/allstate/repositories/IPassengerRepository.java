package com.allstate.repositories;

import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by localadmin on 31/01/17.
 */
public interface IPassengerRepository extends CrudRepository<Passenger, Integer> {
        Passenger findByName(String name);

        List<Passenger> findByGender(Gender gender);

        List<Passenger> findByAgeGreaterThanEqual(int age);
}
