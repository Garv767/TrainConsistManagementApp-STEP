# Train Consist Management App 🚂

## Overview
The **Train Consist Management App** is a console-based Java application that simulates how a railway system manages a train's consist (the collection of bogies attached to an engine). 

This project was built progressively through 20 distinct Use Cases (UCs). Rather than just being a simple simulation, it is designed as an educational and structural exercise to demonstrate foundational and advanced Java programming concepts through a realistic domain.

## Domain Model
* **Passenger Bogies:** Sleeper, AC Chair, First Class, General (tracks seat capacity).
* **Goods Bogies:** Rectangular, Cylindrical (tracks cargo type and shape-based safety constraints).
* **Consist Composition:** Tracks the sequence, uniqueness, and capacity of the entire train.

## Key Java Concepts Implemented

The application serves as a practical implementation guide for the following Java features:

### 1. Java Collections Framework (UC1 - UC6)
* **`ArrayList`:** Dynamic train initialization and passenger bogie tracking.
* **`HashSet`:** Ensuring unique bogie IDs without preserving order.
* **`LinkedList`:** Maintaining the physical, ordered sequence of the train consist.
* **`LinkedHashSet`:** Preserving insertion order while enforcing uniqueness.
* **`HashMap`:** Mapping specific bogie types to their maximum seating capacities.

### 2. Java Streams API & Lambdas (UC7 - UC10, UC12, UC13)
* **Sorting:** Using `Comparator.comparingInt()` to sort bogies by capacity.
* **Filtering:** Using `.filter()` to find high-capacity bogies or isolate Goods vs. Passenger categories.
* **Grouping:** Using `Collectors.groupingBy()` to organize bogies by their type.
* **Reduction:** Using `.reduce()` to calculate the total seating capacity of the entire train.
* **Validation:** Using `.allMatch()` to verify safety compliance across the entire train.
* **Performance:** Benchmarking traditional loops versus Stream API execution times (`System.nanoTime()`).

### 3. Regular Expressions (UC11)
* **Validation:** Using `Pattern` and `Matcher` to ensure Train IDs follow a strict standardized format (e.g., `TRN-1234`).

### 4. Exception Handling (UC14 - UC15, UC20)
* **Checked Exceptions:** Custom `InvalidCapacityException` enforcing business rules during object creation.
* **Unchecked (Runtime) Exceptions:** Custom `CargoSafetyException` to handle unsafe operational logic (e.g., loading petroleum into a rectangular boxcar).
* **Structured Handling:** Utilizing `try-catch-finally` blocks to ensure graceful degradation and mandatory cleanup/logging.
* **Defensive Programming:** Implementing the "Fail-Fast" principle by throwing `IllegalStateException` to immediately halt operations (like searching) if the train consist is empty.

### 5. Algorithmic Thinking: Sorting & Searching (UC16 - UC19)
* **Manual Bubble Sort:** A nested-loop implementation to sort passenger capacities natively, demonstrating $O(n^2)$ time complexity.
* **Library Sorting:** Utilizing Java's optimized `Arrays.sort()` for alphabetical ordering of bogie names.
* **Linear Search:** Sequential array traversal to find a specific Bogie ID, demonstrating early termination (break) on an unsorted dataset.
* **Binary Search:** A divide-and-conquer approach ($O(\log n)$) to efficiently locate Bogie IDs on pre-sorted data using `String.compareTo()`.

## How to Run

1. **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed (Java 8 or higher).
2. **Compile:** Open your terminal, navigate to the directory containing the file, and run:
   ```bash
   javac TrainConsistManagementApp.java
3. **Execute: Run the compiled class:**
    ```bash
    java TrainConsistManagementApp
    ```
4. **Output:** The console will systematically print the execution results of all 20 use cases, clearly separating the concepts demonstrated.

**Author**
Garv