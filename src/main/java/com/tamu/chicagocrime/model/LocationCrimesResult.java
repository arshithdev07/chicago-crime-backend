package com.tamu.chicagocrime.model;

/**
 * Created by arshi on 11/12/2019.
 */
public class LocationCrimesResult {

    private String districtName;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    private long count;
}
