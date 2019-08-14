package com.springboot.health.domain.po;

import java.util.ArrayList;
import java.util.List;

public class Pie {
    List<String> legendData = new ArrayList<>();
    List<String> xData = new ArrayList<>();

    @Override
    public String toString() {
        return "Pie{" +
                "legendData=" + legendData +
                ", xData=" + xData +
                '}';
    }

    public Pie(List<String[]> data){
        legendData.clear();
        xData.clear();
        for(String[] array:data){
            legendData.add(array[0]);
            xData.add(array[1]);
        }
    }

    public Pie() {
    }

    public Pie(List<String> legendData, List<String> xData) {
        this.legendData = legendData;
        this.xData = xData;
    }

    public List<String> getLegendData() {
        return legendData;
    }

    public void setLegendData(List<String> legendData) {
        this.legendData = legendData;
    }

    public List<String> getxData() {
        return xData;
    }

    public void setxData(List<String> xData) {
        this.xData = xData;
    }
}
