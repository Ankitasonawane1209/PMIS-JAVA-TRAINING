//Write a program to enter the numbers till the user wants and at the end it
//should display the count of positive, negative and zeros entered. 
package DAY3_7OCT;

import java.util.Scanner;

public class PROG7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int positive = 0;
        int negative = 0;
        int zero = 0;

        System.out.print("Enter how many numbers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter number: ");
            int num = sc.nextInt();

            if (num > 0) {
                positive++;
            } 
            else if (num < 0) {
                negative++;
            } 
            else {
                zero++;
            }
        }

        System.out.println("Positive numbers = " + positive);
        System.out.println("Negative numbers = " + negative);
        System.out.println("Zeros = " + zero);

        
    }
}