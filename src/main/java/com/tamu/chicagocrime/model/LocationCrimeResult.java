package com.tamu.chicagocrime.model;

/**
 * Created by arshi on 11/17/2019.
 */
public class LocationCrimeResult {

    private String crime;
    private long count;

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
