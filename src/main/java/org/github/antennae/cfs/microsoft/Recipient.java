package org.github.antennae.cfs.microsoft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by nsankaran on 6/27/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipient {
    private EmailAddress emailAddress;

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}