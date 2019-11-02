package com.tamu.chicagocrime.model;

/**
 * Created by arshi on 9/19/2019.
 */
public class CrimeCode {

    private String iucr;
    private String primaryDescription;
    private String secondaryDescription;

    public String getIucr() {
        return iucr;
    }

    public void setIucr(String iucr) {
        this.iucr = iucr;
    }

    public String getPrimaryDescription() {
        return primaryDescription;
    }

    public void setPrimaryDescription(String primaryDescription) {
        this.primaryDescription = primaryDescription;
    }

    public String getSecondaryDescription() {
        return secondaryDescription;
    }

    public void setSecondaryDescription(String secondaryDescription) {
        this.secondaryDescription = secondaryDescription;
    }
}
