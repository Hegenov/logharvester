package pl.brocode.tg.logharvester.parser;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.brocode.tg.logharvester.model.parser.LogElement;
import pl.brocode.tg.logharvester.model.parser.ParserConfigure;

/**
 *
 * @author G
 */
public class PatternGeneratorUtilNGTest {

    private static final Logger LOG = Logger.getLogger(PatternGeneratorUtilNGTest.class.getName());
    private ParserConfigure configure;

    @BeforeMethod
    public void setUpMethod() throws Exception {
        configure = new ParserConfigure(LogElement.TIMESTAMP, LogElement.SOURCE_NAME, LogElement.LEVEL, LogElement.MESSAGE);
        configure.setTimestampRegexp("(\\w{3})\\s\\d\\d,\\s\\d\\d\\d\\d\\s\\d\\:\\d\\d:\\d\\d\\s(PM|AM)");
        configure.setSourceInfoRegexp("([\\w.]{1,1000}\\s[\\w.]{1,1000})");
        configure.setLevelRegexp("\\w{1,10}:");
        configure.setThreadInfoRegexp("");
        configure.setMessageRegexp(".*");
    }

    @Test
    public void shouldMatchEntryLine() {
        //given
        String entryLog = "wrz 11, 2016 5:28:04 PM pl.PatternGeneratorUtilNGTest test INFO: with content x=2*342";
        Pattern result = PatternGeneratorUtil.generatePatternToCheckIfLineIsNewEntry(configure);
        //when
        boolean matches = result.matcher(entryLog).matches();
        //then
        assertTrue(matches);
    }

    @Test
    public void shouldGrabTimestamp() {
        //given
        String entryLog = "wrz 11, 2016 5:28:04 PM pl.PatternGeneratorUtilNGTest test INFO: with content x=2*342";
        String expectedMatch = "wrz 11, 2016 5:28:04 PM";
        Pattern result = PatternGeneratorUtil.generatePatterToGrapTimestamp(configure);
        Matcher matcher = result.matcher(entryLog);
        //when
        boolean find = matcher.find();
        //then
        assertTrue(find);
        String found = matcher.toMatchResult().group();
        assertEquals(found, expectedMatch);
    }

    @Test
    public void shouldGrabSourceName() {
        //given
        String entryLog = "wrz 11, 2016 5:28:04 PM pl.PatternGeneratorUtilNGTest test INFO: with content x=2*342";
        String expectedMatch = "pl.PatternGeneratorUtilNGTest test";
        Pattern result = PatternGeneratorUtil.generatePatterToGrapSourceName(configure);
        Matcher matcher = result.matcher(entryLog);
        //when
        boolean find = matcher.find();
        //then
        assertTrue(find);
        String found = matcher.toMatchResult().group();
        assertEquals(found, expectedMatch);
    }

    @Test
    public void shouldGrabLevel() {
        //given
        String entryLog = "wrz 11, 2016 5:28:04 PM pl.PatternGeneratorUtilNGTest test INFO: with content x=2*342";
        String expectedMatch = "INFO:";
        Pattern result = PatternGeneratorUtil.generatePatterToGrapLogLevel(configure);
        Matcher matcher = result.matcher(entryLog);
        //when
        boolean find = matcher.find();
        //then
        assertTrue(find);
        String found = matcher.toMatchResult().group();
        assertEquals(found, expectedMatch);
    }

    @Test
    public void shouldGrabMessage() {
        //given
        String entryLog = "wrz 11, 2016 5:28:04 PM pl.PatternGeneratorUtilNGTest test INFO: with content x=2*342";
        String expectedMatch = " with content x=2*342";
        Pattern result = PatternGeneratorUtil.generatePatterToGrapMessage(configure);
        Matcher matcher = result.matcher(entryLog);
        //when
        boolean find = matcher.find();
        //then
        assertTrue(find);
        String found = matcher.toMatchResult().group();
        assertEquals(found, expectedMatch);
    }

}
