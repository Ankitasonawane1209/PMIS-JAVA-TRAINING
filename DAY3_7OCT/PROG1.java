//Enter 3 numbers from the user & make a function to print their average. 

package DAY3_7OCT;

import java.util.Scanner;

public class PROG1 {
	    
	    static double average(int a, int b, int c) {
	        return (a + b + c) / 3.0;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        int a = sc.nextInt();

	        System.out.print("Enter second number: ");
	        int b = sc.nextInt();

	        System.out.print("Enter third number: ");
	        int c = sc.nextInt();

	        System.out.println("Average = " + average(a, b, c));
	    }
	}
