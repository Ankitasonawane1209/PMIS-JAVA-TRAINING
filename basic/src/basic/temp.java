package basic;

import java.util.*;
public class temp {
	public static void main(String[]arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter thr value");
		  double fahrenheit = sc.nextDouble();

	       double celsius = (fahrenheit - 32) * 5.0 / 9.0;

	        System.out.println("Temperature in Celsius: " + celsius);
	}

}
