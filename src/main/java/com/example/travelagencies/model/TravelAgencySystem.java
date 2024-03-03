package com.example.travelagencies.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TravelAgencySystem {
    Map<String,TravelAgency> travelAgencyList;
    public TravelAgencySystem(){
        travelAgencyList = new HashMap<>();
        initialize();


    }

    private void initialize() {
        TravelAgency agency = new TravelAgency("AB tourist");
        Packages package1 = agency.createPackage("thailand package",30);
        Destination destination = package1.addDestination("Thailand");
        destination.addActivity( new Activity("human football", 12, 300));
        destination.addActivity( new Activity("football", 12, 300));
        destination.addActivity( new Activity("cricket", 11, 400));
        package1.addIternities(destination);
        Packages package2 = agency.createPackage("Goa package",30);
        Destination destination2 = package1.addDestination("Goa");
        destination2.addActivity( new Activity("surfing", 12, 300));
        destination2.addActivity( new Activity("beach volleyball", 12, 300));
        destination2.addActivity( new Activity("concert", 11, 400));
        package2.addIternities(destination2);
        this.addTravelAgency(agency);
    }

    public  void addTravelAgency(TravelAgency agency){
        travelAgencyList.put(agency.agencyName,agency);
    }



}
