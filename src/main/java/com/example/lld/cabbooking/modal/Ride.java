package com.example.lld.cabbooking.modal;

import com.example.lld.cabbooking.modal.impl.RideStatus;

public interface Ride {
    String getRiderId();
    void setRideStatus(RideStatus rideStatus);
    Rider getRider();

}
