package com.example.travelagencies.model;

import lombok.Data;

import java.util.List;

@Data
public class GoldPassenger extends Passenger {
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }


    public void signUpForActivity(Activity activity,String destination) {
        super.signUpForActivity(activity, getDiscount(), destination); // Apply 10% discount for Gold Passenger
    }

    @Override
    public String displayPassengerActivitiyDetails() {
        String passengerActivities = "Remaining Balance:" + this.getBalance();
        for(String destination : this.getSignedUpActivities().keySet()){
            List<Activity> activityList = this.getSignedUpActivities().get(destination);
            for(Activity activity : activityList){
                passengerActivities  = passengerActivities+" " + activity.activityName + " taking place at " +  destination + " and paid ";
                double amountPaid = 0;
                amountPaid = getDiscountedCost(activity.getCost(),getDiscount());

                passengerActivities += amountPaid;
            }

        }
        return  passengerActivities + "\n";
    }

    @Override
    public double getDiscount() {
        return 0.1;
    }
}
