package com.springboot.health.domain.po;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BlogImg")
public class BlogImg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BlogImg(String img) {
        this.img = img;
    }

    public BlogImg() {
    }

    @Override
    public String toString() {
        return "blogImg{" +
                "id=" + id +
                ", img='" + img + '\'' +
                '}';
    }
}
