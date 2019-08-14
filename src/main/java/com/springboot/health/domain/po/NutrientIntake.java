package com.springboot.health.domain.po;

import javax.persistence.*;

/**
 * @author zyr
 * @Date
 **/
@Entity
@Table(name="nutrient_intake")
public class NutrientIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String year;
    private String type;
    private String name;
    private Double value;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public NutrientIntake(String year, String type, String name, Double value) {
        this.year = year;
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public NutrientIntake() {
    }
}
