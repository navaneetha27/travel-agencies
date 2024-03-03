package com.example.travelagencies.model;

import lombok.Data;

@Data
public class Activity {
    String activityName;
    int capacity;
    double cost;
    int registeredCount;
    String description;

   public Activity(String name, int capacity, double cost){
        this.activityName = name;
        this.capacity = capacity;
        this.cost = cost;
    }

    public  void updateRegisteredCount(){
       this.registeredCount++;
    }
    public  boolean isActivityCapacityReached(){
       return  this.registeredCount >= this.capacity;
    }
    public  int getAvailableFreeSeats(){
       return this.getCapacity() -this.registeredCount;
    }

    public  String toString(){
       String desc = "No Details Available";
       if(this.description != null && this.description.isEmpty()){
           desc = this.description;
       }
       return  "\n\t\t" +  this.getActivityName() + " has cost of " + this.cost + " and capable of " + this.capacity + " People  at a time.Description :" + desc;
    }

}
