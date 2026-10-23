package DAY5_9OCT;

class Animal1 {
	void eat() {
		System.out.println("Animal is eating");
	}
}
class Dog1 extends Animal1{
	void eat() {
	System.out.println("Dog is eating");
    super.eat();
}
}