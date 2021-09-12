package com.example.lld.cabbooking.handlers;

import com.example.lld.cabbooking.modal.Cab;

import java.io.IOException;
import java.util.List;

public interface CabHandler {
    void getCabFunctionalityInput();
    void register() throws Exception;
    void updateLocation() throws  Exception;
    void updateCabAvailability() throws  Exception;
    List<Cab> getCabs() throws  Exception; //for Cab Modals - objects for the entities

}
