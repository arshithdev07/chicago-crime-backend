package com.tamu.chicagocrime.model;

import javax.persistence.*;

/**
 * Created by arshi on 9/19/2019.
 */
@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DistrictSeq")
    @SequenceGenerator(name = "DistrictSeq", sequenceName = "District_SEQ" )
    private Long districtNo;
    private String districtName;

    public Long getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Long districtNo) {
        this.districtNo = districtNo;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
