//Write a function that calculates the Greatest Common Divisor of 2 numbers.
//(BONUS)
package DAY3_7OCT;
import java.util.Scanner;
public class PROG9 {
	
	static int gcd(int a, int b) {

	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }

	        return a;
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        int a = sc.nextInt();

	        System.out.print("Enter second number: ");
	        int b = sc.nextInt();

	        int result = gcd(a, b);

	        System.out.println("GCD = " + result);

	        
	    }
	}


