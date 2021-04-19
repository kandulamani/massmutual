package com.massmutual.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;

	/**
	 * This method is used to load the data form properties file
	 * 
	 * @return
	 */
	public Properties init_prop() {
		properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(".\\src\\main\\java\\com\\massmutual\\config\\config.properties");
			try {
				properties.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return properties;
	}

}