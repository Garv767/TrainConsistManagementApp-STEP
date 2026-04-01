import java.util.ArrayList;
import java.util.Comparator; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * UC1 - UC7: (Previously Implemented)
 * UC8: Filter Passenger Bogies Using Streams
 * Author: Garv
 * Version: 8.0
 */

// Bogie class to represent a bogie with name and capacity
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
        
        //UC1: INITIALIZATION
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
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        passengerBogies.forEach(System.out::println);

        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        passengerBogies.forEach(System.out::println);
        System.out.println("\nUC7 sorting completed...\n");

        //UC8: FILTER PASSENGER BOGIES USING STREAMS
        System.out.println("UC8 Filter Passenger Bogies Using Streams");

        // Step 1: Define capacity threshold
        int threshold = 60;
        System.out.println("Filtering bogies with capacity > " + threshold + ":");

        // Step 2: Use Stream API to filter and display matching bogies
        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        // Step 3: Display results
        highCapacityBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }
}
