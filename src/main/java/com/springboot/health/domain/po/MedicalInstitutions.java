package com.springboot.health.domain.po;

import javax.persistence.*;

@Entity
@Table(name="medicalinstitutions")
public class MedicalInstitutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String year;

    public MedicalInstitutions(String year, String comprehensive, String chinesemedicine, String specialist, String primary, String community, String township, String village, String outpatient, String profession, String diseaseprevention, String specialiststation, String womenandchild, String healthauthority) {
        this.year = year;
        this.comprehensive = comprehensive;
        this.chinesemedicine = chinesemedicine;
        this.specialist = specialist;
        this.primary = primary;
        this.community = community;
        this.township = township;
        this.village = village;
        this.outpatient = outpatient;
        this.profession = profession;
        this.diseaseprevention = diseaseprevention;
        this.specialiststation = specialiststation;
        this.womenandchild = womenandchild;
        this.healthauthority = healthauthority;
    }

    public String getYear() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
            sb.append(this.year.charAt(i));
        }
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column
    String comprehensive;

    @Column
    String chinesemedicine;

    @Column
    String specialist;

    @Column
    String primary;

    @Column
    String community;

    @Column
    String township;

    @Column
    String village;

    @Column
    String outpatient;

    @Column
    String profession;

    @Column
    String diseaseprevention;

    @Column
    String specialiststation;

    public MedicalInstitutions() {
    }

    public MedicalInstitutions(String comprehensive, String chinesemedicine, String specialist, String primary, String community, String township, String village, String outpatient, String profession, String diseaseprevention, String specialiststation, String womenandchild, String healthauthority) {
        this.comprehensive = comprehensive;
        this.chinesemedicine = chinesemedicine;
        this.specialist = specialist;
        this.primary = primary;
        this.community = community;
        this.township = township;
        this.village = village;
        this.outpatient = outpatient;
        this.profession = profession;
        this.diseaseprevention = diseaseprevention;
        this.specialiststation = specialiststation;
        this.womenandchild = womenandchild;
        this.healthauthority = healthauthority;
    }

    @Column
    String womenandchild;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComprehensive() {
        return comprehensive;
    }

    public void setComprehensive(String comprehensive) {
        this.comprehensive = comprehensive;
    }

    public String getChinesemedicine() {
        return chinesemedicine;
    }

    public void setChinesemedicine(String chinesemedicine) {
        this.chinesemedicine = chinesemedicine;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(String outpatient) {
        this.outpatient = outpatient;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDiseaseprevention() {
        return diseaseprevention;
    }

    public void setDiseaseprevention(String diseaseprevention) {
        this.diseaseprevention = diseaseprevention;
    }

    public String getSpecialiststation() {
        return specialiststation;
    }

    public void setSpecialiststation(String specialiststation) {
        this.specialiststation = specialiststation;
    }

    public String getWomenandchild() {
        return womenandchild;
    }

    public void setWomenandchild(String womenandchild) {
        this.womenandchild = womenandchild;
    }

    public String getHealthauthority() {
        return healthauthority;
    }

    public void setHealthauthority(String healthauthority) {
        this.healthauthority = healthauthority;
    }

    @Column
    String healthauthority;
}
