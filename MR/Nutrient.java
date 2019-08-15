package com.test.hadoop.nutrient;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class Nutrient implements Writable,DBWritable {
	private Integer id;
	private String year;
	private String type;
	private String name;
	private Double value;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Nutrient(Integer id, String year, String type, String name, Double value) {
		super();
		this.id = id;
		this.year = year;
		this.type = type;
		this.name = name;
		this.value = value;
	}
	public Nutrient(String year, String type, String name, Double value) {
		super();
		this.year = year;
		this.type = type;
		this.name = name;
		this.value = value;
	}
	public Nutrient() {
		super();
	}
	public void write(PreparedStatement pstmt) throws SQLException {
//		pstmt.setInt(1, this.id);
		pstmt.setString(1, this.year);
		pstmt.setString(2, this.type);
		pstmt.setString(3, this.name);
		pstmt.setDouble(4, this.value);
		
	}
	public void readFields(ResultSet rs) throws SQLException {
		this.id=rs.getInt(1);
		this.year=rs.getString(2);
		this.type=rs.getString(3);
		this.name=rs.getString(4);
		this.value=rs.getDouble(5);
		
	}
	public void write(DataOutput out) throws IOException {
		//out.writeInt(this.id);
		out.writeUTF(this.year);
		out.writeUTF(this.type);
		out.writeUTF(this.name);
		out.writeDouble(this.value);
		
	}
	public void readFields(DataInput in) throws IOException {
		//this.id=in.readInt();
		this.year=in.readUTF();
		this.type=in.readUTF();
		this.name=in.readUTF();
		this.value=in.readDouble();

		
	}
	

}
