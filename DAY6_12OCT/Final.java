package DAY6_12OCT;

class Bank{
	final void calculatesInterset() {
		System.out.println("base Interset calcultation");
		
	}
}
class Branch extends Bank{
	void calculateInterset() {
		System.out.println("Custom Interset");
	}
}