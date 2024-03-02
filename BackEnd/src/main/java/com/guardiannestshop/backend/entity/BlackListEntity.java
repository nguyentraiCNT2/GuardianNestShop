package com.guardiannestshop.backend.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BlackList")
public class BlackListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balcklistid")
    private Long balcklistid;
    @Column(name = "blacklistname")
    private String blacklistname;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userid;
    @Column(name = "blacklistdate")
    private Date blacklistdate;

    public Long getBalcklistid() {
        return balcklistid;
    }

    public void setBalcklistid(Long balcklistid) {
        this.balcklistid = balcklistid;
    }

    public String getBlacklistname() {
        return blacklistname;
    }

    public void setBlacklistname(String blacklistname) {
        this.blacklistname = blacklistname;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }

    public Date getBlacklistdate() {
        return blacklistdate;
    }

    public void setBlacklistdate(Date blacklistdate) {
        this.blacklistdate = blacklistdate;
    }
}
