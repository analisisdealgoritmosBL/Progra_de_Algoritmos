package tenis.library;

import java.util.Date;

/**
 * Saves information about the date and time when an
 * algorithm was called to paint a design and the duration
 * of this process.
 * @author L. Antonio Hidalgo
 */
public class DateDuration {
    private Date _DateTime;
    private Long _Duration;

    public DateDuration(Date pDateTime, Long pDuration) {
        _DateTime = pDateTime;
        _Duration = pDuration;
    }

    public Date getDateTime() {
        return _DateTime;
    }

    public void setDateTime(Date pDateTime) {
        _DateTime = pDateTime;
    }

    public Long getDuration() {
        return _Duration;
    }

    public void setDuration(Long pDuration) {
        _Duration = pDuration;
    }
    
}
