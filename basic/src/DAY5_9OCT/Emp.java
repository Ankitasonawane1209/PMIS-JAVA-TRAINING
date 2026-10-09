
package DAY5_9OCT;

class Emp {
    String name;
    double salary;

    Emp(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee name: " + name);
        System.out.println("Employee salary: " + salary);
    }
}

class Managerr extends Emp {
    String department;

    Managerr(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
        System.out.println("Role: Manager");
    }
}

