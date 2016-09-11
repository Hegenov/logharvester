package pl.brocode.tg.logharvester.parser;

import pl.brocode.tg.logharvester.model.log.LogEntry;
import pl.brocode.tg.logharvester.model.parser.ParserConfigure;

/**
 *
 * @author G
 */
public class LineParser {

    private final ParserConfigure configure;

    public LineParser(ParserConfigure configure) {
        this.configure = configure;
    }

    public LogEntry parseLine(String line) {
        LogEntry entry = null;
        return entry;
    }

    public boolean isNewEntry(String line) {
        return false;
    }
}
