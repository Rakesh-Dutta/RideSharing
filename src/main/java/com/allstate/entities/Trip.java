package com.allstate.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "trips")
public class Trip {
    private int id;
    private int version;
    private Date starttime;
    private Date stoptime;
    private double duration;
    private Car car;
    private Passenger passenger;
    private int tripdistance;
    private double cost;
    private int tip;
    private double totalcost;
    private int ratingtodriver;
    private int ratingtopassenger;
    private String feedbacktodriver;
    private String feedbacktopassenger;
    private Date created;
    private Date modified;

}






