package com.googel.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class azarbaseclass {
	
	public static WebDriver driver;
	
	public static void browserLaunch(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void loadUrl(String url){
//		WebDriver driver = new ChromeDriver();
		driver.get(url);
	}
	
	public static void browserClose() {
		driver.close();
	}
	
	public static WebElement searchElementByID(String id){
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	public static WebElement searchElementByXpath(String xpath){
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public static String readProperty(String key) throws IOException{
		File file = new File("C:\\Users\\cutem\\Downloads\\SeptemberProject2025\\SeptemberProject2025\\src\\test\\resources\\Credentials\\Details.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		
		String property = prop.getProperty(key);
		return property;
	}

}
