package com.example.travelagencies.model;

import lombok.Data;

import java.util.*;

@Data
public class Packages {
    String packageName;
    int passengerCapacity;
    Map<String, Destination> destinations;
    Set<PassengerInterface> passengers;

    public  Packages(){
        destinations = new HashMap<>();
        passengers = new HashSet<>();
    }
    public  Packages(String packageName, int passengerCapacity){
        this.packageName = packageName;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new HashSet<>(this.passengerCapacity);
        this.destinations = new HashMap<>();
    }


    public  void addIternities(Destination destination){
        this.destinations.put(destination.getDestination(), destination);
    }

    public  boolean addPassenger(PassengerInterface passenger){
        if(passengers.contains(passenger)){
            System.out.println("Already choosen this package");
            return true;
        }
        if(!this.isPassengerEnrollable()){
            System.out.println("Sorry, There is no more seats available for this package");
            return  false;
        }
        this.passengers.add(passenger);
    return true;
    }

    public  int getRegisteredPassengerCount(){
        return this.passengers.size();
    }

    public boolean isPassengerEnrollable(){
        return  getRegisteredPassengerCount() < getPassengerCapacity();
    }

    public  Destination addDestination(String destiny){
        return new Destination(destiny);
    }

    @Override
    public String toString(){
       String packages = "\t";

       for(Destination destination : this.destinations.values()){
           packages = packages  + this.packageName + " has capacity of " + this.passengerCapacity + " with destination: " + destination.getDestination() + " has Activities:" + destination;
       }
       return packages;
    }

    public void getAllAvailableActivities() {
        for(Destination destination : this.getDestinations().values()){
            destination.getAllAvailableActivities();
        }
    }
}
