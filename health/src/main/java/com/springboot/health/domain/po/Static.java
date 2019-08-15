package com.springboot.health.domain.po;

/**
 * @author zyr
 * @Date
 **/
public class Static {
    private String type;
    private Integer num;

    public Static(String type, Integer num) {
        this.type = type;
        this.num = num;
    }

    public Static() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
