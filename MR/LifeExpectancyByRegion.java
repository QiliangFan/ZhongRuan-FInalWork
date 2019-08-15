package com.test.hadoop.mr.db;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LifeExpectancyByRegion implements Writable, DBWritable {
//    private Integer id;
    private String city;
    private String type;//男 女 合计
    private Double expectedLife;
    private int year;



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getExpectedLife() {
        return expectedLife;
    }

    public void setExpectedLife(Double expectedLife) {
        this.expectedLife = expectedLife;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "LifeExpectancyByRegion{" +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", expectedLife=" + expectedLife +
                ", year=" + year +
                '}';
    }


    public LifeExpectancyByRegion(String city, String type, Double expectedLife, int year) {
        this.city = city;
        this.type = type;
        this.expectedLife = expectedLife;
        this.year = year;
    }

    public LifeExpectancyByRegion() {
    }

    @Override
    public void write(DataOutput out) throws IOException {
//        out.writeInt();
        out.writeUTF(this.city);
        out.writeUTF(this.type);
        out.writeDouble(this.expectedLife);
        out.writeInt(this.year);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
//        this.id = in.readInt();
        this.city = in.readUTF();
        this.type = in.readUTF();
        this.expectedLife = in.readDouble();
        this.year = in.readInt();
    }

    @Override
    public void write(PreparedStatement pstm) throws SQLException {
//        pstm.setInt(1,this.id);
        pstm.setString(1,this.city);
        pstm.setString(2,this.type);
        pstm.setDouble(3,this.expectedLife);
        pstm.setInt(4,this.year);
    }

    @Override
    public void readFields(ResultSet rs) throws SQLException {
//        this.id = rs.getInt(1);
        this.city = rs.getString(1);
        this.type = rs.getString(2);
        this.expectedLife = rs.getDouble(3);
        this.year = rs.getInt(4);
    }
}
