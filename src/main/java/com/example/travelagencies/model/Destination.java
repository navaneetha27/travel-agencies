package com.example.travelagencies.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Destination {
    String destination;
    Map<String,Activity> activities;

    public Destination(String destination){
        this.destination = destination;
        this.activities = new HashMap<>();
    }
    public Destination(){
        this.activities = new HashMap<>();
    }

    public void  addActivity(Activity activity){
        this.activities.put(activity.activityName,activity);
    }

    public  String toString(){

        String value = "";

        for(Activity activity : this.activities.values()){
            value += activity;
        }
        return  value;
    }

    public void getAllAvailableActivities() {
        for(Activity activity : this.activities.values()){
            if(!activity.isActivityCapacityReached()){
                System.out.println(activity.activityName + " has " + activity.getAvailableFreeSeats() + " free seats" );
            }
        }
    }

}
