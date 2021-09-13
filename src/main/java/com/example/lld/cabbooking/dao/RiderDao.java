package com.example.lld.cabbooking.dao;


import com.example.lld.cabbooking.modal.Rider;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class RiderDao {
    HashMap<String, Rider> riderDatabase;

    public void add(String name, String emailId){
        Rider rider = new Rider(name,emailId);
        if(riderDatabase.containsKey(emailId)){
            throw new RiderWithEmailAlreadyExists();

        }
        riderDatabase.put(emailId,rider);

    }

    public Rider get(String emailId){
            if(!riderDatabase.containsKey(emailId)){
                throw new RiderNotFound();
            }
            return riderDatabase.get(emailId);

    }


}
