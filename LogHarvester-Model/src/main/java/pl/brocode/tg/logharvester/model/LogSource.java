package pl.brocode.tg.logharvester.model;

/**
 * Source of log entry. Usually set as full name of class.
 *
 * @author G
 */
public class LogSource {

    /**
     * source name
     */
    private String sourceName;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

}
