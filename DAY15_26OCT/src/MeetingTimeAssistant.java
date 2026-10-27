import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.util.Scanner;

public class MeetingTimeAssistant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        System.out.println("========== MEETING TIME ASSISTANT ==========");

        // Enter meeting details
        System.out.print("Enter meeting date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter meeting time (HH:mm): ");
        LocalTime time = LocalTime.parse(sc.nextLine());

        System.out.print("Enter meeting duration in minutes: ");
        long duration = Long.parseLong(sc.nextLine());

        // Get the system's default time zone
        ZoneId meetingZone = ZoneId.systemDefault();

        // Combine date, time, and time zone
        ZonedDateTime meetingStart =
                LocalDateTime.of(date, time).atZone(meetingZone);

        // Calculate meeting end time
        ZonedDateTime meetingEnd = meetingStart.plusMinutes(duration);

        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display meeting date and time");
            System.out.println("2. Display meeting end time");
            System.out.println("3. Display meeting time in another zone");
            System.out.println("4. Check whether the meeting is in the future");
            System.out.println("5. Exit");

            System.out.print("\nEnter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("\nMeeting starts at: "
                            + meetingStart.format(formatter));
                    break;

                case 2:
                    System.out.println("\nMeeting starts at: "
                            + meetingStart.format(formatter));

                    System.out.println("Meeting ends at:   "
                            + meetingEnd.format(formatter));
                    break;

                case 3:
                    System.out.print(
                            "Enter target time zone (e.g., America/New_York): ");

                    String zoneName = sc.nextLine();

                    try {
                        ZoneId targetZone = ZoneId.of(zoneName);

                        ZonedDateTime convertedTime =
                                meetingStart.withZoneSameInstant(targetZone);

                        System.out.println("\nOriginal meeting time: "
                                + meetingStart.format(formatter)
                                + " (" + meetingZone + ")");

                        System.out.println("Meeting time in "
                                + targetZone + ": "
                                + convertedTime.format(formatter));

                    } catch (DateTimeException e) {
                        System.out.println("Invalid time zone! "
                                + "Please enter a valid zone ID.");
                    }

                    break;

                case 4:
                    ZonedDateTime currentTime =
                            ZonedDateTime.now(meetingZone);

                    if (meetingStart.isAfter(currentTime)) {
                        System.out.println("\nThe meeting is in the future.");
                    } else {
                        System.out.println(
                                "\nThe meeting is not in the future.");
                    }

                    break;

                case 5:
                    System.out.println("Thank you for using "
                            + "Meeting Time Assistant!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}