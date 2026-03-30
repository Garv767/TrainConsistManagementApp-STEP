import java.util.ArrayList;
import java.util.HashMap; // Required for UC6
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;     // Required for UC6
import java.util.Set;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * UC1 - UC5: (Previously Implemented)
 * UC6: Map Bogie to Capacity (HashMap)
 * Author: Garv
 * Version: 6.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        // --- UC1: INITIALIZATION
        System.out.println("Train Consist Management App");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...\n");

        //UC2: PASSENGER BOGIE OPERATIONS
        System.out.println("UC2 Add Passenger Bogies to Train");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");
        System.out.println("Passenger Bogies: " + trainConsist + "\n");

        // UC3: UNIQUE BOGIE ID TRACKING
        System.out.println("UC3 Track Unique Bogie IDs");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        System.out.println("Bogie IDs (Unique): " + bogieIds + "\n");

        //UC4: ORDERED BOGIE CONSIST
        System.out.println("UC4 Maintain Ordered Bogie Consist");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("Cargo");
        orderedConsist.add(1, "Pantry Car");
        System.out.println("Ordered Consist: " + orderedConsist + "\n");

        //UC5: PRESERVE INSERTION ORDER WITH UNIQUENESS
        System.out.println("UC5 Preserve Insertion Order of Bogies");
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        System.out.println("Final Train Formation: " + formation + "\n");

        //UC6: MAP BOGIE TO CAPACITY
        System.out.println("UC6 Map Bogie to Capacity (HashMap)");

        // Step 1: Create a HashMap to store bogie-capacity mapping
        // Key (String): Bogie Name, Value (Integer): Capacity
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // Step 2: Associate bogies with their capacities using put()
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);

        // Step 3: Iterate through the map and display details
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed successfully...");
    }
}