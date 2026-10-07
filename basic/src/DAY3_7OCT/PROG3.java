//Write a function which takes in 2 numbers and returns the greater of those
//two.
package DAY3_7OCT;
import java.util.Scanner;
public class PROG3 {
	
	static int greater(int a, int b) {
	        if (a > b) {
	            return a;
	        } else {
	            return b;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        int a = sc.nextInt();

	        System.out.print("Enter second number: ");
	        int b = sc.nextInt();

	        System.out.println("Greater number = " + greater(a, b));
	    }
	}
	

