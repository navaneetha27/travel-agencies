package com.example.travelagencies;

import com.example.travelagencies.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class TravelAgenciesApplication  {

	public static void main(String[] args) {
		TravelAgencySystem travelAgencySystem = new TravelAgencySystem();
		PassengerInterface goldPassenger = new GoldPassenger("Name", 1, 1000);
		PassengerInterface premPassenger = new PremiumPassenger("premium",3);
		PassengerInterface standardPassenger = new StandardPassenger("standard",2,3000);
		for(TravelAgency agency  : travelAgencySystem.getTravelAgencyList().values()){
			System.out.println("Agency Name:" + agency.getAgencyName()  + "Packages");
			agency.showPackages();
			agency.showPackagesWithEnrolledDetails();
		}
//		sampleRegistration(travelAgencySystem,goldPassenger);
		Set<PassengerInterface> passengerSet = new HashSet<>();
		for (TravelAgency agency: travelAgencySystem.getTravelAgencyList().values()){
			passengerSet.addAll(agency.getAllPassegers());
		}

		for(PassengerInterface passenger : passengerSet){
			System.out.print("Activities registered By passenger :");
			passenger.getPassengerNum();

			System.out.println(passenger.displayPassengerActivitiyDetails());
		}

		for(TravelAgency agency : travelAgencySystem.getTravelAgencyList().values()){
			agency.showAllAvailableActivities();
		}
	}

	public static void sampleRegistration(TravelAgencySystem travelAgencySystem, PassengerInterface passenger){
		List<String>  agencies = travelAgencySystem.getTravelAgencyList().keySet().stream().toList();
		Map<String,Packages> packages =  travelAgencySystem.getTravelAgencyList().get(agencies.get(0)).getPackages();
		List<String> packageNames = packages.keySet().stream().toList();
		Packages packages1 = packages.get(packageNames.get(0));
		passenger.addPackagesChosen(packages1.getPackageName());
		packages1.addPassenger(passenger);
		List<String> dest = packages1.getDestinations().keySet().stream().toList();
		Destination destination = packages1.getDestinations().get(dest.get(0));
		Activity activity = destination.getActivities().get( destination.getActivities().keySet().stream().toList().get(0));
		passenger.signUpForActivity(activity,destination.getDestination());
		System.out.println(passenger);
	}

}
