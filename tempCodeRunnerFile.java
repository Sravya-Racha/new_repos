import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

public class AgeCalculator {
    public static void main(String[] args) {
        try {
            if (args.length == 3) {
                // Case 1: Birth date provided, calculate age to current date
                int birthYear = Integer.parseInt(args[0]);
                int birthMonth = Integer.parseInt(args[1]);
                int birthDay = Integer.parseInt(args[2]);

                // Try to create a LocalDate for the birth date
                LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
                LocalDate currentDate = LocalDate.now();

                Period period = Period.between(birthDate, currentDate);

                System.out.println("Your age is: "
                        + period.getYears() + " years, "
                        + period.getMonths() + " months, and "
                        + period.getDays() + " days.");

            } else if (args.length >= 4) {
                // Case 2: Age provided, calculate birth date from target date
                int years = Integer.parseInt(args[0]);
                int months = Integer.parseInt(args[1]);
                int days = Integer.parseInt(args[2]);
                int targetYear = Integer.parseInt(args[3]);
                int targetMonth = Integer.parseInt(args[4]);
                int targetDay = Integer.parseInt(args[5]);

                // Try to create a LocalDate for the target date
                LocalDate targetDate = LocalDate.of(targetYear, targetMonth, targetDay);
                LocalDate birthDate = targetDate.minusYears(years).minusMonths(months).minusDays(days);

                System.out.println("Your birth date would be: " + birthDate);

            } else {
                // Invalid input (not enough arguments)
                System.out.println("Invalid input. Please use one of the following formats:");
                System.out.println("To calculate age: java AgeCalculator <birthYear> <birthMonth> <birthDay>");
                System.out.println("To calculate birth date: java AgeCalculator <years> <months> <days> <targetYear> <targetMonth> <targetDay>");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers for year, month, and day.");
        } catch (DateTimeException e) {
            System.out.println("Invalid date input: " + e.getMessage());
        }
    }
}
