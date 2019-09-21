package com.tamu.chicagocrime.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by arshi on 9/19/2019.
 */
@Entity
public class CrimeCode {

    @Id
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
