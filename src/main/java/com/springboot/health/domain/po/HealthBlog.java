package com.springboot.health.domain.po;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "HealthBlog")
public class HealthBlog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private int goodNum;
    private int badNum;
    private int numOfPeople;
    private int userId;
    private int imgId;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public int getBadNum() {
        return badNum;
    }

    public void setBadNum(int badNum) {
        this.badNum = badNum;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public HealthBlog(String title, String content, int goodNum, int badNum, int numOfPeople, int userId, int imgId, Date time) {
        this.title = title;
        this.content = content;
        this.goodNum = goodNum;
        this.badNum = badNum;
        this.numOfPeople = numOfPeople;
        this.userId = userId;
        this.imgId = imgId;
        this.time = time;
    }

    public HealthBlog() {
    }

    @Override
    public String toString() {
        return "healthBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", goodNum=" + goodNum +
                ", badNum=" + badNum +
                ", numOfPeople=" + numOfPeople +
                ", userId=" + userId +
                ", imgId=" + imgId +
                ", time=" + time +
                '}';
    }
}
