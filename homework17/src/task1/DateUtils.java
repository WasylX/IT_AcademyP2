package task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) {
        System.out.println("JANUARY 1 2000 => " + isDateOdd("JANUARY 1 2000")); //  true
        System.out.println("JANUARY 2 2020 => " + isDateOdd("JANUARY 2 2020")); //  false
    }

    public static boolean isDateOdd(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy");
        try {
            Date parsedDate = formatter.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsedDate);
            int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
            return dayOfYear % 2 != 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

}

