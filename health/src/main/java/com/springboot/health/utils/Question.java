package com.springboot.health.utils;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Question implements Serializable {
    String gender;
    String age;
    String systolic_blood;
    String diastolic_blood;
    String pulse;
    String lung_capacity;
    String grip;
    String height;
    String weight;
    String waist_length;
    String pca_1;
    String pca_2;
    String pca_3;
    String pca_4;
    String pca_5;
    String pca_6;
    String pca_7;
    String pca_8;
    String pca_9;
    String pca_10;

    public Question() {
    }

    public Question(String gender, String age, String systolic_blood, String diastolic_blood, String pulse, String lung_capacity, String grip, String height, String weight, String waist_length, String pca_1, String pca_2, String pca_3, String pca_4, String pca_5, String pca_6, String pca_7, String pca_8, String pca_9, String pca_10) {
        this.gender = gender;
        this.age = age;
        this.systolic_blood = systolic_blood;
        this.diastolic_blood = diastolic_blood;
        this.pulse = pulse;
        this.lung_capacity = lung_capacity;
        this.grip = grip;
        this.height = height;
        this.weight = weight;
        this.waist_length = waist_length;
        this.pca_1 = pca_1;
        this.pca_2 = pca_2;
        this.pca_3 = pca_3;
        this.pca_4 = pca_4;
        this.pca_5 = pca_5;
        this.pca_6 = pca_6;
        this.pca_7 = pca_7;
        this.pca_8 = pca_8;
        this.pca_9 = pca_9;
        this.pca_10 = pca_10;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSystolic_blood() {
        return systolic_blood;
    }

    public void setSystolic_blood(String systolic_blood) {
        this.systolic_blood = systolic_blood;
    }

    public String getDiastolic_blood() {
        return diastolic_blood;
    }

    public void setDiastolic_blood(String diastolic_blood) {
        this.diastolic_blood = diastolic_blood;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getLung_capacity() {
        return lung_capacity;
    }

    public void setLung_capacity(String lung_capacity) {
        this.lung_capacity = lung_capacity;
    }

    public String getGrip() {
        return grip;
    }

    public void setGrip(String grip) {
        this.grip = grip;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWaist_length() {
        return waist_length;
    }

    public void setWaist_length(String waist_length) {
        this.waist_length = waist_length;
    }

    public String getPca_1() {
        return pca_1;
    }

    public void setPca_1(String pca_1) {
        this.pca_1 = pca_1;
    }

    public String getPca_2() {
        return pca_2;
    }

    public void setPca_2(String pca_2) {
        this.pca_2 = pca_2;
    }

    public String getPca_3() {
        return pca_3;
    }

    public void setPca_3(String pca_3) {
        this.pca_3 = pca_3;
    }

    public String getPca_4() {
        return pca_4;
    }

    public void setPca_4(String pca_4) {
        this.pca_4 = pca_4;
    }

    public String getPca_5() {
        return pca_5;
    }

    public void setPca_5(String pca_5) {
        this.pca_5 = pca_5;
    }

    public String getPca_6() {
        return pca_6;
    }

    public void setPca_6(String pca_6) {
        this.pca_6 = pca_6;
    }

    public String getPca_7() {
        return pca_7;
    }

    public void setPca_7(String pca_7) {
        this.pca_7 = pca_7;
    }

    public String getPca_8() {
        return pca_8;
    }

    public void setPca_8(String pca_8) {
        this.pca_8 = pca_8;
    }

    public String getPca_9() {
        return pca_9;
    }

    public void setPca_9(String pca_9) {
        this.pca_9 = pca_9;
    }

    public String getPca_10() {
        return pca_10;
    }

    public void setPca_10(String pca_10) {
        this.pca_10 = pca_10;
    }
}
