package DAY5_9OCT;


class Device {
	void poweron() {
		System.out.println("Device powered on");
	}
	
}
class dabbaphone extends Device{
	void makeCall() {
		System.out.println("calling the number");
	}
	
}
class SmartPhone extends dabbaphone{
	void  brosweInternet() {
		System.out.println("opening Broewer");
	}
} 
public class MultilevelInheritance {
public static void main(String[] args) {
	SmartPhone samsung = new SmartPhone();
	samsung.brosweInternet();
	samsung.makeCall();
	samsung.poweron();
}
}
