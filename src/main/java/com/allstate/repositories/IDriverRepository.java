package com.allstate.repositories;

import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by localadmin on 31/01/17.
 */
public interface IDriverRepository extends CrudRepository<Driver,Integer> {
    Driver findByName(String name);

    List<Driver> findByGender(Gender gender);
}
