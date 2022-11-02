package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static WebDriver driver=null;
	public static void launchBrowser() {
		switch (Constants.BROWSER) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
}
