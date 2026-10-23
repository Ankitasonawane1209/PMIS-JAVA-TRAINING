package DAY6_12OCT;

import java.util.*;
public class AreaDriver {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	
	double radius = sc.nextDouble();
    double length = sc.nextDouble();
    double width = sc.nextDouble();

    Circle circle = new Circle(radius);
    circle.setColor("Orange");

    Rectangle rectangle = new Rectangle(length, width);
    rectangle.setColor("Light Blue");

    System.out.println("Circle Color: " + circle.getcolor());
    System.out.printf("Circle Area: %.2f%n", circle.calculateArea());

    System.out.println("Rectangle Color: " + rectangle.getcolor());
    System.out.printf("Rectangle Area: %.2f%n", rectangle.calculateArea());
}
}
