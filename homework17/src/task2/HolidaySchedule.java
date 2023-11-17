package task2;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HolidaySchedule {
    private static LocalDate calculateLastMonday(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1).withDayOfMonth(LocalDate.of(year, month, 1).lengthOfMonth());
        while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
            date = date.minusDays(1);
        }
        return date;
    }

    public static void printHolidaySchedule(int year) {
        List<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday("New Year's Day", LocalDate.of(year, 1, 1)));
        holidays.add(new Holiday("Good Friday", LocalDate.of(year, 4, 7)));
        holidays.add(new Holiday("Easter Monday", LocalDate.of(year, 4, 10)));
        holidays.add(new Holiday("Early May Bank Holiday", calculateLastMonday(year, 5)));
        holidays.add(new Holiday("Spring Bank Holiday", calculateLastMonday(year, 5)));
        holidays.add(new Holiday("Summer Bank Holiday", calculateLastMonday(year, 8)));
        holidays.add(new Holiday("Christmas Day", LocalDate.of(year, 12, 25)));
        holidays.add(new Holiday("Boxing Day", LocalDate.of(year, 12, 26)));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d", Locale.UK);
        System.out.printf("%-30s%-15s%n", "Holiday", "Date in " + year);
        System.out.println("----------------------------------------------------");

        for (Holiday holiday : holidays) {
            String formattedDate = holiday.getDate().format(formatter);
            System.out.printf("%-30s%-15s%n", holiday.getName(), formattedDate + ", " + year);
        }
    }
}

