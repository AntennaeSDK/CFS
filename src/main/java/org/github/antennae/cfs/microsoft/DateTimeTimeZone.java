package org.github.antennae.cfs.microsoft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by nsankaran on 6/30/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateTimeTimeZone {
    private Date dateTime;
    private String timeZone;

    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public String getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}