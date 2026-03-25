import java.util.ArrayList;
import java.util.List; 

/**
 * Use Case 1: Initialize Train and Display Consist Summary
 * This class represents the entry point of the Train Consist Management Application. 
 * Author: Garv
 * Version: 1.0
 */
public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) {
        
        System.out.println("=== Train Consist Management App ==="); 

        List<String> trainConsist = new ArrayList<>(); 

        System.out.println("Train initialized successfully..."); 
        
        System.out.println("Initial Bogie Count: " + trainConsist.size()); 
        
        System.out.println("Current Train Consist: " + trainConsist); 

        System.out.println("System ready for operations...");
    }
}