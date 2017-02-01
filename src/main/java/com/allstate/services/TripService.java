package com.allstate.services;

import com.allstate.entities.Trip;
import com.allstate.enums.Type;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static javax.xml.bind.DatatypeConverter.parseDate;

@Service
public class TripService {
    private ITripRepository tripRepository;

    private Date date;
    private Date dateCompareOne;
    private Date dateCompareTwo;
    private String compareStringOne = "10:00";
    private String compareStringTwo = "06:00";

    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip startTrip(Trip trip) throws ParseException {
        double passengerCredit = trip.getPassenger().getCredit();
        double distance = trip.getTripdistance();
        int violation = trip.getCar().getDriver().getViolation();
        double cost = 0.0;
        double luxCharges = 0.0;
        Type type = trip.getCar().getType();

        if(type.equals(Type.LUX)){
            luxCharges = 5;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a");
        Date startTime = dateFormat.parse("22:00 PM");
        Date endTime = dateFormat.parse("06:00 AM");

        Date CurrentTime = dateFormat.parse(dateFormat.format(new Date()));

        if (CurrentTime.after(startTime) || CurrentTime.before(endTime))
        {
            cost = distance * trip.getCity().getNight_rate();
            cost = cost *((100+luxCharges)/100);
        }
        else
        {
            cost = distance * trip.getCity().getDay_rate();
            cost = cost *((100+luxCharges)/100);
        }

        if(trip.getCar().getDriver().getViolation() <= 3 && trip.getPassenger().getCredit() >= cost){

            trip.setCost(cost);

            return this.tripRepository.save(trip);
        }
        return  null;
    }

    public Trip endTrip(Trip trip){
        trip.setTotalcost(trip.getCost() + (trip.getCost()*trip.getTip()/100));
        return this.tripRepository.save(trip);
    }

    public Trip findById(int id){
        return this.tripRepository.findOne(id);
    }
}