package com.example.travelagencies.model;

import lombok.Data;

import java.util.*;

@Data
public class TravelAgency {
    String agencyName;
    Map<String,Packages> packages;
    public TravelAgency(){
        packages = new HashMap<>();
    }
    public TravelAgency(String agencyName){
        this.agencyName = agencyName;
        packages = new HashMap<>();
    }
    public void  addPackages(String packageName, Packages pkgs){
        packages.put(packageName,pkgs);
    }

    public Packages createPackage(String packageName,int passengerCapacity){
        Packages tourPackage = new Packages(packageName, passengerCapacity);
        this.packages.put(packageName,tourPackage);
        return  tourPackage;

    }

    public void showPackages() {
        for(Packages packages : this.getPackages().values()){
            System.out.println(packages);
            System.out.println("-----------------------------------------");
        }
    }

    public void showPackagesWithEnrolledDetails() {
        for(Packages packages : this.getPackages().values()){
            System.out.println(packages.packageName + "has capacity of " + packages.passengerCapacity + " and currently " + packages.getPassengers().size() + " Peoples booked it  " );

            if(packages.getPassengers().size()> 0){
                System.out.println("Registered Passenger Details are:");
            }
            int counter = 0;
             for(PassengerInterface passenger : packages.getPassengers()){
                 System.out.print(counter +".");
                 passenger.ShowNameAndNumber();
                 counter++;
             }

        }
    }

    public Set<PassengerInterface> getAllPassegers() {
        Set<PassengerInterface> passengers = new HashSet<>();
        for(Packages packages : this.getPackages().values()){
            passengers.addAll(packages.getPassengers());
        }
        return passengers;
    }

    public void showAllAvailableActivities() {
        for(Packages packages : this.getPackages().values()){
            packages.getAllAvailableActivities();
        }
    }
}
