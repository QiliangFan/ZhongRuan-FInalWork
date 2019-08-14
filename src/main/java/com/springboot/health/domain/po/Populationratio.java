package com.springboot.health.domain.po;

import javax.persistence.*;

@Entity
@Table(name="Populationratio")
public class Populationratio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    String year;

    @Column
    Float birthrate;

    @Column
    Float mortalityrate;

    @Column
    Float naturalgrowthrate;

    public Populationratio() {
    }

    public Populationratio(String year, Float birthrate, Float mortalityrate, Float naturalgrowthrate) {
        this.year = year;
        this.birthrate = birthrate;
        this.mortalityrate = mortalityrate;
        this.naturalgrowthrate = naturalgrowthrate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Float getBirthrate() {
        return birthrate;
    }

    public void setBirthrate(Float birthrate) {
        this.birthrate = birthrate;
    }

    public Float getMortalityrate() {
        return mortalityrate;
    }

    public void setMortalityrate(Float mortalityrate) {
        this.mortalityrate = mortalityrate;
    }

    public Float getNaturalgrowthrate() {
        return naturalgrowthrate;
    }

    public void setNaturalgrowthrate(Float naturalgrowthrate) {
        this.naturalgrowthrate = naturalgrowthrate;
    }
}
