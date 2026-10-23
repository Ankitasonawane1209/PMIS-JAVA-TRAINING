package DAY7_13OCT;
import java.util.*;
public class ExceptionProblem {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
  System.out.println("enter thr first integer");
  int a = sc.nextInt();
  System.out.println("enter thr first integer");
  int b = sc.nextInt();
  
  try {
           int result = a / b;
           System.out.println("Result: " + result);
       } catch (ArithmeticException e) {
           System.out.println("Error: Cannot divide by zero.");
       }
   }
  
}


