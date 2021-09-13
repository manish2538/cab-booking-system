package com.example.lld.cabbooking.dao;

import com.example.lld.cabbooking.modal.Cab;
import com.example.lld.cabbooking.modal.Location;
import com.example.lld.cabbooking.modal.impl.NormalCab;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class CabDao {
    HashMap<String , Cab> cabDataBase;

    public void add(String cabId , String driverName){
        Cab newCab = new NormalCab(cabId,driverName);
        if(cabDataBase.containsKey(cabId)){
            throw new CabIdAlreadyExists();
        }
        cabDataBase.put(cabId,newCab);

    }
    public void update(String cabId , Location currentLocation){
        if(!cabDataBase.containsKey(cabId)){
            throw new CabIdDoesNotExist();
        }
        NormalCab cab  = (NormalCab) cabDataBase.get(cabId);
        cab.setCurrentLocation(currentLocation);
        cabDataBase.put(cabId,cab);

    }
    public void update(String cabId , int availability){
        if(!cabDataBase.containsKey(cabId)){
            throw new CabIdDoesNotExist();
        }
        NormalCab cab  = (NormalCab) cabDataBase.get(cabId);
        cab.setAvailability(availability);
        cabDataBase.put(cabId,cab);

    }
    public List<Cab> getAll(){
    List<Cab> allCabs = new ArrayList<>(cabDataBase.values());
    return allCabs;

    }
}
