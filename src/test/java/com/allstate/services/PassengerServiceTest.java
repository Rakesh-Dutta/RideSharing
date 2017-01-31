package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
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
public class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;

    @Before
    public void setUp() throws Exception {}
    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateNewPassenger() throws Exception {
        Passenger before = new Passenger();
        before.setName("Rakesh");
        before.setAge(24);
        before.setGender(Gender.M);
        before.setCredit(10000.00);
        Passenger after = this.passengerService.create(before);
        assertEquals("Rakesh",after.getName());
        assertEquals(24,after.getAge());
        assertEquals(5,after.getId());
    }

    @Test
    public void shouldFindById() throws Exception {
        Passenger passenger = this.passengerService.findById(1);
        assertEquals(1,passenger.getId());
        assertEquals("Parag",passenger.getName());
    }

    @Test
    public void shouldNotFindById() throws Exception {
        Passenger passenger = this.passengerService.findById(10);
        assertNull(passenger);
    }

    @Test
    public void shouldFindByName() throws Exception {
        Passenger passenger = this.passengerService.findByName("Geeta");
        assertEquals(3,passenger.getId());
        assertEquals("Geeta",passenger.getName());
    }

    @Test
    public void shouldNotFindByName() throws Exception {
        Passenger passenger = this.passengerService.findByName("Anusha");
        assertNull(passenger);
    }

    @Test
    public void shouldFindByGender() throws Exception {
        List<Passenger> passenger = this.passengerService.findByGender(Gender.F);
        assertEquals(2, passenger.size());
    }


    @Test
    public void shouldNotFindByGender() throws Exception {
        List<Passenger> passenger = this.passengerService.findByGender(Gender.M);
        assertNotEquals(4,passenger.size());
    }

    @Test
    public void shouldFindByAgeGreaterThan() throws Exception {
        List<Passenger> passenger = this.passengerService.findByAgeGreaterThanEqual(21);
        assertEquals(4, passenger.size());
    }

    @Test
    public void shouldNotFindByAgeGreaterThan() throws Exception {
        List<Passenger> passenger = this.passengerService.findByAgeGreaterThanEqual(21);
        assertNotEquals(40, passenger.size());
    }


}