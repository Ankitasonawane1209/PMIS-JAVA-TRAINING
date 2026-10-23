//Write a function that takes in age as input and returns if that person is eligible
//to vote or not. A person of age > 18 is eligible to vote.
package DAY3_7OCT;

import java.util.Scanner;

public class PROG5 {

    public static boolean checkVote(int age) {
        if (age > 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the age:");
        int age = sc.nextInt();

        if (checkVote(age)) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }

        
    }
}