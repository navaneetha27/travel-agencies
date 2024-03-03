package com.example.travelagencies.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public abstract class Passenger implements  PassengerInterface {

    String name;
    int passengerNum;


    double balance;
    private Map<String,List<Activity>> signedUpActivities;

    private List<String> packagesChosen;
    public Passenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNum = passengerNumber;
        this.balance = balance;
        this.signedUpActivities = new HashMap<>();
        this.packagesChosen = new ArrayList<>();
    }

    @Override
    public int hashCode(){
        return  this.passengerNum;
    }
    @Override
    public boolean equals(Object ob){

        if( ob instanceof Passenger)
            return  this.passengerNum == ((Passenger) ob).passengerNum;

            return false;
    }

    public void addPackagesChosen(String packages){
        packagesChosen.add(packages);
    }
    public void addSignedUpActivities(String Destination ,Activity activity){
        List<Activity> activities = this.signedUpActivities.get(Destination);
        if(activities == null){
            activities = new ArrayList<>();
        }
        activities.add(activity);
        this.signedUpActivities.put(Destination,activities);
    }
    public void signUpForActivity(Activity activity, double discount,String destination) {
        if (signedUpActivities.getOrDefault(destination,new ArrayList<>()).contains(activity)) {
            System.out.println(name + " is already signed up for this activity.");
            return;
        }

        if (activity.getCapacity() > 0 && !activity.isActivityCapacityReached()) {
            double discountedCost =  getDiscountedCost(activity.getCost(),discount);
            if (balance >= discountedCost || this instanceof PremiumPassenger) {
                this.addSignedUpActivities(destination, activity);
                activity.updateRegisteredCount();
                if (!(this instanceof PremiumPassenger)) {
                    balance -= discountedCost;
                    System.out.println(name + " signed up for " + activity.getActivityName() + " at price " + discountedCost);
                } else {
                    System.out.println(name + " signed up for " + activity.getActivityName() + " for free (Premium Passenger)");
                }
            } else {
                System.out.println("Insufficient balance for " + name + " to sign up for " + activity.getActivityName());
            }
        } else {
            System.out.println("Activity " + activity.getActivityName() + " is already at full capacity.");
        }
    }

    protected double getDiscountedCost(double cost, double discount) {
        return  cost - (cost * discount);
    }

//    @Override
//    public String toString() {
//        StringBuilder activitiesInfo = new StringBuilder();
//        for (String activityName : signedUpActivities.values()) {
//            Activity activity = this.
//            activitiesInfo.append("Activity: ").append(activity.getCapacity()).append(" at Destination: ").append(activity);
//            if (!(this instanceof PremiumPassenger)) {
//                activitiesInfo.append(" - Cost: $").append(activity.getCost());
//            }
//            activitiesInfo.append("\n");
//        }
//        return "Passenger: " + name + "\nPassenger Number: " + passengerNum + "\nBalance: $" + balance + "\nSigned Up Activities:\n" + activitiesInfo;
//    }

    @Override
    public void ShowNameAndNumber(){
        System.out.println(this.name  + "\t" + this.passengerNum);
    }


}
