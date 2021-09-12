package com.example.lld.cabbooking.modal.impl;


import com.example.lld.cabbooking.modal.Cab;
import com.example.lld.cabbooking.modal.Location;
import com.example.lld.cabbooking.modal.Ride;
import com.example.lld.cabbooking.modal.Rider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class NonSharingRide implements Ride {
    private String rideId;
    private Rider rider;
    private Cab cab;
    private Double price;
    @Setter
    private RideStatus rideStatus;
    private Location fromPoint;




}
