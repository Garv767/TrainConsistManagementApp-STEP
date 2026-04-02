import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 * Comprehensive Implementation: UC1 to UC11
 * Author: Garv
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

    public int getCapacity() {
        return capacity;
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

        // UC2: PASSENGER BOGIE OPERATIONS (ArrayList)
        System.out.println("UC2: Add Passenger Bogies to Train");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("After Adding Bogies: " + trainConsist);
        trainConsist.remove("AC Chair");
        System.out.println("After Removing 'AC Chair': " + trainConsist);
        System.out.println("Checking if 'Sleeper' exists: " + trainConsist.contains("Sleeper") + "\n");

        // UC3: UNIQUE BOGIE ID TRACKING (HashSet)
        System.out.println("UC3: Track Unique Bogie IDs");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate entry
        System.out.println("Bogie IDs (Unique): " + bogieIds + "\n");

        // UC4: ORDERED BOGIE CONSIST (LinkedList)
        System.out.println("UC4: Maintain Ordered Bogie Consist");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        orderedConsist.add(2, "Pantry Car");
        System.out.println("Ordered Consist: " + orderedConsist);
        orderedConsist.removeFirst();
        orderedConsist.removeLast();
        System.out.println("After removing first and last: " + orderedConsist + "\n");

        // UC5: PRESERVE INSERTION ORDER WITH UNIQUENESS (LinkedHashSet)
        System.out.println("UC5: Preserve Insertion Order of Bogies");
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // Duplicate ignored
        System.out.println("Final Train Formation: " + formation + "\n");

        // UC6: MAP BOGIE TO CAPACITY (HashMap)
        System.out.println("UC6: Map Bogie to Capacity");
        Map<String, Integer> bogieCapacities = new HashMap<>();
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        // UC7: SORT BOGIES BY CAPACITY (Comparator)
        System.out.println("UC7: Sort Bogies by Capacity");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper 1", "Passenger", 72));
        bogieList.add(new Bogie("AC Chair 1", "Passenger", 56));
        bogieList.add(new Bogie("First Class 1", "Passenger", 24));
        bogieList.add(new Bogie("General 1", "Passenger", 90));

        System.out.println("Before Sorting:");
        bogieList.forEach(System.out::println);

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting by Capacity:");
        bogieList.forEach(System.out::println);
        System.out.println();

        // UC8: FILTER PASSENGER BOGIES USING STREAMS
        System.out.println("UC8: Filter Passenger Bogies Using Streams");
        int threshold = 60;
        List<Bogie> highCapacityBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
        System.out.println("Bogies with capacity > " + threshold + ":");
        highCapacityBogies.forEach(System.out::println);
        System.out.println();

        // UC9: GROUP BOGIES BY TYPE (Collectors.groupingBy)
        System.out.println("UC9: Group Bogies by Type");
        bogieList.add(new Bogie("Tanker 1", "Goods", 100));
        bogieList.add(new Bogie("Flatcar 1", "Goods", 120));

        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type);
            list.forEach(b -> System.out.println("  - " + b.name + " (Capacity: " + b.capacity + ")"));
        });
        System.out.println();

        // UC10: COUNT TOTAL SEATS IN TRAIN (reduce)
        System.out.println("UC10: Count Total Seats in Train");
        int totalSeats = bogieList.stream()
                .filter(b -> b.getType().equals("Passenger"))
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Seating Capacity of Train: " + totalSeats + "\n");

        // UC11: VALIDATE TRAIN ID & CARGO CODES (Regex)
        System.out.println("UC11: Validate Train ID and Cargo Code");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Example: TRN-1234): ");
        String trainId = scanner.nextLine();
        System.out.print("Enter Cargo Code (Example: PET-AB): ");
        String cargoCode = scanner.nextLine();

        String trainIdRegex = "^TRN-\\d{4}$";
        String cargoCodeRegex = "^PET-[A-Z]{2}$";

        Pattern p1 = Pattern.compile(trainIdRegex);
        Pattern p2 = Pattern.compile(cargoCodeRegex);

        Matcher m1 = p1.matcher(trainId);
        Matcher m2 = p2.matcher(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID [" + trainId + "] Valid: " + m1.matches());
        System.out.println("Cargo Code [" + cargoCode + "] Valid: " + m2.matches());

        System.out.println("\nAll Use Cases (UC1-UC11) completed successfully.");
        scanner.close();
    }
}