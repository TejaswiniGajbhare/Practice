package com.java.script.function.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileRead {
	static Properties prop;

	public static void main(String[] args) throws Exception {

		System.out.println("Program to read data from Property File");
		File file = new File("D:/Eclipse_Workspace/AutomationPracticeTest1/src/configpkg/config.properties");
		prop = new Properties();
		InputStream input = new FileInputStream(file);

		prop.load(input);

	}

}
