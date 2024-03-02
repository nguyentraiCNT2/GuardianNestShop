package com.guardiannestshop.backend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "WebNews")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsid")
    private Long newsid;
    @Column(name = "content")
    private String content;
    @Column(name = "newsdate")
    private Date newsdate;
    @Column(name = "title")
    private String title;
    @Column(name = "thumnail")
    private String thumnail;

    public Long getNewsid() {
        return newsid;
    }

    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(Date newsdate) {
        this.newsdate = newsdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }
}
