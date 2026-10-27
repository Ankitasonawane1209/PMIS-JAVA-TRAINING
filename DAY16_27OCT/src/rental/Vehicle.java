package rental;

public abstract class Vehicle implements Rentable {

        private String id;
        private String model;
        private double dailyRate;
        private boolean available;

        public Vehicle(String id, String model, double dailyRate) {
            this.id = id;
            this.model = model;
            this.dailyRate = dailyRate;
            this.available = true;
        }

        public String getId() {
            return id;
        }
      public String getModel() {
            return model;
        }

        public double getDailyRate() {
            return dailyRate;
        }

        @Override
        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public String getVehicleName() {
            return getClass().getSimpleName() + " " + model + " (" + id + ")";
        }

        @Override
        public abstract double calculateRent(int days);
    }

