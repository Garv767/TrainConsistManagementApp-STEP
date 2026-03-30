import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList; // Required for UC4
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management Application
 * (App-Based Learning Using Core Java & Data Structures)
 * * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * UC4: Maintain Ordered Bogie Consist (LinkedList)
 * * Author: Garv
 * Version: 4.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        
        // --- UC1: INITIALIZATION ---
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist + "\n");

        // --- UC2: PASSENGER BOGIE OPERATIONS ---
        System.out.println("--- UC2 Add Passenger Bogies to Train ---");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("After Adding Bogies: " + trainConsist);
        trainConsist.remove("AC Chair");
        System.out.println("After Removing 'AC Chair': " + trainConsist + "\n");

        // --- UC3: UNIQUE BOGIE ID TRACKING ---
        System.out.println("--- UC3 Track Unique Bogie IDs ---");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // Duplicate
        System.out.println("Bogie IDs (Unique): " + bogieIds + "\n");

        // --- UC4: ORDERED BOGIE CONSIST ---
        System.out.println("--- UC4 Maintain Ordered Bogie Consist ---");

        // Step 1: Create a LinkedList to model physical chaining
        // We use the specific LinkedList type to access addFirst/addLast methods
        LinkedList<String> orderedConsist = new LinkedList<>(); // [cite: 268, 284]

        // Step 2: Add initial bogies in sequence
        orderedConsist.add("Engine");   // [cite: 285]
        orderedConsist.add("Sleeper");  // [cite: 285]
        orderedConsist.add("AC");       // [cite: 285]
        orderedConsist.add("Cargo");    // [cite: 285]
        orderedConsist.add("Guard");    // [cite: 285]
        
        System.out.println("Initial Train Consist:");
        System.out.println(orderedConsist); // [cite: 296, 297]

        // Step 3: Insert 'Pantry Car' at position 2 (3rd spot)
        orderedConsist.add(2, "Pantry Car"); // [cite: 280, 286]
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(orderedConsist); // [cite: 298, 299]

        // Step 4: Remove the first (Engine) and last (Guard) bogies
        orderedConsist.removeFirst(); // [cite: 281, 287]
        orderedConsist.removeLast();  // [cite: 281, 287]
        
        // Final Output
        System.out.println("After Removing First and Last Bogie:");
        System.out.println(orderedConsist); // [cite: 300, 301]
        
        System.out.println("UC4 ordered consist operations completed successfully..."); // [cite: 302]
    }
}