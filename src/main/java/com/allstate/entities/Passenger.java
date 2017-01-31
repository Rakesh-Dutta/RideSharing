package com.allstate.entities;


import com.allstate.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "passengers")
@Data
public class Passenger {
    private int id;
    private int version;
    private String name;
    private Gender gender;
    private int age;
    private Date created;
    private Date modified;
    private double credit;



    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @Size(min = 1)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    @NotNull
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @NotNull
    public double getCredit() {return credit;}
    public void setCredit(double credit) {this.credit = credit;}

    @Column(columnDefinition = "ENUM('M', 'F')")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}
}



