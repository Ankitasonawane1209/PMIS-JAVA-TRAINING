package rental;

import java.util.ArrayList;
import java.util.List;

public class RentalShop {

    private List<Vehicle> fleet;

    public RentalShop() {
        fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Rental rent(String vehicleId, Customer customer, int days)
            throws Exception {

        if (days <= 0) {
            throw new IllegalArgumentException(
                    "rental.Rental days must be greater than zero");
        }

        Vehicle selectedVehicle = null;

        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equalsIgnoreCase(vehicleId)) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            throw new Exception(
                    "rental.Vehicle with ID " + vehicleId + " was not found");
        }

        if (!selectedVehicle.isAvailable()) {
            throw new Exception(
                    selectedVehicle.getVehicleName() + " is already rented");
        }

        Rental rental = new Rental(selectedVehicle, customer, days);

        selectedVehicle.setAvailable(false);

        customer.addRental(rental);

        return rental;
    }

    public void giveBack(String vehicleId) throws Exception {

        for (Vehicle vehicle : fleet) {

            if (vehicle.getId().equalsIgnoreCase(vehicleId)) {

                if (vehicle.isAvailable()) {
                    throw new Exception(
                            vehicle.getVehicleName()
                                    + " has not been rented");
                }

                vehicle.setAvailable(true);

                System.out.println(
                        vehicle.getVehicleName() + " returned successfully");

                return;
            }
        }

        throw new Exception(
                "rental.Vehicle with ID " + vehicleId + " was not found");
    }

    public void showAvailable() {

        System.out.println("Available vehicles:");

        for (Vehicle vehicle : fleet) {

            if (vehicle.isAvailable()) {
                System.out.println(
                        "  " + vehicle.getVehicleName());
            }
        }
    }
}