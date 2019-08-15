package com.test.hadoop.m2.rate;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class PopulationRatio implements Writable, DBWritable, WritableComparable<PopulationRatio>{

//	private Integer id;
	private String year;
	private Float birthRate;
	private Float mortalityRate;
	private Float naturalGrowthRate;
	
	public PopulationRatio() {
		super();
	}

	public PopulationRatio(String year, Float birthRate, Float mortalityRate, Float naturalGrowthRate) {
		super();
		this.year = year;
		this.birthRate = birthRate;
		this.mortalityRate = mortalityRate;
		this.naturalGrowthRate = naturalGrowthRate;
	}


//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Float getbirthRate() {
		return birthRate;
	}

	public void setbirthRate(Float birthRate) {
		this.birthRate = birthRate;
	}

	public Float getMortalityRate() {
		return mortalityRate;
	}

	public void setMortalityRate(Float mortalityRate) {
		this.mortalityRate = mortalityRate;
	}

	public Float getNaturalGrowthRate() {
		return naturalGrowthRate;
	}

	public void setNaturalGrowthRate(Float naturalGrowthRate) {
		this.naturalGrowthRate = naturalGrowthRate;
	}

	@Override
	public int compareTo(PopulationRatio o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void write(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub
//		pstmt.setInt(1,this.id);
		pstmt.setString(1, this.year);
		pstmt.setFloat(2, this.birthRate);
		pstmt.setFloat(3, this.mortalityRate);
		pstmt.setFloat(4, this.naturalGrowthRate);
	}

	@Override
	public void readFields(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		this.year = rs.getString(1);
		this.birthRate=rs.getFloat(2);
		this.mortalityRate=rs.getFloat(3);
		this.naturalGrowthRate=rs.getFloat(4);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(this.year);
		out.writeFloat(this.birthRate);
		out.writeFloat(this.mortalityRate);
		out.writeFloat(this.naturalGrowthRate);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.year=in.readUTF();
		this.birthRate=in.readFloat();
		this.mortalityRate=in.readFloat();
		this.naturalGrowthRate=in.readFloat();
	}
	
}
