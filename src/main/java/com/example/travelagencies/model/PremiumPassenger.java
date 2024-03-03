package com.example.travelagencies.model;
import java.util.List;

import lombok.Data;

@Data
public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, 0); // Premium Passenger has free activities
    }

    public void signUpForActivity(Activity activity,String destination) {
        super.signUpForActivity(activity, getDiscount(), destination); // No cost for Premium Passenger
    }

    @Override
    public String displayPassengerActivitiyDetails() {
        String passengerActivities ="";
        for(String destination : this.getSignedUpActivities().keySet()){
            List<Activity> activityList = this.getSignedUpActivities().get(destination);
            for(Activity activity : activityList){
                passengerActivities  = passengerActivities +" "+ activity.activityName + " taking place at " +  destination + " and paid ";
                double amountPaid = 0;
                passengerActivities += amountPaid;
            }

        }
        return  passengerActivities + "\n";
    }

    @Override
    public double getDiscount() {
        return 0.0;
    }
}