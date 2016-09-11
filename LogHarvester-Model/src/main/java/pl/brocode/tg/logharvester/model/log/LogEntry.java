package pl.brocode.tg.logharvester.model.log;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.logging.Logger;

/**
 *
 * @author G
 */
public class LogEntry implements Serializable {

    private static final Logger LOG = Logger.getLogger(LogEntry.class.getName());
    private static final long serialVersionUID = 7248055278780602729L;

    private final LocalTime entryTimestamp;
    private final LogLevel logLevel;
    private final LogSource logSource;
    private String content;

    public LogEntry(LocalTime entryTimestamp, LogLevel logLevel, LogSource logSource, String content) {
        this.entryTimestamp = entryTimestamp;
        this.logLevel = logLevel;
        this.logSource = logSource;
        this.content = content;
    }

    public LocalTime getEntryTimestamp() {
        return entryTimestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LogSource getLogSource() {
        return logSource;
    }

    public String getContent() {
        if (content == null) {
            return content;
        }
        return content;
    }

    public String appendConent(final String additionContent) {
        if (content == null) {
            content = "";
        }
        content += additionContent;
        return content;
    }

}
