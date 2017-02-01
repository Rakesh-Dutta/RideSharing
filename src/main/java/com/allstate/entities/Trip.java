package com.allstate.entities;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    private int id;
    private int version;
    private Date starttime;
    private Date stoptime;
    private double duration;
    private Car car;
    private Passenger passenger;
    private City city;
    private double tripdistance;
    private double cost;
    private int tip;
    private double totalcost;
    private int ratingtodriver;
    private int ratingtopassenger;
    private String feedbacktodriver;
    private String feedbacktopassenger;
    private Date created;
    private Date modified;

    public Trip(){

    }

    public Trip(Passenger passenger,Car car, City city){
        this.passenger = passenger;
        this.car = car;
        this.city = city;
    }

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @CreationTimestamp
    public Date getStarttime() {return starttime;}
    public void setStarttime(Date starttime) {this.starttime = starttime;}

    @UpdateTimestamp
    public Date getStoptime() {return stoptime;}
    public void setStoptime(Date stoptime) {this.stoptime = stoptime;}

    @NotNull
    public double getDuration() {return duration;}
    public void setDuration(double duration) {this.duration = duration;}

    @ManyToOne
    @JoinColumn(name="car_id")
    public Car getCar() {return car;}
    public void setCar(Car car) {this.car = car;}

    @ManyToOne
    @JoinColumn(name="passenger_id")
    public Passenger getPassenger() {return passenger;}
    public void setPassenger(Passenger passenger) {this.passenger = passenger;}

    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {return city;}
    public void setCity(City city) {this.city = city;}

    @NotNull
    public double getTripdistance() {return tripdistance;}
    public void setTripdistance(double tripdistance) {this.tripdistance = tripdistance;}

    @NotNull
    public double getCost() {return cost;}
    public void setCost(double cost) {this.cost = cost;}


    public int getTip() {return tip;}
    public void setTip(int tip) {this.tip = tip;}

    @NotNull
    public double getTotalcost() {return totalcost;}
    public void setTotalcost(double totalcost) {this.totalcost = totalcost;}

    @NotNull
    public int getRatingtodriver() {return ratingtodriver;}
    public void setRatingtodriver(int ratingtodriver) {this.ratingtodriver = ratingtodriver;}

    @NotNull
    public int getRatingtopassenger() {return ratingtopassenger;}
    public void setRatingtopassenger(int ratingtopassenger) {this.ratingtopassenger = ratingtopassenger;}


    public String getFeedbacktodriver() {return feedbacktodriver;}
    public void setFeedbacktodriver(String feedbacktodriver) {this.feedbacktodriver = feedbacktodriver;}

    public String getFeedbacktopassenger() {return feedbacktopassenger;}
    public void setFeedbacktopassenger(String feedbacktopassenger) {this.feedbacktopassenger = feedbacktopassenger;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
}






