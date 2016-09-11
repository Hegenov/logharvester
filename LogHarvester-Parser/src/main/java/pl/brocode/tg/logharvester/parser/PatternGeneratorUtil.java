package pl.brocode.tg.logharvester.parser;

import java.util.regex.Pattern;
import pl.brocode.tg.logharvester.model.parser.LogElement;
import pl.brocode.tg.logharvester.model.parser.ParserConfigure;

/**
 *
 * @author G
 */
public final class PatternGeneratorUtil {

    private PatternGeneratorUtil() {
    }

    public static Pattern generatePatternToCheckIfLineIsNewEntry(ParserConfigure configure) {
        StringBuilder builder = new StringBuilder("^");
        configure.getEntrySequesce().forEach(element -> {
            builder.append(configure.getRegexpForElement(element));
            builder.append(SEPARATOR);
        });
        return Pattern.compile(builder.toString());
    }

    public static Pattern generatePatterToGrapTimestamp(ParserConfigure configure) {
        LogElement searchedElement = LogElement.TIMESTAMP;
        return generateRegexpForElement(configure, searchedElement);
    }

    public static Pattern generatePatterToGrapSourceName(ParserConfigure configure) {
        LogElement searchedElement = LogElement.SOURCE_NAME;
        return generateRegexpForElement(configure, searchedElement);
    }

    public static Pattern generatePatterToGrapLogLevel(ParserConfigure configure) {
        LogElement searchedElement = LogElement.LEVEL;
        return generateRegexpForElement(configure, searchedElement);
    }

    public static Pattern generatePatterToGrapMessage(ParserConfigure configure) {
        LogElement searchedElement = LogElement.MESSAGE;
        return generateRegexpForElement(configure, searchedElement);
    }

    private static Pattern generateRegexpForElement(ParserConfigure configure, LogElement searchedElement) {
        StringBuilder builder = new StringBuilder("");
        for (LogElement element : configure.getEntrySequesce()) {
            if (element != searchedElement) {
                if (builder.length() == 0) {
                    builder.append("(?<=");
                }
                builder.append(configure.getRegexpForElement(element));
                builder.append(SEPARATOR);
            } else if (builder.length() != 0) {
                builder.append(")");
                builder.append(configure.getRegexpForElement(element));
                break;
            } else {
                builder.append(configure.getRegexpForElement(element));
                break;
            }

        }
        String stringPattern = builder.toString();
        return Pattern.compile(stringPattern);
    }
    private static final String SEPARATOR = "\\s{0,1}";
}
