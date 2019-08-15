package com.springboot.health.domain.po;

import javax.persistence.*;

@Entity
@Table(name="lifeexpectancybyregion")
public class ExpectedLife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="city")
    String city;

    @Column(name="type")
    String type;

    @Column(name = "expectedlife")
    Double expectedlife;

    @Column(name="year")
    Integer year;

    public ExpectedLife() {
    }

    public ExpectedLife(String city, String type, Double expectedlife, Integer year) {
        this.city = city;
        this.type = type;
        this.expectedlife = expectedlife;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getExpectedlife() {
        return expectedlife;
    }

    public void setExpectedlife(Double expectedlife) {
        this.expectedlife = expectedlife;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
