package pl.brocode.tg.logharvester.model.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G
 */
public class ParserConfigure {
    
    private String timestampFormat;
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

    public void setTimestampFormat(String timestampFormat) {
        this.timestampFormat = timestampFormat;
    }

    public void setTimestampRegexp(String timestampRegexp) {
        this.timestampRegexp = timestampRegexp;
    }

    public void setLevelRegexp(String levelRegexp) {
        this.levelRegexp = levelRegexp;
    }

    public void setThreadInfoRegexp(String threadInfoRegexp) {
        this.threadInfoRegexp = threadInfoRegexp;
    }

    public void setSourceInfoRegexp(String sourceInfoRegexp) {
        this.sourceInfoRegexp = sourceInfoRegexp;
    }

    public void setMessageRegexp(String messageRegexp) {
        this.messageRegexp = messageRegexp;
    }
    
    
}
