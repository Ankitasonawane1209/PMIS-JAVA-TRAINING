import java.time.LocalDate;

public class localDate {
    public static void main(String[] args) {

            // Get today's date
            LocalDate now = LocalDate.now();

            // Create a custom date
            LocalDate customDate = LocalDate.of(2026, 12, 31);

            System.out.println("Custom date: " + customDate);

            // Extract day, month, and year
            int dayOfMonth = now.getDayOfMonth();
            int month = now.getMonthValue();
            int year = now.getYear();

            // Display the date details
            System.out.println("Day: " + dayOfMonth);
            System.out.println("Month: " + month);
            System.out.println("Year: " + year);
        }
    }

