package basic;

import java.util.Scanner;

public class calculators {
	public static void main(String[] args) {
		
	 
		System.out.println("1.circle\n2.rectangle\n3square");
		System.out.println("Enter your choice ");
		Scanner sc= new Scanner(System.in);
		int num =sc.nextInt();
		switch(num) {
		
		case 1:
            System.out.print("Enter radius: ");
            double radius = sc.nextDouble();

            double circleArea = 3.14 * radius * radius;

            System.out.println("Area of Circle = " + circleArea);
            break;
            
		case 2:
			System.out.print("Enter the length:");
			double length =sc.nextDouble();
			
			System.out.print("Enter the breadth:");
			double breadth =sc.nextDouble();
			
			 double rectangle = length * breadth;
			 
     	     System.out.println("Area of Rectangle = " + rectangle);
		     break;
			
		case 3:
		    System.out.print("Enter side: ");
		    double side = sc.nextDouble();
		
	    double square = side * side;
		
	    System.out.println("Area of Square = " + square);
		    break;
		
		default:
	    System.out.println("Invalid choice!");
		
 
            
            
            

		}
		
	}

}