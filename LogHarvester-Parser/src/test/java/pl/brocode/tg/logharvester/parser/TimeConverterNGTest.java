package pl.brocode.tg.logharvester.parser;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author G
 */
public class TimeConverterNGTest {

    /**
     * Test of fromString method, of class TimeConverter.
     */
    @Test
    public void shouldParseDate() {
        String time = "wrz 11, 2016 5:28:04 PM";
        String format = "MMM dd, yyyy h:mm:ss a";
        Locale locale = new Locale("pl");
        LocalDateTime result = TimeConverter.fromString(time, DateTimeFormatter.ofPattern(format, locale));

        assertNotNull(result);
        assertEquals(result.getMonth(), Month.SEPTEMBER);
        assertEquals(result.getDayOfMonth(), 11);
        assertEquals(result.getYear(), 2016);
        assertEquals(result.getHour(), 17);
        assertEquals(result.getMinute(), 28);
        assertEquals(result.getSecond(), 4);

    }

}
