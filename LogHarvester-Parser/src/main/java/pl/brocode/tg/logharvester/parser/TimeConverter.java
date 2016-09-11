package pl.brocode.tg.logharvester.parser;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author G
 */
public class TimeConverter {

    public static LocalDateTime fromString(final String time, DateTimeFormatter formater) {
        return LocalDateTime.parse(time, formater);
    }

    public static void main(String[] args) {
        String time = "wrz 11, 2016 11:28:04 PM";
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a", new Locale("pl", "PL"));
        LocalDateTime fromString = fromString(time, pattern);
        System.out.println(fromString);
    }
}
