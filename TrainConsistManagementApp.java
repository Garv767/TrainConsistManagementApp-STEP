import java.util.ArrayList;
import java.util.Comparator; // Required for UC7
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * UC1 - UC6: (Previously Implemented)
 * UC7: Sort Bogies by Capacity (Comparator)
 * Author: Garv
 * Version: 7.0
 */

// UC7: Bogie class to represent a bogie with name and capacity
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

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
        Map<String, Integer> bogieCapacities = new HashMap<>();
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("\nUC6 bogie-capacity mapping completed successfully...\n");

        //UC7: SORT BOGIES BY CAPACITY
        System.out.println("UC7 Sort Bogies by Capacity (Comparator)");

        // Step 1: Create a List to store Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // Step 2: Add bogies with capacities to the list
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        // Step 3: Display bogies before sorting
        System.out.println("Before Sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Step 4: Use Comparator to sort bogies based on capacity
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        // Step 5: Display the sorted list of bogies
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}
