package com.springboot.health.domain.po;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bar {
    List<String> legendData=new ArrayList<>();
    List<String> xData=new ArrayList<>();

    @Override
    public String toString() {
        return "Bar{" +
                "legendData=" + legendData +
                ", xData=" + xData +
                '}';
    }

    public Bar(List<String[]> data){
        legendData.clear();
        xData.clear();
        for(String[] array:data){
            legendData.add(array[0]);
            xData.add(array[1]);
        }
    }

    public Bar() {
    }

    public Bar(List<String> legendData, List<String> xData) {
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
