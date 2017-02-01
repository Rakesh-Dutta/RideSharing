package com.allstate.entities;


import com.allstate.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cars")
@Data
public class Car {

    private int id;
    private int version;
    private String model;
    private String make;
    private int year;
    private Type type;
    private Date created;
    private Date modified;
    private Driver driver;


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(columnDefinition = "ENUM('BASIC', 'LUX')")
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "cars_drivers",
//            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
//    @JsonIgnore
    //public List<Driver> getDriver() {
//        return driver;
//    }


   // public void setDriver(List<Driver> driver) {
       // this.driver = driver;
    //}

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
