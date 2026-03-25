import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * * Author: Garv
 * Version: 2.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist + "\n");

        System.out.println("UC2 Add Passenger Bogies to Train");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + trainConsist);

        System.out.println("Checking if 'Sleeper' exists:");
        boolean hasSleeper = trainConsist.contains("Sleeper");
        System.out.println("Contains Sleeper?: " + hasSleeper);

        System.out.println("Final Train Passenger Consist:");
        System.out.println(trainConsist);
        System.out.println("UC2 operations completed successfully...");
    }
}