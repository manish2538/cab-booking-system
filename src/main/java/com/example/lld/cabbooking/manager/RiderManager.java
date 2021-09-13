package com.example.lld.cabbooking.manager;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class RiderManager {
    private RiderDao riderDao;
    private CabDao cabdao;

    @NonNull
    public void register(String riderName , String riderEmailId){
        riderDao.add(riderName,riderEmailId);
    }
}
