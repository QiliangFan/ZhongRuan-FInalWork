package com.springboot.health.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class DatFileUtil {
	public static FileReader getFileReader(String pathname, String filename) {
		String name = pathname + "/" + filename;
		URL url = DatFileUtil.class.getClassLoader().getResource("static/"+name);
		System.out.println(url);
		File file = new File(url.getFile());
//		File file = new File(name);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileReader;
	}

}
