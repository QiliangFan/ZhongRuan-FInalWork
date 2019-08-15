package com.test.hadoop.m2.rate;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;


public class PopuRate {

		public static class PopuRateMapper extends Mapper<LongWritable, Text, PopulationRatio, PopulationRatio>{
			protected void map(LongWritable key, Text value, org.apache.hadoop.mapreduce.Mapper<LongWritable,Text,PopulationRatio,PopulationRatio>.Context context) throws java.io.IOException ,InterruptedException {
				String line = value.toString();
				String[] str = line.split(",");
				PopulationRatio pop = new PopulationRatio(str[0],Float.parseFloat(str[1]),Float.parseFloat(str[2]),Float.parseFloat(str[3]));
				context.write(pop, pop);
			}
		}
		
		
		public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
			Configuration conf = new Configuration();

			// 给出DB配置，本质：指明输入的位置和类型
			DBConfiguration.configureDB(conf, "com.mysql.cj.jdbc.Driver",
					"jdbc:mysql://192.168.100.100:3306/mydb?serverTimezone=UTC", "chentaijie", "chen123");

			Job job = Job.getInstance(conf, "PopuRate");
			job.setJarByClass(PopuRate.class);
			FileInputFormat.addInputPath(job, new Path(args[0]));
			//指定输入目录下的数据源文件的类型，默认是文本类型，可以不写
			job.setInputFormatClass(TextInputFormat.class);
			

			
			job.setMapperClass(PopuRateMapper.class);
			job.setMapOutputKeyClass(PopulationRatio.class);
			job.setMapOutputValueClass(PopulationRatio.class);

			// 默认为1， 如果设置为0,不执行reducer
			job.setNumReduceTasks(0);
//			job.setReducerClass(MRByDBReduce.class);
//			job.setOutputKeyClass(StatsInfo.class);
//			job.setOutputValueClass(Text.class);
			

			job.setOutputFormatClass(DBOutputFormat.class);
			DBOutputFormat.setOutput(job, "PopulationRatio","year", "birthRate","mortalityRate","naturalGrowthRate");

			boolean result = job.waitForCompletion(true);
//			boolean success = job.isSuccessful();	// 返回是否执行成功
			System.exit(result ? 0 : 1);
		}
}
