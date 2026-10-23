package DAY7_13OCT;
//
//public class Exception {
//	public static void main(String[] args) {
//		int a = 100;
//		int b =20;
//		
//		
//		try {
//			int rest = a/b;
//			System.out.println(rest);
//		}
//
//		catch(ArithmeticException e) {
//			System.out.println("you cannot divide by 0");
//		}
//			
//		
//	}
//}
//


//public class Exception{
//	public static void main(String[] args) {
//		try {
//			int[]numbers = {10,20,30};
//			System.out.println(numbers[5]);
//			int res =10/5;
//			System.out.println(res);
//		}
//		catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("invalid array index");
//		}catch(ArithmeticException e) {
//			System.out.println("cannot divide by 0");
//		}
//	}
//}

//finally
//class exception{
//	public static void main(String[] args) {
//		
//		try {
//			int res =10/5;
//			System.out.println(res);
//		}catch(ArithmeticException e) {
//			System.out.println("cannot divide by 0");
//		}
//		finally {
//			System.out.println("finally blocked excuted");
//		}
//	}
//}


//throw
//import java.util.Scanner;
//class Exception{
//	public static void main(String[] args) {
// 
//		System.out.println("enter the age");
//		Scanner sc = new Scanner(System.in);
//		int age = sc.nextInt();
//		
//		if(age<0) {
//			throw new IllegalArgumentException("Age cannot br negative");
//			
//			
//		}
//		System.out.println("Age:"+age);
//	}
//	
//}
//throws
import java.io.*;
import java.util.*;
class Exception{

	static void readFile() throws IOException{
		
  FileReader file = new FileReader("data.txt");
  System.out.println("file Opened");
}
	public static void main(String[] args) {
		try {
			readFile();
		}catch(IOException e) {
			System.out.println("could not find the file");
		}
	}

}
















