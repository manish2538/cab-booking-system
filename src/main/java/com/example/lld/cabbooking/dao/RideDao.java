package com.example.lld.cabbooking.dao;


import com.example.lld.cabbooking.modal.Ride;
import com.example.lld.cabbooking.modal.impl.RideStatus;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RideDao {
    HashMap<String, Ride> rideDatabase;

    public void add(Ride ride){
        String rideId = ride.getRiderId();
        if(rideDatabase.containsKey(rideId)){
            throw new RideAlreadyExists();
        }
        rideDatabase.put(rideId,ride);
    }
    public void setRideStatus(String rideId, RideStatus rideStatus){
    if(!rideDatabase.containsKey(rideId)){
        throw new RideDoesNotExists();
    }
    Ride ride = rideDatabase.get(rideId);
    ride.setRideStatus(rideStatus);
    rideDatabase.remove(rideId);
    rideDatabase.put(rideId,ride);
    }

    public List<Ride> getRidesForRider(String riderId){
        List<Ride> allRides = rideDatabase.keySet().stream().map(rideId -> rideDatabase.get(rideId)).collect(Collectors.toList());
        List<Ride> ridesOfRider = allRides.stream().filter(ride ->ride.getRider().getEmailId()==riderId).collect(Collectors.toList());
        return ridesOfRider;
    }
}
