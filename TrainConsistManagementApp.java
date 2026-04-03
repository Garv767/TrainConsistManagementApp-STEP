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
 * Full Implementation: UC1 to UC12
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
        
        // UC1 Initialize Train
        System.out.println("Train Consist Management App");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully.\n");

        // UC2 Passenger Bogie Operations
        System.out.println("UC2 Passenger Bogie Operations");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");
        System.out.println("Current Bogies: " + trainConsist);
        System.out.println("Contains Sleeper: " + trainConsist.contains("Sleeper") + "\n");

        // UC3 Unique Bogie IDs
        System.out.println("UC3 Track Unique Bogie IDs");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // Duplicate ignored
        System.out.println("Unique Bogie IDs: " + bogieIds + "\n");

        // UC4 Ordered Consist
        System.out.println("UC4 Maintain Ordered Bogie Consist");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("Cargo");
        orderedConsist.add(1, "Pantry Car");
        System.out.println("Physical Sequence: " + orderedConsist + "\n");

        // UC5 Preserve Insertion Order with Uniqueness
        System.out.println("UC5 Preserve Insertion Order and Uniqueness");
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
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
    }
}