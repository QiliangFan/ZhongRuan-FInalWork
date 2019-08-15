package com.springboot.health.domain.po;

import javax.persistence.*;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:29
 */
@Entity
@Table(name = "medicalbedsofarea")
public class MedicalBedsOfArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String area;
    private String sum;
    private String city;
    private String countryside;

    public MedicalBedsOfArea() {
    }

    public MedicalBedsOfArea(String area, String sum, String city, String countryside) {
        this.area = area;
        this.sum = sum;
        this.city = city;
        this.countryside = countryside;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryside() {
        return countryside;
    }

    public void setCountryside(String countryside) {
        this.countryside = countryside;
    }

    @Override
    public String toString() {
        return "MedicalBedsOfArea{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", sum='" + sum + '\'' +
                ", city='" + city + '\'' +
                ", countryside='" + countryside + '\'' +
                '}';
    }
}
