package com.example.lld.cabbooking.handlers.impl;

import com.example.lld.cabbooking.exceptions.InvalidDetailsException;
import com.example.lld.cabbooking.exceptions.RiderFunctionalityNotFound;
import com.example.lld.cabbooking.handlers.RiderHandler;
import com.example.lld.cabbooking.modal.Ride;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RiderHandlerConsole implements RiderHandler {
    private RiderManager riderManager;
    private RideManager rideManager;
    private Scanner takeInput = new Scanner(System.in);

    @NonNull
    public RiderHandlerConsole(RiderManager riderManager , RideManager rideManager){
        this.riderManager = riderManager;
        this.rideManager = rideManager;

    }
    private HashMap<String,Runnable> functionToExecute = new HashMap<String,Runnable>(){
        {
            put("REGISTER",RiderHandlerConsole.this::register);
            put("BOOK_CAB",RiderHandlerConsole.this::bookCab);
            put("FETCH_RIDE_HISTORY",RiderHandlerConsole.this::fetchRideHistory);
            put("RIDE_CAB",RiderHandlerConsole.this::rideCab);
            put("END_TRIP",RiderHandlerConsole.this::endTrip);

        }
    };


    @Override
    public void takeInput() throws RiderFunctionalityNotFound{
    String riderFunction = takeInput.nextLine();
    if(!functionToExecute.containsKey(riderFunction)){
        throw new RiderFunctionalityNotFound();
    }
    functionToExecute.get(riderFunction).run();
    }

    @Override
    public void register() throws InvalidDetailsException {
//        String riderId = takeInput.nextLine();
        String riderName = takeInput.nextLine();
        String riderEmailName = takeInput.nextLine(); //Add valid Email checking Functionality
        if(riderName.isEmpty() || riderEmailName.isEmpty()){
            throw new InvalidDetailsException();
        }
        riderManager.register(riderName,riderEmailName);

    }

    @Override
    public String bookCab() {
        String riderEmailId = takeInput.nextLine();
        int sourceX = Integer.valueOf(takeInput.next()),sourceY = Integer.valueOf(takeInput.next());
        int destX = Integer.valueOf(takeInput.next()),destY = Integer.valueOf(takeInput.next());
        String bookedCabRideId = rideManager.bookCab(riderEmailId,sourceX,sourceY,destX,destY);
        return  bookedCabRideId;

    }

    @Override
    public void rideCab() {

    }

    @Override
    public List<Ride> fetchRideHistory() {
        return null;
    }

    @Override
    public void endTrip() {

    }
}
