//Two numbers are entered by the user, x and n. Write a function to find
//the value of one number raised to the power of another i.e. X^n
//𝑛

package DAY3_7OCT;

import java.util.Scanner;

public class PROG8 {

    // Function to calculate x raised to power n
    static int power(int x, int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * x;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int answer = power(x, n);

        System.out.println(x + " raised to the power " + n + " = " + answer);

        sc.close();
    }
}