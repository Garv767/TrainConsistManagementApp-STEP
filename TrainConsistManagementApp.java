import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * UC1 - UC4: (Previously Implemented)
 * UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
 * Author: Garv
 * Version: 5.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        //UC1: INITIALIZATION
        System.out.println("Train Consist Management App");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size() + "\n");

        //UC2: PASSENGER BOGIE OPERATIONS
        System.out.println("UC2 Add Passenger Bogies to Train");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");
        System.out.println("Passenger Bogies: " + trainConsist + "\n");

        //UC3: UNIQUE BOGIE ID TRACKING
        System.out.println("UC3 Track Unique Bogie IDs");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        System.out.println("Bogie IDs (Unique): " + bogieIds + "\n");

        //UC4: ORDERED BOGIE CONSIST
        System.out.println("UC4 Maintain Ordered Bogie Consist");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        orderedConsist.add(2, "Pantry Car");
        orderedConsist.removeFirst();
        orderedConsist.removeLast();
        System.out.println("Ordered Consist: " + orderedConsist + "\n");

        //UC5: PRESERVE INSERTION ORDER WITH UNIQUENESS
        System.out.println("UC5 Preserve Insertion Order of Bogies");

        // Step 1: Initialize LinkedHashSet for ordered uniqueness
        // This ensures the train formation follows attachment order without duplicates
        Set<String> formation = new LinkedHashSet<>();

        // Step 2: Attach bogies in a specific sequence
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Step 3: Attempt to attach a duplicate bogie
        // The system will ignore this to prevent invalid duplicate attachments
        formation.add("Sleeper");

        // Step 4: Display the final formation
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote: LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("UC5 formation setup completed...");
    }
}