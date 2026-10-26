//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.time.LocalDate;
import java.time.Month;

public class dateTime {

    public static void main(String[] args) {

        // Get today's date
        LocalDate now = LocalDate.now();

        System.out.println("Today's date is: " + now);

        // Get day, month, and year
        int dayOfMonth = now.getDayOfMonth();
        Month month = now.getMonth();
        int year = now.getYear();

        // Display the date details
        System.out.println("Day: " + dayOfMonth);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }
}