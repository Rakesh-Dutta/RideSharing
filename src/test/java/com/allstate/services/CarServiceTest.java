package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CarServiceTest {
    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {}
    @After
    public void tearDown() throws Exception {}


    @Test
    public void shouldCreateNewCar() throws Exception {
        Driver driver = this.driverService.findById(2);
        Car before = new Car();
        before.setMake("Tata");
        before.setModel("Nano");
        before.setYear(2014);
        before.setDriver(driver);

        Car after = this.carService.create(before);
        assertEquals("Tata",after.getMake());
        assertEquals("Nano",after.getModel());
        assertEquals(2014,after.getYear());
    }

    @Test
    public void shouldFindCarById() throws Exception {
        Car car = this.carService.findById(2);
        assertEquals("Maruti",car.getMake());
    }

    @Test
    public void shouldNotFindCarById() throws Exception {
        Car car = this.carService.findById(20);
        assertNull(car);
    }

    @Test
    public void shouldFindByModel() throws Exception {
        Car car = this.carService.findByModel("Swift");
        assertEquals(2,car.getId());
        assertEquals("Maruti",car.getMake());
    }

    @Test
    public void shouldNotFindByModel() throws Exception {
        Car car = this.carService.findByModel("honda");
        assertNull(car);
    }

    @Test
    public void shouldFindByYearGreaterThan() throws Exception {
        List<Car> car = this.carService.findByYearGreaterThanEqual(2005);
        assertEquals(2, car.size());
    }

    @Test
    public void shouldNotFindByYearGreaterThan() throws Exception {
        List<Car> car = this.carService.findByYearGreaterThanEqual(2050);
        assertEquals(0,car.size());
    }

//    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
//    public void shouldDeleteCarById() throws Exception{
//        //this.driverService.deleteById();
//        this.carService.deleteById(2);
//    }

    @Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
    public void shouldNotDeleteCityById() throws Exception{
        this.carService.deleteById(20);
    }
}