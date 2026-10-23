package DAY1_5OCT;

import java.util.Scanner;

public class largestnumber {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number");
		int num1 =sc.nextInt();
		
		System.out.println("Enter the number");
		int num2 =sc.nextInt();
		
		System.out.println("Enter the number");
		int num3 =sc.nextInt();
		
		if(num1>num2 && num1>3) {
			System.out.println("num1 is greater");
		}
		else if(num2>num1 && num2>num3) {
			System.out.println("num2 is greater");
			
		}
		else
			
			System.out.println("num3 is greater");
		}
		
	}
