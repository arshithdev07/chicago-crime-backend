package com.tamu.chicagocrime.model;

/**
 * Created by arshi on 11/13/2019.
 */
public class AreaCrimesResult {

    private String community;
    private long count;

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
