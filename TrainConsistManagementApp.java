import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * * Author: Garv
 * Version: 3.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        //UC1: INITIALIZATION
        System.out.println("Train Consist Management App");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist + "\n");

        //UC2: PASSENGER BOGIE OPERATIONS
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
        System.out.println("UC2 operations completed successfully...\n");

        //UC3: UNIQUE BOGIE ID TRACKING
        System.out.println("UC3 Track Unique Bogie IDs");

        // Step 1: Create a Set to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Step 2: Adding bogie IDs including duplicates
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");

        // Intentional duplicate entries to test deduplication
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        // Step 3: Display results
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);
        
        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed successfully...");
    }
}