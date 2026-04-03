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
 * Full Implementation: UC1 to UC13
 * Author: Garv
 */

class Bogie {
    String name;
    String type;
    String category;
    int capacity;
    String cargo;

    Bogie(String name, String type, String category, int capacity, String cargo) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.capacity = capacity;
        this.cargo = cargo;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public int getCapacity() { return capacity; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("%s [%s] Category: %s, Capacity: %d, Cargo: %s", 
                name, type, category, capacity, cargo == null ? "None" : cargo);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        // UC1: INITIALIZATION
        System.out.println("Train Consist Management App");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully.\n");

        // UC2: PASSENGER BOGIE OPERATIONS
        System.out.println("UC2: Passenger Bogie Operations");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("After Adding Bogies: " + trainConsist);
        trainConsist.remove("AC Chair");
        System.out.println("Current Bogies: " + trainConsist + "\n");

        // UC3: UNIQUE BOGIE IDS
        System.out.println("UC3: Track Unique Bogie IDs");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // Duplicate
        System.out.println("Unique Bogie IDs: " + bogieIds + "\n");

        // UC4: ORDERED CONSIST
        System.out.println("UC4: Maintain Ordered Bogie Consist");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("Cargo");
        orderedConsist.add(1, "Pantry Car");
        System.out.println("Physical Sequence: " + orderedConsist + "\n");

        // UC5: PRESERVE INSERTION ORDER WITH UNIQUENESS
        System.out.println("UC5: Preserve Insertion Order and Uniqueness");
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
        formation.add("Sleeper"); // Duplicate ignored
        System.out.println("Final Formation: " + formation + "\n");

        // UC6 Map Bogie to Capacity
        System.out.println("UC6 Map Bogie to Capacity");
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("First Class", 24);
        capacityMap.put("AC Chair", 56);
        System.out.println("Capacity Mapping: " + capacityMap + "\n");

        // UC7 Sort Bogies by Capacity
        System.out.println("UC7 Sort Bogies by Capacity");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper 1", "Sleeper", "Passenger", 72, "Passengers"));
        bogieList.add(new Bogie("AC Chair 1", "AC Chair", "Passenger", 56, "Passengers"));
        bogieList.add(new Bogie("First Class 1", "First Class", "Passenger", 24, "Passengers"));
        bogieList.add(new Bogie("General 1", "General", "Passenger", 90, "Passengers"));

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorted Bogies:");
        bogieList.forEach(System.out::println);
        System.out.println();

        // UC8 Filter Passenger Bogies Using Streams
        System.out.println("UC8 Filter Passenger Bogies (Capacity > 60)");
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        filteredBogies.forEach(System.out::println);
        System.out.println();

        // UC9 Group Bogies by Type
        System.out.println("UC9 Group Bogies by Type");
        bogieList.add(new Bogie("Tanker 1", "Cylindrical", "Goods", 100, "Petroleum"));
        bogieList.add(new Bogie("Boxcar 1", "Box", "Goods", 120, "Coal"));
        
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type + " | Count: " + list.size());
        });
        System.out.println();

        // UC10 Count Total Seats
        System.out.println("UC10 Count Total Seats in Train");
        int totalSeats = bogieList.stream()
                .filter(b -> b.getCategory().equals("Passenger"))
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Seating Capacity: " + totalSeats + "\n");

        // UC11 Validate Train ID & Cargo Codes
        System.out.println("UC11 Validate Format using Regex");
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";
        
        boolean isIdValid = Pattern.matches("^TRN-\\d{4}$", trainId);
        boolean isCargoValid = Pattern.matches("^PET-[A-Z]{2}$", cargoCode);
        
        System.out.println("Train ID [" + trainId + "] Valid: " + isIdValid);
        System.out.println("Cargo Code [" + cargoCode + "] Valid: " + isCargoValid + "\n");

        // UC12 Safety Compliance Check for Goods Bogies
        System.out.println("UC12 Safety Compliance Check");
        // Rule: Cylindrical bogies MUST carry Petroleum. Non-cylindrical can carry anything.
        boolean isTrainSafe = bogieList.stream()
                .filter(b -> b.getCategory().equals("Goods"))
                .allMatch(b -> {
                    if (b.getType().equals("Cylindrical")) {
                        return b.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    return true; // Other shapes are safe with any cargo
                });

        System.out.println("Train Safety Compliance Status: " + (isTrainSafe ? "SAFE" : "UNSAFE"));
        if (!isTrainSafe) {
            System.out.println("Alert: Safety violation detected! Check Cylindrical bogie cargo.");
        }
        
        System.out.println("\nUC1 to UC12 operations completed.");
        formation.add("Sleeper"); // Duplicate ignored
        System.out.println("Final Formation: " + formation + "\n");

        // UC6: MAP BOGIE TO CAPACITY
        System.out.println("UC6: Map Bogie to Capacity");
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("First Class", 24);
        capacityMap.put("AC Chair", 56);
        System.out.println("Capacity Mapping: " + capacityMap + "\n");

        // UC7: SORT BOGIES BY CAPACITY
        System.out.println("UC7: Sort Bogies by Capacity");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper 1", "Sleeper", "Passenger", 72, "Passengers"));
        bogieList.add(new Bogie("AC Chair 1", "AC Chair", "Passenger", 56, "Passengers"));
        bogieList.add(new Bogie("First Class 1", "First Class", "Passenger", 24, "Passengers"));
        bogieList.add(new Bogie("General 1", "General", "Passenger", 90, "Passengers"));

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorted Bogies:");
        bogieList.forEach(System.out::println);
        System.out.println();

        // UC8: FILTER PASSENGER BOGIES USING STREAMS
        System.out.println("UC8: Filter Passenger Bogies (Capacity > 60)");
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        filteredBogies.forEach(System.out::println);
        System.out.println();

        // UC9: GROUP BOGIES BY TYPE
        System.out.println("UC9: Group Bogies by Type");
        bogieList.add(new Bogie("Tanker 1", "Cylindrical", "Goods", 100, "Petroleum"));
        bogieList.add(new Bogie("Boxcar 1", "Box", "Goods", 120, "Coal"));
        
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type + " | Count: " + list.size());
        });
        System.out.println();

        // UC10: COUNT TOTAL SEATS
        System.out.println("UC10: Count Total Seats in Train");
        int totalSeats = bogieList.stream()
                .filter(b -> b.getCategory().equals("Passenger"))
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Seating Capacity: " + totalSeats + "\n");

        // UC11: VALIDATE TRAIN ID & CARGO CODES
        System.out.println("UC11: Validate Format using Regex");
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";
        boolean isIdValid = Pattern.matches("^TRN-\\d{4}$", trainId);
        boolean isCargoValid = Pattern.matches("^PET-[A-Z]{2}$", cargoCode);
        System.out.println("Train ID Valid: " + isIdValid);
        System.out.println("Cargo Code Valid: " + isCargoValid + "\n");

        // UC12: SAFETY COMPLIANCE CHECK
        System.out.println("UC12: Safety Compliance Check");
        boolean isTrainSafe = bogieList.stream()
                .filter(b -> b.getCategory().equals("Goods"))
                .allMatch(b -> {
                    if (b.getType().equals("Cylindrical")) {
                        return b.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    return true;
                });
        System.out.println("Train Safety Compliance Status: " + (isTrainSafe ? "SAFE" : "UNSAFE") + "\n");

        // UC13: PERFORMANCE COMPARISON (LOOPS VS STREAMS)
        System.out.println("UC13: Performance Comparison (Loops vs Streams)");
        
        // Benchmarking Loop
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // Benchmarking Stream
        long startTimeStream = System.nanoTime();
        List<Bogie> streamResult = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        System.out.println("Loop Execution Time: " + durationLoop + " ns");
        System.out.println("Stream Execution Time: " + durationStream + " ns");
        System.out.println("Results Match: " + (loopResult.size() == streamResult.size()));
        
        System.out.println("\nUC1 to UC13 operations completed.");
    }
}