package com.allstate.repositories;

import com.allstate.entities.City;
import com.sun.tools.javac.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 31/01/17.
 */
public interface ICityRepository extends CrudRepository<City,Integer> {

        City findByName(String name);

       // Integer deleteByName(String name);

        List<City> removeByName(String name);
}
