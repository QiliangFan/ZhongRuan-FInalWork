package com.test.hadoop.expenditure;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class MedicalExpenditure implements Writable,DBWritable {
	private Integer id;
	private String type;
	private String subtype;
	private String location;
	private Double totalcost;
	private Double medicalcost;
	private Double proportion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}
	public Double getMedicalcost() {
		return medicalcost;
	}
	public void setMedicalcost(Double medicalcost) {
		this.medicalcost = medicalcost;
	}
	public Double getProportion() {
		return proportion;
	}
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}
	public MedicalExpenditure(Integer id, String type, String subtype, String location, Double totalcost,
			Double medicalcost, Double proportion) {
		super();
		this.id = id;
		this.type = type;
		this.subtype = subtype;
		this.location = location;
		this.totalcost = totalcost;
		this.medicalcost = medicalcost;
		this.proportion = proportion;
	}
	public MedicalExpenditure() {
		super();
	}
	public MedicalExpenditure(String type, String subtype, String location, Double totalcost, Double medicalcost,
			Double proportion) {
		super();
		this.type = type;
		this.subtype = subtype;
		this.location = location;
		this.totalcost = totalcost;
		this.medicalcost = medicalcost;
		this.proportion = proportion;
	}
	public void write(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub
		pstmt.setString(1, this.type);
		pstmt.setString(2, this.subtype);
		pstmt.setString(3, this.location);
		pstmt.setDouble(4, this.totalcost);
		pstmt.setDouble(5, this.medicalcost);
		pstmt.setDouble(6, this.proportion);
		
	}
	public void readFields(ResultSet rs) throws SQLException {
		this.id=rs.getInt(1);
		this.type=rs.getString(2);
		this.subtype=rs.getString(3);
		this.location=rs.getString(4);
		this.totalcost=rs.getDouble(5);
		this.medicalcost=rs.getDouble(6);
		this.proportion=rs.getDouble(7);
		
	}
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		
		out.writeUTF(this.type);
		out.writeUTF(this.subtype);
		out.writeUTF(this.location);
		out.writeDouble(this.totalcost);
		out.writeDouble(this.medicalcost);
		out.writeDouble(this.proportion);
		
	}
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		
		this.type=in.readUTF();
		this.subtype=in.readUTF();
		this.location=in.readUTF();
		this.totalcost=in.readDouble();
		this.medicalcost=in.readDouble();
		this.proportion=in.readDouble();
	}
	

}
