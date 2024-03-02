package com.guardiannestshop.backend.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "LoveLists")
public class LoveListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lovelistid")
private Long lovelistid;
    @Column(name = "lovelistname",columnDefinition = "NVARCHAR(MAX)")
private String lovelistname;
    @Column(name = "listdate")
private Date listdate;
    @ManyToOne
    @JoinColumn(name = "userid")
private UserEntity userid;

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

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }
}
