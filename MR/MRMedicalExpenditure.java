package com.test.hadoop.expenditure;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
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


public class MRMedicalExpenditure {
	
	public static class MedicalMapper extends Mapper<LongWritable, Text, Text, MedicalExpenditure>
	{

		@Override
		protected void map(LongWritable key, Text value,
				Mapper<LongWritable, Text, Text, MedicalExpenditure>.Context context)
				throws IOException, InterruptedException {
			String line=value.toString();
			line=line.replace(" ", "");
	        String[] words=line.split(",");
	        
	      //声明字段属性
		String subtype=words[0];
		//城市
		String total1=words[1];
		String medical1=words[2];
		String proportion1=words[3];
		//农村
		String total2=words[4];
		String medical2=words[5];
		String proportion2=words[6];
	
		Text typeText=new Text(subtype);
		String type;
		if(subtype.contains("20")) type="年份";
		else type="地区";
		MedicalExpenditure me1=
				new MedicalExpenditure(type,subtype,"城市",Double.valueOf(total1),Double.valueOf(medical1),Double.valueOf(proportion1));
		MedicalExpenditure me2=
				new MedicalExpenditure(type,subtype,"农村",Double.valueOf(total2),Double.valueOf(medical2),Double.valueOf(proportion2));
	       context.write(typeText, me1);
	       context.write(typeText, me2);
		}		
	}
	
	public static class MedicalReducer extends Reducer<Text, MedicalExpenditure, MedicalExpenditure, NullWritable>
	{

		@Override
		protected void reduce(Text arg0, Iterable<MedicalExpenditure> mes,
				Reducer<Text, MedicalExpenditure, MedicalExpenditure, NullWritable>.Context context)
				throws IOException, InterruptedException {
			for(MedicalExpenditure me:mes)
			{
				
				context.write(me, null);
				
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
		 job.setJarByClass(MRMedicalExpenditure.class);
		 
		
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 //指定输入目录下的数据源文件的类型，默认是文本类型，可以不写
		 job.setInputFormatClass(TextInputFormat.class);
		 
		 
		 //2.指定Mapper--类信息+输出(中间)map的key,value信息
		 job.setMapperClass(MedicalMapper.class);
		 job.setMapOutputKeyClass(Text.class);
		 job.setMapOutputValueClass(MedicalExpenditure.class);
		 
		 //指明DB的具体输入和输出
		 
		 job.setOutputFormatClass(DBOutputFormat.class);
		 DBOutputFormat.setOutput(job, "medical_expenditure","type","subtype","location","totalcost","medicalcost","proportion");
		 
//		 还可指定combinr\sort\shuffle\partition工作
		 
		
		 job.setNumReduceTasks(2);
		 job.setReducerClass(MedicalReducer.class);
		 job.setOutputKeyClass(MedicalExpenditure.class);
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
