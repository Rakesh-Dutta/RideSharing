package com.allstate.services;

import com.allstate.entities.Driver;
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
public class DriverServiceTest {
    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {}
    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateNewPassenger() throws Exception {
        Driver before = new Driver();
        before.setName("rk");
        before.setAge(24);
        before.setGender(Gender.M);
        before.setViolation(3);
        before.setEligible(false);

        Driver after = this.driverService.create(before);
        assertEquals("rk",after.getName());
        assertEquals(24,after.getAge());
        assertEquals(4,after.getId());
        assertEquals(false,after.isEligible());
    }

    @Test
    public void shouldFindById() throws Exception {
        Driver driver = this.driverService.findById(1);
        assertEquals(1,driver.getId());
        assertEquals("Tiru",driver.getName());
    }

    @Test
    public void shouldNotFindById() throws Exception {
        Driver driver = this.driverService.findById(5);
       assertNull(driver);
    }

    @Test
    public void shouldFindByName() throws Exception {
        Driver driver = this.driverService.findByName("DD");
        assertEquals(3,driver.getId());
        assertEquals("DD",driver.getName());
    }

    @Test
    public void shouldNotFindByName() throws Exception {
        Driver driver = this.driverService.findByName("PK");
        assertNull(driver);
    }

    @Test
    public void shouldFindByGender() throws Exception {
        List<Driver> driver = this.driverService.findByGender(Gender.M);
        assertEquals(3,driver.size());
    }

    @Test
    public void shouldDeleteDriverById() throws Exception{
        this.driverService.deleteById(2);
        Driver driver = this.driverService.findById(2);
        assertNull(driver);
    }

    @Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
    public void shouldNotDeleteDriverById() throws Exception{
        this.driverService.deleteById(20);
    }

    @Test
    public void addVoliation() throws Exception{
        Driver driver = this.driverService.findById(3);
        Driver after = this.driverService.addVoliation(driver);
        assertEquals(3,after.getViolation());
        assertEquals(false,after.isEligible());
    }

}