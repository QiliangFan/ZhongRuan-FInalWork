package com.test.hadoop.nutrient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;




public class MRNutrient {
	public static class NutrientMapper extends Mapper<LongWritable, Text, Text, Nutrient>
	{
		
    	IntWritable one=new IntWritable(1);
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Nutrient>.Context context)
				throws IOException, InterruptedException {
			String line=value.toString();
			line=line.replace(" ", "");
	        String[] words=line.split(",");
	        
	      //声明字段属性
		String name=words[0];
		String value1=words[1];
		String value2=words[2];
		String value3=words[3];
		String value4=words[4];
		String value5=words[5];
		String value6=words[6];
		String value7=words[7];
		String value8=words[8];
		String value9=words[9];
		Text nameText=new Text(name);
		if(value1.equals("")) value1="0";
		if(value2.equals("")) value2="0";
		if(value3.equals("")) value3="0";
		if(value4.equals("")) value4="0";
		if(value5.equals("")) value5="0";
		if(value6.equals("")) value6="0";
		if(value7.equals("")) value7="0";
		if(value8.equals("")) value8="0";
		if(value9.equals("")) value9="0";
		
		
		
		Nutrient nutrient1=new Nutrient("1992","合计",name,Double.valueOf(value1));
		Nutrient nutrient2=new Nutrient("2002","合计",name,Double.valueOf(value2));
		Nutrient nutrient3=new Nutrient("2012","合计",name,Double.valueOf(value3));
		Nutrient nutrient4=new Nutrient("1992","城市",name,Double.valueOf(value4));
		Nutrient nutrient5=new Nutrient("2002","城市",name,Double.valueOf(value5));
		Nutrient nutrient6=new Nutrient("2012","城市",name,Double.valueOf(value6));
		Nutrient nutrient7=new Nutrient("1992","农村",name,Double.valueOf(value7));
		Nutrient nutrient8=new Nutrient("2002","农村",name,Double.valueOf(value8));
		Nutrient nutrient9=new Nutrient("2012","农村",name,Double.valueOf(value9));
		
	       context.write(nameText, nutrient1);
	       context.write(nameText, nutrient2);
	       context.write(nameText, nutrient3);
	       context.write(nameText, nutrient4);
	       context.write(nameText, nutrient5);
	       context.write(nameText, nutrient6);
	       context.write(nameText, nutrient7);
	       context.write(nameText, nutrient8);
	       context.write(nameText, nutrient9);
		}
	}
	
	public static class NutrientReducer extends Reducer<Text, Nutrient,Nutrient, NullWritable>
	{

		@Override
		protected void reduce(Text nameText, Iterable<Nutrient> nutrients,
				Reducer<Text, Nutrient, Nutrient, NullWritable>.Context context) throws IOException, InterruptedException {
			
			for(Nutrient nutrient:nutrients)
			{
				
				context.write(nutrient, null);
				
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException
	 {   
		 
		 //0.初始化MR Job，指明MRJob 的控制程序所在的类
		 Configuration conf=new Configuration();
		 
		 //
		 
		 DBConfiguration.configureDB(conf, "com.mysql.cj.jdbc.Driver","jdbc:mysql://192.168.100.100:3306/hadoopdb?serverTimezone=UTC" ,
				 "newuser", "212zyrmj");
		 
		 
		 Job job=Job.getInstance(conf, "MRByDB");
		 job.setJarByClass(MRNutrient.class);
		 
		
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 //指定输入目录下的数据源文件的类型，默认是文本类型，可以不写
		 job.setInputFormatClass(TextInputFormat.class);
		 
		 
		 //2.指定Mapper--类信息+输出(中间)map的key,value信息
		 job.setMapperClass(NutrientMapper.class);
		 job.setMapOutputKeyClass(Text.class);
		 job.setMapOutputValueClass(Nutrient.class);
		 
		 //指明DB的具体输入和输出
		 
		 job.setOutputFormatClass(DBOutputFormat.class);
		 DBOutputFormat.setOutput(job, "nutrient_intake","year","type","name","value");
		 
//		 还可指定combinr\sort\shuffle\partition工作
		 
		
		 job.setNumReduceTasks(2);
		 job.setReducerClass(NutrientReducer.class);
		 job.setOutputKeyClass(Nutrient.class);
		 job.setOutputValueClass(NullWritable.class);;
		 
		
		//5.提交job
		 //job.submit();简单提交
		
		//提交，返回是否提交并执行结束成功，选择执行过程可视化
		boolean result=job.waitForCompletion(true);
		
		//适用于多个MR目录按顺序执行
	//	boolean success=job.isSuccessful();//返回是否执行成功
		 
		System.out.println(result? 0:-1);
	 }
	
	
	 }
	
	
	
	
	
	


