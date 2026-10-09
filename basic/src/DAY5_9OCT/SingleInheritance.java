package DAY5_9OCT;

//single inheritance
class Animal{
	void eat() {
		System.out.println("This animal eats food");
	}
}
	class Dog extends Animal{
		void bark() {
			System.out.println("The dog barks");
			
		}
	}

public class SingleInheritance {
public static void main(String[] args) {
	Dog d = new Dog();
	d.eat();
	d.bark();
}

}
