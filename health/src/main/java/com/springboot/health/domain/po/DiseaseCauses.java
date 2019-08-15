package com.springboot.health.domain.po;

import javax.persistence.*;

/**
 * @author zyr
 * @Date
 **/
@Entity
@Table(name="disease_causes")
public class DiseaseCauses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String name;
    private Double num;
    private Double proportion;
    private Integer drange;

    public DiseaseCauses() {
    }

    public DiseaseCauses(String type, String name, Double num, Double proportion, Integer drange) {
        this.type = type;
        this.name = name;
        this.num = num;
        this.proportion = proportion;
        this.drange = drange;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public Integer getDrange() {
        return drange;
    }

    public void setDrange(Integer drange) {
        this.drange = drange;
    }
}
