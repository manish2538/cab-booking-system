package com.example.lld.cabbooking.manager;


import com.example.lld.cabbooking.modal.Cab;
import com.example.lld.cabbooking.modal.Location;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class CabManager {
    private CabDao cabDao;
    private CabDiscoveryStrategy cabDiscoverStrategy;

    @NonNull
    public void register(String cabId,String driverName) throws CabIdAlreadyExists{
        cabDao.add(cabId,driverName);
    }

    @NonNull
    public void updateLocation(String cabId , Location currentLocation) throws CabIdDoesNotExists{
        cabDao.update(cabId,currentLocation);
    }

    @NonNull
    public void updateCabAvailability(String cabId,int availability throws CabIdDoesNotExists){
        cabDao.update(cabId , availability);
    }
    public List<Cab> getCabs(Location currentLocation) {
        return cabDiscoveryStrategy.find(currentLocation,cabDao);
    }


}
