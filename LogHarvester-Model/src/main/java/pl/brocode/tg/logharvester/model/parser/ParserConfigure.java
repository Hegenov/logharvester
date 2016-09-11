package pl.brocode.tg.logharvester.model.parser;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;

/**
 *
 * @author G
 */
@Data
public class ParserConfigure {

    private DateTimeFormatter timestampFormat;
    private String timestampRegexp;
    private String levelRegexp;
    private String threadInfoRegexp;
    private String sourceInfoRegexp;
    private String messageRegexp;
    private final List<LogElement> entrySequesce;

    public ParserConfigure(LogElement... sequence) {
        entrySequesce = new ArrayList<>();
        entrySequesce.addAll(Arrays.asList(sequence));
    }

    public String getRegexpForElement(LogElement element) {
        switch (element) {
            case TIMESTAMP:
                return getTimestampRegexp();
            case LEVEL:
                return getLevelRegexp();
            case THREAD_INFO:
                return getThreadInfoRegexp();
            case SOURCE_NAME:
                return getSourceInfoRegexp();
            case MESSAGE:
                return getMessageRegexp();
            default:
                throw new AssertionError(element.name());

        }
    }

}
