package DAY4_8OCT;

class Employee {
    int id;
    String name;
    double salary;

    // Constructor
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;

        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0.0;
        }
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Salary
    public double getSalary() {
        return salary;
    }

    // Setter for Salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative.");
        }
    }

    // Method to give raise
    public void giveRaise(double percent) {
        if (percent > 0) {
            double raiseAmount = this.salary * (percent / 100.0);

            this.salary += raiseAmount;

            System.out.println(name + " received a " + percent
                    + "% raise. New Salary: ₹" + this.salary);
        } else {
            System.out.println("Raise percentage must be positive.");
        }
    }
}

// Main class
public class Encapsualtion_problem1 {

    public static void main(String[] args) {

        Employee emp = new Employee(101, "Alice", 50000.0);

        System.out.println("Initial Salary: ₹" + emp.getSalary());

        // Apply raise
        emp.giveRaise(8);

        // Attempt invalid update
        emp.setSalary(-25000);

        // Final check
        System.out.println("Final Verified Salary: ₹" + emp.getSalary());
    }
}