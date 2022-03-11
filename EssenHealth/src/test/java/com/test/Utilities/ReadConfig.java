package com.test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		try {
			File src = new File("./Configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getBrowserNm() {
		String browserNmValue = pro.getProperty("browserNm");
		return browserNmValue;
	}

	public String getBaseURL() {
		String baseURLValue = pro.getProperty("baseURL");
		return baseURLValue;
	}

	public String getUsername() {
		String usernameValue = pro.getProperty("username");
		return usernameValue;
	}

	public String getPassword() {
		String passwordValue = pro.getProperty("password");
		return passwordValue;
	}

}
