package com.springboot.health.domain.po;

import javax.persistence.*;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:15
 */
@Entity
@Table(name = "medicalbedsofyear")
public class MedicalBedsOfYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String year;
    private String sum;
    private String city;
    private String countryside;

    public MedicalBedsOfYear() {
    }


    public MedicalBedsOfYear(String year, String sum, String city, String countryside) {
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
        return "MedicalBedsOfYear{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", sum='" + sum + '\'' +
                ", city='" + city + '\'' +
                ", countryside='" + countryside + '\'' +
                '}';
    }
}
