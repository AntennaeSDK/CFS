package org.github.antennae.cfs.microsoft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by nsankaran on 6/27/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailAddress {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}