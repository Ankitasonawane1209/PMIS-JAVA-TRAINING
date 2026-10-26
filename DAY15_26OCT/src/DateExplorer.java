
import java.util.Scanner;
import java.time.LocalDate;

public class DateExplorer {

    // Display month
    public static void displayMonth(LocalDate date) {
        System.out.println("Month: " + date.getMonth());
    }

    // Display year
    public static void displayYear(LocalDate date) {
        System.out.println("Year: " + date.getYear());
    }

    // Display day of the week
    public static void displayDayOfWeek(LocalDate date) {
        System.out.println("Day of the week: " + date.getDayOfWeek());
    }

    // Check leap year
    public static void checkLeapYear(LocalDate date) {

        if (date.isLeapYear()) {
            System.out.println(date.getYear() + " is a leap year.");
        } else {
            System.out.println(date.getYear() + " is not a leap year.");
        }
    }

    // Look back by a specified number of months
    public static void lookBackMonths(LocalDate date, Scanner sc) {

        System.out.print("Enter the number of months to look back: ");
        int months = sc.nextInt();

        if (months < 0) {
            System.out.println("Please enter a positive number.");
        } else {
            LocalDate pastDate = date.minusMonths(months);
            System.out.println("Past date: " + pastDate);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get date from user
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        LocalDate date;

        try {
            date = LocalDate.parse(input);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid date! Please use yyyy-MM-dd format.");
            sc.close();
            return;
        }

        int choice;

        // Repeat menu until the user chooses Exit
        do {
            System.out.println("\n===== DATE EXPLORER =====");
            System.out.println("1. Display Month");
            System.out.println("2. Display Year");
            System.out.println("3. Display Day of the Week");
            System.out.println("4. Check Leap Year");
            System.out.println("5. Look Back by Months");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayMonth(date);
                    break;

                case 2:
                    displayYear(date);
                    break;

                case 3:
                    displayDayOfWeek(date);
                    break;

                case 4:
                    checkLeapYear(date);
                    break;

                case 5:
                    lookBackMonths(date, sc);
                    break;

                case 6:
                    System.out.println("Exiting Date Explorer. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-6.");
            }

        } while (choice != 6);

        sc.close();
    }
}