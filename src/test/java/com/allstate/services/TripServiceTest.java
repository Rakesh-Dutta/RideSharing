package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {

    @Autowired
    private TripService tripService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private CarService  carService;

    @Autowired
    private CityService cityService;


    @Before
    public void setUp() throws Exception {}
    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateNewTrip() throws Exception {
        Passenger passenger = this.passengerService.findById(1);
        Car car = this.carService.findById(1);
        City city = this.cityService.findById(1);

        Trip before = new Trip(passenger,car,city);
        before.setTripdistance(10.0);
        Trip after = this.tripService.startTrip(before);
        assertEquals(1,after.getId());
        assertEquals(128.1,after.getCost(),0.1);
    }

    @Test
    public void shouldNotCreateNewTrip() throws Exception {
        Passenger passenger = this.passengerService.findById(1);
        Car car = this.carService.findById(1);
        City city = this.cityService.findById(1);

        Trip before = new Trip(passenger,car,city);
        before.setTripdistance(100000.00);
        Trip after = this.tripService.startTrip(before);
        assertNull(after);
    }

    @Test
    public void shouldEndTrip() throws Exception {
        Trip before = this.tripService.findById(1);
        before.setFeedbacktodriver("Good");
        before.setFeedbacktopassenger("Very Good");
        before.setRatingtodriver(4);
        before.setRatingtopassenger(5);
        before.setTip(10);
        Trip after = this.tripService.endTrip(before);
        assertEquals(140.91,after.getTotalcost(),0.1);
    }

}