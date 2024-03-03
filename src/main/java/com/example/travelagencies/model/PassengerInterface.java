package com.example.travelagencies.model;

import java.util.List;
import java.util.Map;

public interface PassengerInterface {

    void signUpForActivity(Activity activity,String Destination);

    void addPackagesChosen(String packages1);
    String toString();
    int hashCode();

    void ShowNameAndNumber();
    String getName();
    int getPassengerNum();
    double getBalance();
    Map<String, List<Activity>> getSignedUpActivities();
    List<String> getPackagesChosen();

    String displayPassengerActivitiyDetails();

    double getDiscount();
}
