package project;

public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Parameterized Constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Get Vehicle Information
    public String[] getVehicleInfo() {
        return new String[] { make, model, color, String.valueOf(year), String.valueOf(mileage) };
    }

    // Update Attributes
    public void updateAttributes(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Color: " + color + 
               ", Year: " + year + ", Mileage: " + mileage;
    }

    // Clear all attributes (simulate removal of a vehicle)
    public void clearAttributes() {
        this.make = null;
        this.model = null;
        this.color = null;
        this.year = 0;
        this.mileage = 0;
    }
}
