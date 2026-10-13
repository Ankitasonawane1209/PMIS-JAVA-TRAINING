package DAY7_13OCT;



//public class Wrapper {
//
//	    public static void main(String[] args) {
//
//	        String input ="10,34,23,56,78";
//	        String[]parts=input.split(",");
//	        int total=0;
//	        
//	        for(String number:parts) {
//	        	total+=Integer.parseInt(number);
//	        }
//            System.out.println("total sum:"+total);
//	    }
//}


//public class Wrapper{
//	public static void main(String[] args) {
//		String text ="Pass@1234_mumbai";
//		int upper=0,lower=0,digits=0,special=0; 
//		
//		for(char ch : text.toCharArray()) {
//			if(Character.isUpperCase(ch)) {
//				upper++;
//			}else if(Character.isLowerCase(ch)) {
//				lower++;
//			}else if(Character.isDigit(ch)) {
//				digits++;
//			}else {
//				special++;
//			}
//		}
//		System.out.println("uppercase:"+upper);
//		System.out.println("Lowercase:"+lower);
//		System.out.println("Digits:"+digits);
//		System.out.println("Special:"+special);
//	}
//}
//
//import java.util.ArrayList;
//import java.util.List;
//public class Wrapper{
//	public static void main(String[] args) {
//	List<Integer>numbers=new ArrayList<>();
//	
//	numbers.add(12);
//	numbers.add(6);
//	numbers.add(77);
//	numbers.add(78);
//	numbers.add(55);
//	
//	List<Integer>evens =new ArrayList<>();
//	for(Integer num :numbers) {
//		if(num%2==0) {
//			evens.add(num);
//		}}
//	
//	
//	System.out.println("Even numbers: " + evens);
//	}
//
//	
//		}
//	

//import java.util.Scanner;
//
//public class Wrapper{
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		 System.out.println("enter the txt :");
//		String txt = sc.nextLine();
//		
//		txt=txt.toLowerCase();
//		int count=0;
//		
//		char[]chars=txt.toCharArray();
//		
//		for(char ch :chars) {
//			if(ch=='a' ||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
//				count++;
//			}
//		}
//		System.err.println("number of vowels:"+count);
//	}
//}
//import java.util.*;
//class Wrapper{
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter thr txt");
//		String txt = sc.nextLine();
//		
//		int count =0;
//		
//		char[] chars=txt.toCharArray();
//		for(char ch:chars) {
//			if(Character.isDigit(ch)) {
//				count++;
//			}
//		}
//
//        System.out.println("Number of digits: " + count);
//
//		
//	}
//}

import java.util.Scanner;
class Wrapper{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the txt");
		String txt = sc.nextLine();
		 int uppercase = 0;
	        int lowercase = 0;
	        int digits = 0;
	        int special = 0;

		char[]chars =txt.toCharArray();
		
		for(char ch:chars) {
			if (Character.isUpperCase(ch)) {
                uppercase++;
            }
            else if (Character.isLowerCase(ch)) {
                lowercase++;
            }
            else if (Character.isDigit(ch)) {
                digits++;
            }
            else if (!Character.isWhitespace(ch)) {
                special++;
            }
        }

        System.out.println("Uppercase letters: " + uppercase);
        System.out.println("Lowercase letters: " + lowercase);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + special);

       
    }
}

