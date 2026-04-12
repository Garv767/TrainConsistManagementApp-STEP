import java.util.ArrayList;
import java.util.Arrays;
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
 * Full Implementation: UC1 to UC17
 * Author: Garv
 */

// UC14: Custom Exception for Invalid Capacity
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// UC15: Custom Runtime Exception for Cargo Safety
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class Bogie {
    String name;
    String type; // Used as the shape for Goods bogies
    String category;
    int capacity;
    String cargo;

    // UC14: Constructor enforcing capacity rules
    Bogie(String name, String type, String category, int capacity, String cargo) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero for bogie: " + name);
        }
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

    // UC15: Assign cargo with safety validation using try-catch-finally
    public void assignCargoSafely(String newCargo) {
        try {
            // Rule: Rectangular bogie cannot carry petroleum
            if (this.type.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }
            
            this.cargo = newCargo;
            System.out.println("Cargo assigned successfully -> " + newCargo);
            
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // finally block executes cleanup or logging whether successful or failed
            System.out.println("Cargo validation completed for " + this.type + " bogie\n");
        }
    }

    @Override
    public String toString() {
        return String.format("%s [%s] Category: %s, Capacity: %d, Cargo: %s", 
                name, type, category, capacity, cargo == null ? "None" : cargo);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        try {
            // UC1: INITIALIZATION
            System.out.println("Train Consist Management App");
            List<String> trainConsist = new ArrayList<>();
            System.out.println("Train initialized successfully.\n");

            // UC2: PASSENGER BOGIE OPERATIONS
            System.out.println("UC2: Passenger Bogie Operations");
            trainConsist.add("Sleeper");
            trainConsist.add("AC Chair");
            trainConsist.add("First Class");
            trainConsist.remove("AC Chair");
            System.out.println("Current Bogies: " + trainConsist + "\n");

            // UC3: UNIQUE BOGIE IDS
            System.out.println("UC3: Track Unique Bogie IDs");
            Set<String> bogieIds = new HashSet<>();
            bogieIds.add("BG101");
            bogieIds.add("BG102");
            bogieIds.add("BG101"); 
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
            formation.add("Sleeper"); 
            System.out.println("Final Formation: " + formation + "\n");

            // UC6: MAP BOGIE TO CAPACITY
            System.out.println("UC6: Map Bogie to Capacity");
            Map<String, Integer> capacityMap = new HashMap<>();
            capacityMap.put("Sleeper", 72);
            capacityMap.put("First Class", 24);
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
            boolean isIdValid = Pattern.matches("^TRN-\\d{4}$", trainId);
            System.out.println("Train ID [" + trainId + "] Valid: " + isIdValid + "\n");

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

            // UC13: PERFORMANCE COMPARISON
            System.out.println("UC13: Performance Comparison (Loops vs Streams)");
            long startStream = System.nanoTime();
            bogieList.stream().filter(b -> b.getCapacity() > 50).collect(Collectors.toList());
            long endStream = System.nanoTime();
            System.out.println("Stream Execution Time: " + (endStream - startStream) + " ns\n");

            // UC14: HANDLE INVALID BOGIE CAPACITY (Exception Handling)
            System.out.println("UC14: Testing Custom Exception Handling");
            try {
                System.out.println("Attempting to add a bogie with zero capacity...");
                Bogie invalidBogie = new Bogie("Broken Bogie", "General", "Passenger", 0, "None");
            } catch (InvalidCapacityException e) {
                System.err.println("Caught Expected Exception: " + e.getMessage() + "\n");
            }

            // UC15: SAFE CARGO ASSIGNMENT (try-catch-finally)
            System.out.println("UC15 - Safe Cargo Assignment");

            try {
                // Initialize bogies to test safe vs unsafe assignment
                Bogie cylindricalBogie = new Bogie("Tanker 2", "Cylindrical", "Goods", 100, "None");
                Bogie rectangularBogie = new Bogie("Boxcar 2", "Rectangular", "Goods", 120, "None");

                // Test Safe Assignment (Petroleum in Cylindrical bogie)
                cylindricalBogie.assignCargoSafely("Petroleum");

                // Test Unsafe Assignment (Petroleum in Rectangular bogie)
                rectangularBogie.assignCargoSafely("Petroleum");

                System.out.println("UC15 runtime handling completed...\n");

            } catch (InvalidCapacityException e) {
                System.err.println("Error initializing bogies for UC15: " + e.getMessage());
            }

            // UC16: MANUAL SORTING USING BUBBLE SORT
            System.out.println("UC16 Manual Sorting using Bubble Sort");

            // Create array of passenger bogie capacities
            int[] capacities = {72, 56, 24, 70, 60};

            // Display original order
            System.out.println("Original Capacities:");
            for (int c : capacities) {
                System.out.print(c + " ");
            }
            System.out.println();

            // Bubble Sort Logic
            int n = capacities.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (capacities[j] > capacities[j + 1]) {
                        // Swap values if they are in the wrong order
                        int temp = capacities[j];
                        capacities[j] = capacities[j + 1];
                        capacities[j + 1] = temp;
                    }
                }
            }

            // Display sorted result
            System.out.println("\nSorted Capacities (Ascending):");
            for (int c : capacities) {
                System.out.print(c + " ");
            }
            System.out.println("\n\nUC16 sorting completed...\n");

            // UC17: SORT BOGIE NAMES USING Arrays.sort()
            System.out.println("UC17 Sort Bogie Names Using Arrays.sort()");

            String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

            System.out.println("Original Bogie Names:");
            System.out.println(Arrays.toString(bogieNames) + "\n");

            Arrays.sort(bogieNames);

            System.out.println("Sorted Bogie Names (Alphabetical):");
            System.out.println(Arrays.toString(bogieNames) + "\n");

            System.out.println("UC17 sorting completed...\n");

            System.out.println("All Use Cases (UC1-UC17) completed successfully.");

        } catch (InvalidCapacityException e) {
            System.err.println("Critical Error in Train Formation: " + e.getMessage());
        }
    }
}