package task2;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        int nextYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
        HolidaySchedule.printHolidaySchedule(nextYear);
    }
}

