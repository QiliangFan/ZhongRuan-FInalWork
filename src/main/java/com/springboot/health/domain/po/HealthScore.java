package com.springboot.health.domain.po;

public class HealthScore {
    private Double height;
    private Double weight;
    private Double waist;
    private Double vision;
    private Double heartRate;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getVision() {
        return vision;
    }

    public void setVision(Double vision) {
        this.vision = vision;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }

    public HealthScore(Double height, Double weight, Double waist, Double vision, Double heartRate) {
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.vision = vision;
        this.heartRate = heartRate;
    }

    public HealthScore() {
    }

    @Override
    public String toString() {
        return "HealthScore{" +
                ", height=" + height +
                ", weight=" + weight +
                ", waist=" + waist +
                ", vision=" + vision +
                ", heartRate=" + heartRate +
                '}';
    }
}
