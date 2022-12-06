package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.constants.Constants;
import com.hooks.HooksClass;
import com.pom.LoginPage;

public class Commonutils {
	private static Commonutils commonutilsInstance;
	private Commonutils(){
	}
	public static Commonutils getInstance(){
		if(commonutilsInstance==null) {
			commonutilsInstance=new Commonutils();
		}
		return commonutilsInstance;
	}
	public void loadProperties() {
		FileReader reader = null;
		try {
			reader=new FileReader("E:\\java files\\IdfcAutomation\\src\\test\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties=new Properties();
		try {
			properties.load(reader);
		} catch (IOException m) {
			m.printStackTrace();
		}
		Constants.APP_URL=properties.getProperty("url");
		Constants.PASSWORD=properties.getProperty("password");
		Constants.BROWSER=properties.getProperty("browser");
		Constants.USERNAME=properties.getProperty("username");
	}
	public void selectDropdown(WebElement element,String howTo,String value) {
		Select select=new Select(element);
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;
		default:
			break;
		}
	}
	public void highlightWebelement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border:3px solid red');" ,element);
	}
	public void screenshotTaking() throws IOException {
		TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		String scenarioName = HooksClass.getScenarioName();
		File dest=new File(scenarioName+".png");
		FileUtils.copyFile(screenshotAs,dest);
	}
	
	
	
}
