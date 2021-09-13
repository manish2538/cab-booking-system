package com.example.lld.cabbooking.manager;

import com.example.lld.cabbooking.dao.CabDao;
import com.example.lld.cabbooking.dao.RideDao;
import com.example.lld.cabbooking.dao.RiderDao;
import com.example.lld.cabbooking.modal.Cab;
import com.example.lld.cabbooking.modal.Location;
import com.example.lld.cabbooking.modal.Ride;
import com.example.lld.cabbooking.modal.Rider;
import com.example.lld.cabbooking.modal.impl.NonSharingRide;
import com.example.lld.cabbooking.modal.impl.NormalCab;
import com.example.lld.cabbooking.modal.impl.RideStatus;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class RideManager {
    private CabDao cabDao;
    private  CabDiscoveryStrategy cabDiscoveryStrategy;
    private RiderDao riderDao;
    private RideDao rideDao;

    @NonNull

    public String bookCab(String riderEmailId , int sourceX , int sourceY , int destX , int destY){
        Rider rider = riderDao.get(riderEmailId);
        Location source = new Location(sourceX,sourceY);
        Location dest = new Location(destX,destY);
        CabMatchingStrategy cabMatchingStrategy = new DefaultCabMatchingStrategy(cabDao,cabDiscoveryStrategy,source,dest);
        Cab cab = (NormalCab) cabMatchingStrategy.matchCab();
        PriceMatchingStrategy priceMatchingStrategy = new DefaultPriceMatchingStrategy(cabMatchingStrategy,source,dest);
        Double price = priceMatchingStrategy.calculatePrice();
        String rideId = UUID.randomUUID().toString();
        Ride ride  = new NonSharingRide(rideId,rider,cab,price,RideStatus.SCHEDULED,source,dest);
        rideDao.add(ride);
        return rideId;

    }

    @NonNull
    public void rideCab(String rideId){
        rideDao.setRideStatus(rideId,RideStatus.IN_PROGRESS);
    }
    @NonNull public  void endRide(String rideId){
        rideDao.setRideStatus(rideId, RideStatus.FINISHED);

    }

    @NonNull
    public List<Ride> getRidesForRider(String riderId){
        return rideDao.getRidesForRider(riderId);
    }


}
