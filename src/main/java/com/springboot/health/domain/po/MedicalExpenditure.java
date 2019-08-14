package com.springboot.health.domain.po;

import javax.persistence.*;

/**
 * @author zyr
 * @Date
 **/
@Entity
@Table(name="medical_expenditure")
public class MedicalExpenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String subtype;
    private String location;
    private Double totalcost;
    private Double medicalcost;
    private Double proportion;

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

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }

    public Double getMedicalcost() {
        return medicalcost;
    }

    public void setMedicalcost(Double medicalcost) {
        this.medicalcost = medicalcost;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public MedicalExpenditure() {
    }

    public MedicalExpenditure(String type, String subtype, String location, Double totalcost, Double medicalcost, Double proportion) {
        this.type = type;
        this.subtype = subtype;
        this.location = location;
        this.totalcost = totalcost;
        this.medicalcost = medicalcost;
        this.proportion = proportion;
    }
}
