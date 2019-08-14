package com.springboot.health.domain.po;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String event;
    private String title;
    private Integer userid;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public History() {
    }

    public History(String event, String title, Integer userid, String time) {
        this.event = event;
        this.title = title;
        this.userid = userid;
        this.time = time;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", title='" + title + '\'' +
                ", userid=" + userid +
                ", time='" + time + '\'' +
                '}';
    }
}
