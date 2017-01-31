package com.allstate.services;

import com.allstate.entities.City;
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
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() throws Exception{
        City before = new City();
        before.setName("Banglore");
        before.setState("Ka");
        before.setDay_rate(10.00);
        before.setNight_rate(15.00);
        City after = this.cityService.create(before);

        assertEquals("Banglore",after.getName());

    }

    @Test
    public void shouldFindCityById() throws Exception{
        City city = this.cityService.findById(2);
        assertEquals("Mumbai",city.getName());
    }

    @Test
    public void shouldNotFindCityById() throws Exception{
        City city = this.cityService.findById(20);
        assertNull(city);
    }

    @Test
    public void shouldFindCityByName() throws Exception{
        City city = this.cityService.findByName("Delhi");
        assertEquals("Delhi",city.getName());
        assertEquals(1,city.getId());
    }

    @Test
    public void shouldNotFindCityByName() throws Exception{
        City city = this.cityService.findByName("Hydrabad");
        assertNull(city);
    }


    @Test
    public void shouldDeleteCityById() throws Exception{
        this.cityService.deleteById(2);
        City city = this.cityService.findById(2);
        assertNull(city);
    }


    @Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
    public void shouldNotDeleteCityById() throws Exception{
        this.cityService.deleteById(20);
    }




}