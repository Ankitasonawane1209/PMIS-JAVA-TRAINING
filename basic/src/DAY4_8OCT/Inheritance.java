package DAY4_8OCT;

// Parent Class (Superclass)
class Vehicle {

    // Attribute
    String brand;

    // Method
    void startEngine() {
        System.out.println(brand + " engine started.");
    }
}

// Child Class (Subclass)
class Bike extends Vehicle {

    // Attribute
    boolean hasCarrier;

    // Method
    void kickStand() {
        System.out.println("Kickstand put down.");
    }
}

// Main Class
public class Inheritance {

    public static void main(String[] args) {

        // Creating Bike object
        Bike myBike = new Bike();

        // Inherited variable from Vehicle
        myBike.brand = "Shine";

        // Inherited method from Vehicle
        myBike.startEngine();

        // Bike's own method
        myBike.kickStand();

        // Bike's own variable
        myBike.hasCarrier = true;

        System.out.println("Has Carrier: " + myBike.hasCarrier);
    }
}