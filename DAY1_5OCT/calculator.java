package DAY1_5OCT;

import java.util.Scanner;

public class calculator {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter first number: ");
		float a =sc.nextFloat();
		System.out.println("Enter sec number: ");
		float b =sc.nextFloat();
		
		System.out.println("1.Add\n2.Sub\n3.multiply\n4.modulo");
		System.out.println("Enter your choice ");
		
		int choice =sc.nextInt();
		switch(choice){
		case 1:
			System.out.println(a+b);
			break;
		case 2:	
			System.out.println(a-b);
			break;
		case 3:	
			System.out.println(a*b);
			break;
		case 4:	
			System.out.println(a/b);
			break;
		default:
			System.out.println("invalid choice");
		
			
		}
		
		
		
	}

}
