package rental;

public class Main {

    public static void main(String[] args) {

        RentalShop shop = new RentalShop();

        // Create vehicles
        Car car = new Car("C1", "Swift", 2000);
        Bike bike = new Bike("B1", "Activa", 400);
        Truck truck = new Truck("T1", "Tata Ace", 2500);

        // Add vehicles to the shop
        shop.addVehicle(car);
        shop.addVehicle(bike);
        shop.addVehicle(truck);

        // Create customers
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer priya = new Customer("Priya");

        try {
            // Asha rents the bike for 8 days
            Rental rental1 = shop.rent("B1", asha, 8);

            System.out.printf(
                    "%s rented %s for %d days = %.2f%n",
                    rental1.getCustomer().getName(),
                    rental1.getVehicle().getVehicleName(),
                    rental1.getDays(),
                    rental1.getTotalRent()
            );

            // Ravi rents the truck for 2 days
            Rental rental2 = shop.rent("T1", ravi, 2);

            System.out.printf(
                    "%s rented %s for %d days = %.2f%n",
                    rental2.getCustomer().getName(),
                    rental2.getVehicle().getVehicleName(),
                    rental2.getDays(),
                    rental2.getTotalRent()
            );

            // Priya tries to rent the same bike
            try {
                shop.rent("B1", priya, 3);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Return the truck
            shop.giveBack("T1");

            // Display available vehicles
            shop.showAvailable();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}