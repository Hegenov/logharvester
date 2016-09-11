package pl.brocode.tg.logharvester.model.log;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.logging.Logger;
import lombok.Data;
import lombok.NonNull;

/**
 *
 * @author G
 */
@Data
public class LogEntry implements Serializable {

    private static final Logger LOG = Logger.getLogger(LogEntry.class.getName());
    private static final long serialVersionUID = 7248055278780602729L;

    private final LocalTime entryTimestamp;
    private final LogLevel logLevel;
    private final LogSource logSource;
    @NonNull
    private String content;

    public String appendConent(final String additionContent) {
        if (content == null) {
            content = "";
        }
        content += additionContent;
        return content;
    }

}
