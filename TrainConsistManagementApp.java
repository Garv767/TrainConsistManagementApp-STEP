import java.util.ArrayList; // [cite: 50]
import java.util.List;      // [cite: 52]

/**
 * Use Case 1: Initialize Train and Display Consist Summary
 * This class represents the entry point of the Train Consist Management Application. [cite: 9, 12]
 * Author: Developer [cite: 20]
 * Version: 1.0 [cite: 21]
 */
public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) { // [cite: 45, 48, 57]
        
        // Display welcome banner [cite: 24, 58]
        System.out.println("=== Train Consist Management App ==="); // [cite: 58, 67]

        // Create a dynamic list to store train bogies [cite: 15, 31, 59]
        // Using ArrayList because its size can grow at runtime [cite: 50, 51]
        List<String> trainConsist = new ArrayList<>(); // [cite: 32]

        // Display initial consist information [cite: 33]
        System.out.println("Train initialized successfully..."); // [cite: 34, 68]
        
        // Display the initial bogie count using size() [cite: 16, 60]
        System.out.println("Initial Bogie Count: " + trainConsist.size()); // [cite: 69]
        
        // Print the current state of the train (empty list) [cite: 17, 70]
        System.out.println("Current Train Consist: " + trainConsist); // [cite: 70]

        // Signal system readiness [cite: 71]
        System.out.println("System ready for operations..."); // [cite: 71]
    }
}