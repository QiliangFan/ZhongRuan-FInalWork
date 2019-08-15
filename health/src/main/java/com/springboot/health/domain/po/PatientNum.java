package com.springboot.health.domain.po;

import javax.persistence.*;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/11 22:50
 */
@Entity
@Table(name = "patient_num")
public class PatientNum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private String year;

    private Double num;

    public PatientNum() {
    }

    public PatientNum(String type, String year, Double num) {
        this.type = type;
        this.year = year;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}
