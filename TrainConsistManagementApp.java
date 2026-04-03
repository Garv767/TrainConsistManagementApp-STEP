import java.util.ArrayList;
import java.util.Comparator; 
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
 * UC1 - UC10 Implementation
 * Author: Garv
 * Version: 10.0
 */

class Bogie {
    String name;
    String type;
    int capacity;

    Bogie(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " [" + type + "] -> " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        // UC1: INITIALIZATION
        System.out.println("Train Consist Management App");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...\n");

        // UC2: PASSENGER BOGIE OPERATIONS
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
        bogieIds.add("BG101"); // Duplicate
        System.out.println("Bogie IDs (Unique): " + bogieIds + "\n");

        // UC4: ORDERED BOGIE CONSIST
        System.out.println("UC4 Maintain Ordered Bogie Consist");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("Cargo");
        orderedConsist.add(1, "Pantry Car");
        System.out.println("Ordered Consist: " + orderedConsist + "\n");

        // UC5: PRESERVE INSERTION ORDER WITH UNIQUENESS
        System.out.println("UC5 Preserve Insertion Order of Bogies");
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // Duplicate entry ignored
        System.out.println("Final Train Formation: " + formation + "\n");

        // UC6: MAP BOGIE TO CAPACITY
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
        System.out.println("\nUC6 mapping completed...\n");

        // UC7: SORT BOGIES BY CAPACITY
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
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper 1", "Passenger", 72));
        bogieList.add(new Bogie("AC Chair 1", "Passenger", 56));
        bogieList.add(new Bogie("First Class 1", "Passenger", 24));
        bogieList.add(new Bogie("General 1", "Passenger", 90));

        System.out.println("Before Sorting:");
        bogieList.forEach(System.out::println);

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        bogieList.forEach(System.out::println);
        System.out.println("\nUC7 sorting completed...\n");

        // UC8: FILTER PASSENGER BOGIES USING STREAMS
        System.out.println("UC8 Filter Passenger Bogies Using Streams");
        int threshold = 60;
        System.out.println("Filtering bogies with capacity > " + threshold + ":");
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
        filteredBogies.forEach(System.out::println);
        System.out.println("\nUC8 filtering completed...\n");

        // UC9: GROUP BOGIES BY TYPE
        System.out.println("UC9 Group Bogies by Type (Collectors.groupingBy)");
        
        // Adding more bogies to demonstrate grouping
        bogieList.add(new Bogie("Sleeper 2", "Passenger", 72));
        bogieList.add(new Bogie("Tanker 1", "Goods", 100));
        bogieList.add(new Bogie("Flatcar 1", "Goods", 120));

        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Grouped Bogie Report:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type);
            list.forEach(b -> System.out.println("  - " + b.name + " (Capacity: " + b.capacity + ")"));
        });

        System.out.println("\nUC9 grouping completed.");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper 1", "Passenger", 72));
        bogieList.add(new Bogie("AC Chair 1", "Passenger", 56));
        bogieList.add(new Bogie("First Class 1", "Passenger", 24));
        bogieList.add(new Bogie("General 1", "Passenger", 90));

        System.out.println("Before Sorting:");
        bogieList.forEach(System.out::println);

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        bogieList.forEach(System.out::println);
        System.out.println("\nUC7 sorting completed...\n");

        // UC8: FILTER PASSENGER BOGIES USING STREAMS
        System.out.println("UC8 Filter Passenger Bogies Using Streams");
        int threshold = 60;
        System.out.println("Filtering bogies with capacity > " + threshold + ":");
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
        filteredBogies.forEach(System.out::println);
        System.out.println("\nUC8 filtering completed...\n");

        // UC9: GROUP BOGIES BY TYPE
        System.out.println("UC9 Group Bogies by Type (Collectors.groupingBy)");
        bogieList.add(new Bogie("Tanker 1", "Goods", 100));
        bogieList.add(new Bogie("Flatcar 1", "Goods", 120));

        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Grouped Bogie Report:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type);
            list.forEach(b -> System.out.println("  - " + b.name + " (Capacity: " + b.capacity + ")"));
        });
        System.out.println("\nUC9 grouping completed...\n");

        // UC10: COUNT TOTAL SEATS IN TRAIN
        System.out.println("UC10 Count Total Seats in Train (reduce)");

        // Creating list of bogies for UC10 demonstration
        List<Bogie> analyticsList = new ArrayList<>();
        analyticsList.add(new Bogie("Sleeper", "Passenger", 72));
        analyticsList.add(new Bogie("AC Chair", "Passenger", 56));
        analyticsList.add(new Bogie("First Class", "Passenger", 24));
        analyticsList.add(new Bogie("Sleeper", "Passenger", 70));

        System.out.println("Bogies in Train:");
        for (Bogie b : analyticsList) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // map() extracts capacity field and reduce() sums them up
        int totalSeats = analyticsList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        System.out.println("UC10 aggregation completed...");
    }
}