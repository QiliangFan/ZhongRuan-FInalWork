package com.springboot.health.biz;

import java.util.List;

public interface YoungDevelopmentService {
    List<Float> getHeightData(String area, String year, String gender);

    List<Float> getWeightData(String area, String year, String gender);
}
