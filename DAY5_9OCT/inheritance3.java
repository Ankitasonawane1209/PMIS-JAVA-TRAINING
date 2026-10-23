package DAY5_9OCT;





class Animall {
    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dogg extends Animall {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class inheritance3 {
    public static void main(String[] args) {
        // Create an object of Dog
        Dogg d = new Dogg();

        // Assign name
        d.name = "Tommy";

        // Print dog's name
        System.out.println(d.name);

        // Call parent class method
        d.eat();

        // Call child class method
        d.bark();
    }
}
