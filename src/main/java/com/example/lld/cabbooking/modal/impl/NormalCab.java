package com.example.lld.cabbooking.modal.impl;

import com.example.lld.cabbooking.modal.Cab;
import com.example.lld.cabbooking.modal.Location;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
public class NormalCab implements Cab {

    private  String id;
    private String driverName;


    @NonNull
    public NormalCab(String id , String driverName){
        this.id = id;
        this.driverName = driverName;
    }
    @Setter
    private int availability;
    @Setter
    public Location currentLocation;

}
