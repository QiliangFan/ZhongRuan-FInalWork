package com.springboot.health.domain.po;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="UserHealth")
public class UserHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private Double height;
    private Double weight;
    private Double waist;
    private Double vision;
    private Double heartRate;
    private String gender;
    private Integer userid;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getVision() {
        return vision;
    }

    public void setVision(Double vision) {
        this.vision = vision;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public UserHealth(int age, Double height, Double weight, Double waist, Double vision, Double heartRate, String gender, Integer userid, String time) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.vision = vision;
        this.heartRate = heartRate;
        this.gender = gender;
        this.userid = userid;
        this.time = time;
    }

    public UserHealth() {
    }

    @Override
    public String toString() {
        return "UserHealth{" +
                "id=" + id +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", waist=" + waist +
                ", vision=" + vision +
                ", heartRate=" + heartRate +
                ", gender='" + gender + '\'' +
                ", userid=" + userid +
                ", time='" + time + '\'' +
                '}';
    }
}
