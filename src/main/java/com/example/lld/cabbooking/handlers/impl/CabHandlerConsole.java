package com.example.lld.cabbooking.handlers.impl;

import com.example.lld.cabbooking.exceptions.CabFunctionalityNotFound;
import com.example.lld.cabbooking.handlers.CabHandler;
import com.example.lld.cabbooking.modal.Cab;
import com.example.lld.cabbooking.modal.Location;

import java.util.*;

public class CabHandlerConsole implements CabHandler {
    private CabManager cabManager;
    public CabHandlerConsole(CabManager cabManager){
        this.cabManager = cabManager;
    }
    private Scanner takeinput = new Scanner(System.in);



private HashMap<String,Runnable> functionToExecute = new HashMap<String,Runnable>(){
    {
        put("REGISTER",CabHandlerConsole.this::register);
        put("UPDATE_LOCATION",CabHandlerConsole.this::updateLocation);
        put("UPDATE_CAB_AVAILABILTY",CabHandlerConsole.this::updateCabAvailability);
        put("GET_CABS",CabHandlerConsole.this::getCabs);

    }
};
    @Override
    public void getCabFunctionalityInput() throws CabFunctionalityNotFound {


        String cabFunction = takeinput.nextLine();

        if(!functionToExecute.containsKey(cabFunction)){
            throw new CabFunctionalityNotFound();
        }
        functionToExecute.get(cabFunction).run(); //if user entered a wrong key then handle it,throws Exceptions

    }

    @Override
    public void register()  {
    String cabId = takeinput.nextLine();
    String driverName = takeinput.nextLine();
    cabManager.register(cabId,driverName);
    }

    @Override
    public void updateLocation()  {
        String cabId = takeinput.nextLine();
        int X = Integer.valueOf(takeinput.next());
        int Y = Integer.valueOf(takeinput.next());
        cabManager.updateLocation(cabId,new Location(X,Y));

    }

    @Override
    public void updateCabAvailability()  {
        String cabId = takeinput.nextLine();
        Integer availabiltiy = Integer.valueOf(takeinput.next());
        HashSet<Integer> availabiltyStatus = new HashSet<>(Arrays.asList(0,1));
        if(availabiltyStatus.contains(availabiltiy)){
            cabManager.updateCabAvailability(cabId , availabiltiy);
        }
        else{
            throw new RuntimeException("Not a valid availabilty State");
        }

    }

    @Override
    public List<Cab> getCabs() {

        int X = Integer.valueOf(takeinput.next());
        int Y = Integer.valueOf(takeinput.next());

        return cabManager.getCabs(new Location(X,y));
    }
}
