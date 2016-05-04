package com.qqq.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Tools {
	/***读取上一次操作时间***/
	public static String loadTime() {
		Properties prop = new Properties();
		String time = "";
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(
					"time.properties"));
			prop.load(is);
			time = prop.getProperty("time");
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(time);
		return time;
	}

	/***读取自动执行间隔时间***/
	public static long loadDelay() {
		Properties prop = new Properties();
		long delay = 0;
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(
					"time.properties"));
			prop.load(is);
			delay = new Long(prop.getProperty("delay"));
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(time);
		return delay;
	}

	/***保存本次操作时间及间隔时间***/
	@SuppressWarnings("static-access")
	public static void saveTime(String time, long delay) {
		Properties prop = new Properties();
		try {
			FileOutputStream fos = new FileOutputStream("time.properties",
					false);
			prop.setProperty("time", time);
			prop.setProperty("delay", new String().valueOf(delay));
			prop.store(fos, "The New properties file");
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***日期格式转换***/
	public static String formatDate(String start_date_time) {
		String date = "";
		if (start_date_time
				.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			date = start_date_time.substring(0, 11);
		} else if (start_date_time
				.matches("[0-9]{4}-[0-9]{1}-[0-9]{1} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			date = start_date_time.substring(0, 9);
		} else {
			date = start_date_time.substring(0, 10);
		}
		return date;
	}

	/***时间格式转换***/
	public static String formatTime(String start_date_time) {
		String time = "";
		if (start_date_time
				.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			time = start_date_time.substring(11, 19);
		} else if (start_date_time
				.matches("[0-9]{4}-[0-9]{1}-[0-9]{1} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			time = start_date_time.substring(9, 17);
		} else {
			time = start_date_time.substring(10, 18);
		}
		return time;
	}
}
