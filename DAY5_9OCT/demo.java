package DAY5_9OCT;

class Employee{
	double salary = 30000;
}
class Manager extends Employee{
	double salary =60000;
	
	void displaySalary() {
      System.out.println("manager salary: "+salary);
      System.out.println("employee salary: "+super.salary);
	}
}