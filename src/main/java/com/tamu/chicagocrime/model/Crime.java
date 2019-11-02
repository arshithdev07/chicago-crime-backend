package com.tamu.chicagocrime.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by arshi on 9/17/2019.
 */
@Document(collection = "crimes")
public class Crime {

    @Id
    private String id;
    private Long crimeId;
    private String caseNumber;
    private Date crimeDate;
    private String block;

    private CrimeCode crimeCode;
    private String locationDescription;
    private Boolean arrest;
    private Boolean domestic;
    private String beat;

    private District district;

    private Community communityArea;
    private String FBICode;

    private Date creationTimestamp;

    private Date updatedTimestamp;

    public Long getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Long crimeId) {
        this.crimeId = crimeId;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Date getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(Date crimeDate) {
        this.crimeDate = crimeDate;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Boolean getArrest() {
        return arrest;
    }

    public void setArrest(Boolean arrest) {
        this.arrest = arrest;
    }

    public Boolean getDomestic() {
        return domestic;
    }

    public void setDomestic(Boolean domestic) {
        this.domestic = domestic;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Community getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(Community communityArea) {
        this.communityArea = communityArea;
    }

    public String getFBICode() {
        return FBICode;
    }

    public void setFBICode(String FBICode) {
        this.FBICode = FBICode;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public CrimeCode getCrimeCode() {
        return crimeCode;
    }

    public void setCrimeCode(CrimeCode crimeCode) {
        this.crimeCode = crimeCode;
    }
}
