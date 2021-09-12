package com.example.lld.cabbooking.handlers;

import com.example.lld.cabbooking.modal.Ride;

import java.util.List;

public interface RiderHandler {
    void takeInput();
    void register();
    String bookCab();
    void rideCab();
    List<Ride> fetchRideHistory();
    void endTrip(); //assuming that rider would be the one who end the trip


}
