package project;

import java.util.ArrayList;
import java.util.Scanner;

public class AutomobileInventory {
    private ArrayList<Automobile> inventory;

    public AutomobileInventory() {
        inventory = new ArrayList<>();
    }

    // Add a new vehicle
    public void addVehicle(String make, String model, String color, int year, int mileage) {
        Automobile newVehicle = new Automobile(make, model, color, year, mileage);
        inventory.add(newVehicle);
        int index = inventory.size(); // 1-based index
        System.out.println("Vehicle added successfully.");
        System.out.println("Index: " + index);
        System.out.println(newVehicle);
    }

    // List all vehicles
    public void listVehicles() {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i));
            }
        }
    }

    // Remove a vehicle by index
    public void removeVehicle(int index) {
        if (index >= 0 && index < inventory.size()) {
            inventory.remove(index);
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Search for vehicles by make or model
    public void searchVehicles(String keyword) {
        boolean found = false;
        for (Automobile auto : inventory) {
            if (auto.toString().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(auto);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles match your search.");
        }
    }

    // Update vehicle attributes
    public void updateVehicle(int index, String make, String model, String color, int year, int mileage) {
        if (index >= 0 && index < inventory.size()) {
            inventory.get(index).updateAttributes(make, model, color, year, mileage);
            System.out.println("Vehicle updated successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // User Interface
    public void userInterface() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nVehicle Inventory Program");
            System.out.println("1. Add Vehicle");
            System.out.println("2. List Vehicles");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Search Vehicles");
            System.out.println("5. Update Vehicle");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter mileage: ");
                    int mileage = scanner.nextInt();
                    addVehicle(make, model, color, year, mileage);
                }
                case 2 -> listVehicles();
                case 3 -> {
                    System.out.print("Enter the index of the vehicle to remove: ");
                    int index = scanner.nextInt();
                    removeVehicle(index - 1); // Convert to 0-based index
                }
                case 4 -> {
                    System.out.print("Enter search keyword (make/model): ");
                    String keyword = scanner.nextLine();
                    searchVehicles(keyword);
                }
                case 5 -> {
                    System.out.print("Enter the index of the vehicle to update: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter new model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter new color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter new year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter new mileage: ");
                    int mileage = scanner.nextInt();
                    updateVehicle(index - 1, make, model, color, year, mileage);
                }
                case 6 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    public static void main(String[] args) {
    	AutomobileInventory program = new AutomobileInventory();
        program.userInterface();
    }
}

