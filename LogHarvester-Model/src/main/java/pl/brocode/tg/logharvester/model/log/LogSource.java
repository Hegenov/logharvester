package pl.brocode.tg.logharvester.model.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Source of log entry. Usually set as full name of class.
 *
 * @author G
 */
@Data
public class LogSource {

    /**
     * source name
     */
    @NonNull
    private String sourceName;
    
    private String sourceMethod;

}
