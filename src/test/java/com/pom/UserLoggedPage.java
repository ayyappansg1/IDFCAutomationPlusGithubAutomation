package com.pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.Commonutils;
import com.utilities.DriverManager;

public class UserLoggedPage {
	private static UserLoggedPage userloggedpage;
	private UserLoggedPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public static UserLoggedPage getInstance() {
		if(userloggedpage==null) {
			userloggedpage=new UserLoggedPage();
		}
		return userloggedpage;
	}
	@FindBy(xpath="//p[contains(text(),'Customer ID')]")
	private WebElement customerID;
	public WebElement getCustomerID() {
		return customerID;
	}
	public String getText() {
		String text = customerID.getText();
		return text;
	}
	@FindBy(xpath="//span[text()='logout']")
	private WebElement logout;
	public WebElement getLogout() {
		return logout;
	}
	
	public void clickLogout() {
		Commonutils.getInstance().highlightWebelement(logout);
		try {
		logout.click();
	}catch(Exception e) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(logout));
		until.click();
	}
		
	}
	

}
