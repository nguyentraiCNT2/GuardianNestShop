package com.guardiannestshop.backend.dto;

import java.util.Date;

public class LoveListDTO {
private Long lovelistid;
private String lovelistname;
private Date listdate;
private String userid;

    public Long getLovelistid() {
        return lovelistid;
    }

    public void setLovelistid(Long lovelistid) {
        this.lovelistid = lovelistid;
    }

    public String getLovelistname() {
        return lovelistname;
    }

    public void setLovelistname(String lovelistname) {
        this.lovelistname = lovelistname;
    }

    public Date getListdate() {
        return listdate;
    }

    public void setListdate(Date listdate) {
        this.listdate = listdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
