package com.tamu.chicagocrime.model;

/**
 * Created by arshi on 9/19/2019.
 */
public class Community {

    private Long communityNo;
    private String communityName;

    public Long getCommunityNo() {
        return communityNo;
    }

    public void setCommunityNo(Long communityNo) {
        this.communityNo = communityNo;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
