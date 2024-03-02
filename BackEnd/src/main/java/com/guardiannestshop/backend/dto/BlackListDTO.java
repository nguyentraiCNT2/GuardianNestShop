package com.guardiannestshop.backend.dto;

import java.util.Date;


public class BlackListDTO {
    private Long balcklistid;
    private String blacklistname;
    private String userid;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getBlacklistdate() {
        return blacklistdate;
    }

    public void setBlacklistdate(Date blacklistdate) {
        this.blacklistdate = blacklistdate;
    }
}
