package task2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HolidaySchedule {

    public static void printHolidaySchedule(int year) {
        // Определяем фиксированные праздники
        String[] holidayNames = {
                "New Year's Day",
                "Good Friday",
                "Easter Monday",
                "Early May Bank Holiday",
                "Spring Bank Holiday",
                "Summer Bank Holiday",
                "Christmas Day",
                "Boxing Day"
        };

        // Устанавливаем фиксированные даты для ближайшего года
        String[] holidayDates = {
                "January 1",
                "April 7",
                "April 10",
                "May 1", // Первый понедельник мая
                "May 29", // Последний понедельник мая
                "August 28", // Последний понедельник августа
                "December 25",
                "December 26"
        };

        // Форматирование и печать графика праздников
        System.out.printf("%-30s%-15s%n", "Holiday", "Date in " + year);
        System.out.println("----------------------------------------------------");

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d", Locale.UK);

        for (int i = 0; i < holidayNames.length; i++) {
            Calendar holidayCalendar = Calendar.getInstance();
            String[] dateParts = holidayDates[i].split(" ");
            holidayCalendar.set(Calendar.YEAR, year);
            holidayCalendar.set(Calendar.MONTH, getMonthFromString(dateParts[0]));
            holidayCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateParts[1]));
            // Adjust for Monday holidays
            if (holidayNames[i].contains("Bank Holiday") && !holidayDates[i].equals("May 1")) {
                while (holidayCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                    holidayCalendar.add(Calendar.DAY_OF_MONTH, 1);
                }
            }
            String formattedDate = sdf.format(holidayCalendar.getTime());
            System.out.printf("%-30s%-15s%n", holidayNames[i], formattedDate + ", " + year);
        }
    }

    private static int getMonthFromString(String monthName) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM", Locale.UK);
            Date date = sdf.parse(monthName);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.MONTH);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

