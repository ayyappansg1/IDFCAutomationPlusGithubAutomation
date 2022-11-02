package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Commonutils;
import com.utilities.DriverManager;

public class LoginPage {
	private static LoginPage loginInstance;
	private LoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public static LoginPage getInstance() {
		if(loginInstance==null) {
			loginInstance=new LoginPage();
		}
		return loginInstance;
	}
	@FindBy(name="mobileNumber")
	private WebElement mobileNumber;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	@FindBy(name="login-password-input")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	@FindBy(xpath="//span[text()='Login securely']")
	private WebElement loginSecurely;
	public WebElement getMobileNumber() {
		return mobileNumber;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getLoginSecurely() {
		return loginSecurely;
	}
	public void sendMobileNumber(String mobile) {
		Commonutils.getInstance().highlightWebelement(mobileNumber);
		mobileNumber.sendKeys(mobile);
	}
	public void sendPassword(String pass) {
		Commonutils.getInstance().highlightWebelement(password);
		password.sendKeys(pass);
	}
	public void clickProceedLogin() {
		Commonutils.getInstance().highlightWebelement(loginButton);
		loginButton.click();
	}
	public void clickLoginSecurely() {
		Commonutils.getInstance().highlightWebelement(loginSecurely);
		loginSecurely.click();
	}




}
