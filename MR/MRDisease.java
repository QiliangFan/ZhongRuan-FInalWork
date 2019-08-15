package com.test.hadoop.disease;

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





public class MRDisease {
	
	public static class DiseaseMapper extends Mapper<LongWritable, Text, Text, Disease>
	{

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Disease>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub

			String line=value.toString();
			line=line.replace(" ", "");
	        String[] words=line.split(",");
	        
	      //声明字段属性
		String name=words[0];
		String death1=words[1];
		String proportion1=words[2];
		String drange1=words[3];
		String death2=words[4];
		String proportion2=words[5];
		String drange2=words[6];
		String death3=words[7];
		String proportion3=words[8];
		String drange3=words[9];
		Text nameText=new Text(name);
		if(death1.equals("")) death1="0";
		if(proportion1.equals("")) proportion1="0";
		if(death2.equals("")) death2="0";
		if(proportion2.equals("")) proportion2="0";
		if(death3.equals("")) death3="0";
		if(proportion3.equals("")) proportion3="0";	
		Disease disease1=new Disease("合计",name,Double.valueOf(death1),
				Double.valueOf(proportion1),Integer.valueOf(drange1));
		Disease disease2=new Disease("男",name,Double.valueOf(death2),
				Double.valueOf(proportion2),Integer.valueOf(drange2));
		Disease disease3=new Disease("女",name,Double.valueOf(death3),
				Double.valueOf(proportion3),Integer.valueOf(drange3));
		
	       context.write(nameText, disease1);
	       context.write(nameText, disease2);
	       context.write(nameText, disease3);
	     
		}
	}
		
		public static class DiseaseReducer extends Reducer<Text, Disease, Disease, NullWritable>
		{

			@Override
			protected void reduce(Text nameText, Iterable<Disease> diseases,
					Reducer<Text, Disease, Disease, NullWritable>.Context context)
					throws IOException, InterruptedException {
				// TODO Auto-generated method stub
				for(Disease disease:diseases)
				{
					
					context.write(disease, null);
					
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
			 job.setJarByClass(MRDisease.class);
			 
			
			 FileInputFormat.addInputPath(job, new Path(args[0]));
			 //指定输入目录下的数据源文件的类型，默认是文本类型，可以不写
			 job.setInputFormatClass(TextInputFormat.class);
			 
			 
			 //2.指定Mapper--类信息+输出(中间)map的key,value信息
			 job.setMapperClass(DiseaseMapper.class);
			 job.setMapOutputKeyClass(Text.class);
			 job.setMapOutputValueClass(Disease.class);
			 
			 //指明DB的具体输入和输出
			 
			 job.setOutputFormatClass(DBOutputFormat.class);
			 DBOutputFormat.setOutput(job, "disease_causes","type","name","num","proportion","drange");
			 
//			 还可指定combinr\sort\shuffle\partition工作
			 
			
			 job.setNumReduceTasks(2);
			 job.setReducerClass(DiseaseReducer.class);
			 job.setOutputKeyClass(Disease.class);
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
		
		
		
	


