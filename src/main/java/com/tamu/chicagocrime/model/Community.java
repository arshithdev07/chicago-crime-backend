package com.tamu.chicagocrime.model;

import javax.persistence.*;

/**
 * Created by arshi on 9/19/2019.
 */
@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CommunitySeq")
    @SequenceGenerator(name = "CommunitySeq", sequenceName = "Community_SEQ" )
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
