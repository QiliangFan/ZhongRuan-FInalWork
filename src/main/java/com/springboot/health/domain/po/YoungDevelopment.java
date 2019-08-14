package com.springboot.health.domain.po;

import javax.persistence.*;

@Entity
@Table(name = "YoungDevelopments")
public class YoungDevelopment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String year;
    private Float avgWeight;
    private Float avgHeight;
    private String gender;
    private String area;

    public YoungDevelopment() {
    }

    public YoungDevelopment(String year, Float avgWeight, Float avgHeight, String gender, String area) {
        this.year = year;
        this.avgWeight = avgWeight;
        this.avgHeight = avgHeight;
        this.gender = gender;
        this.area = area;
    }

    public YoungDevelopment(Integer age, String year, Float avgWeight, Float avgHeight, String gender, String area) {
        this.age = age;
        this.year = year;
        this.avgWeight = avgWeight;
        this.avgHeight = avgHeight;
        this.gender = gender;
        this.area = area;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Float getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(Float avgWeight) {
        this.avgWeight = avgWeight;
    }

    public Float getAvgHeight() {
        return avgHeight;
    }

    public void setAvgHeight(Float avgHeight) {
        this.avgHeight = avgHeight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "YoungDevelopment{" +
                "id=" + id +
                ", age=" + age +
                ", year='" + year + '\'' +
                ", avgWeight=" + avgWeight +
                ", avgHeight=" + avgHeight +
                ", gender='" + gender + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
