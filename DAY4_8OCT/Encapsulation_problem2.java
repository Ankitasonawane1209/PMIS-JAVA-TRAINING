
package DAY4_8OCT;

// 1. Base Class
class Vehicle1 {

    protected String registrationNumber;

    public Vehicle1(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double calculateToll() {
        return 50.0;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

// 2. Child Class: Car
class Car1 extends Vehicle1 {

    public Car1(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateToll() {
        return 50.0 + 20.0;
    }
}

// 3. Child Class: Truck
class Truck1 extends Vehicle1 {

    private int axles;

    public Truck1(String registrationNumber, int axles) {
        super(registrationNumber);
        this.axles = axles;
    }

    @Override
    public double calculateToll() {
        return 100.0 + (axles * 50.0);
    }
}

// 4. Main Class
public class Encapsulation_problem2 {

    public static void main(String[] args) {

        Vehicle1 myCar = new Car1("MH-04-AB-1234");
        Vehicle1 myTruck = new Truck1("MH-43-XY-9999", 4);

        System.out.println(
            "Vehicle: " + myCar.getRegistrationNumber()
            + " | Toll Due: ₹" + myCar.calculateToll()
        );

        System.out.println(
            "Vehicle: " + myTruck.getRegistrationNumber()
            + " | Toll Due: ₹" + myTruck.calculateToll()
        );
    }
}
