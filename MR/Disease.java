package com.test.hadoop.disease;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class Disease implements Writable,DBWritable {
	private Integer id;
	private String type;
	private String name;
	private Double num;
	private Double proportion;
	private Integer drange;
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
	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}
	public Double getProportion() {
		return proportion;
	}
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}
	public Integer getDrange() {
		return drange;
	}
	public void setDrange(Integer drange) {
		this.drange = drange;
	}
	
	public Disease(String type, String name, Double num, Double proportion, Integer drange) {
		super();
		this.type = type;
		this.name = name;
		this.num = num;
		this.proportion = proportion;
		this.drange = drange;
	}
	public Disease() {
		super();
	}
	public Disease(Integer id, String type, String name, Double num, Double proportion, Integer drange) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.num = num;
		this.proportion = proportion;
		this.drange = drange;
	}
	public void write(PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, this.type);
		pstmt.setString(2, this.name);
		pstmt.setDouble(3, this.num);
		pstmt.setDouble(4, this.proportion);
		pstmt.setInt(5,this.drange);
		
	}
	public void readFields(ResultSet rs) throws SQLException {
		this.id=rs.getInt(1);
		this.type=rs.getString(2);
		this.name=rs.getString(3);
		this.num=rs.getDouble(4);
		this.proportion=rs.getDouble(5);
		this.drange=rs.getInt(6);
		
	}
	public void write(DataOutput out) throws IOException {
		out.writeUTF(this.type);
		out.writeUTF(this.name);
		out.writeDouble(this.num);
		out.writeDouble(this.proportion);
		out.writeInt(this.drange);
		
	}
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.type=in.readUTF();
		this.name=in.readUTF();
		this.num=in.readDouble();
		this.proportion=in.readDouble();
		this.drange=in.readInt();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
