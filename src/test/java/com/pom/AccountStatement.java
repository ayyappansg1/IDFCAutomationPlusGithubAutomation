package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverManager;

public class AccountStatement {
	private static AccountStatement acc;
	public static AccountStatement getInstance() {
		if(acc==null) {
			acc=new AccountStatement();
		}
		return acc;
	}
	private AccountStatement() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(xpath="//*[@id=\"RASDashboard\"]/section/div[2]/div/div[2]/div[2]/div/div[5]/div/button/span")
	private WebElement accountStatement;
	@FindBy(xpath="//*[@id=\"FlowModalWrapper\"]/section/div/div[1]/div[2]/div/div/label[5]/span[1]")
	private WebElement custom;
	@FindBy(xpath="//input[@id='custom-from-date']")
	private WebElement fromDateSelection;
	@FindBy(xpath="//input[@id='custom-to-date']")
	private WebElement toDateSelection;
	@FindBy(xpath="//*[@id=\"FlowModalWrapper\"]/section/div/div[1]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/select[2]")
	private WebElement fromyear;
	@FindBy(xpath="//*[@id=\"FlowModalWrapper\"]/section/div/div[1]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/select[1]")
	private WebElement frommonth;
	@FindBy(xpath="//div[text()='18']")
	private WebElement fromdate;
	@FindBy(xpath="//*[@id=\"FlowModalWrapper\"]/section/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/select[2]")
	private WebElement toyear;
	@FindBy(xpath="//*[@id=\"FlowModalWrapper\"]/section/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/select[1]")
	private WebElement tomonth;
	@FindBy(xpath="//div[text()='10']")
	private WebElement todate;
	@FindBy(xpath="//span[text()='Download']")
	private WebElement downloadButton;
	public static AccountStatement getAcc() {
		return acc;
	}
	public static void setAcc(AccountStatement acc) {
		AccountStatement.acc = acc;
	}
	public WebElement getAccountStatement() {
		return accountStatement;
	}
	public void setAccountStatement(WebElement accountStatement) {
		this.accountStatement = accountStatement;
	}
	public WebElement getCustom() {
		return custom;
	}
	public void setCustom(WebElement custom) {
		this.custom = custom;
	}
	public WebElement getFromDateSelection() {
		return fromDateSelection;
	}
	public void setFromDateSelection(WebElement fromDateSelection) {
		this.fromDateSelection = fromDateSelection;
	}
	public WebElement getToDateSelection() {
		return toDateSelection;
	}
	public void setToDateSelection(WebElement toDateSelection) {
		this.toDateSelection = toDateSelection;
	}
	public WebElement getFromyear() {
		return fromyear;
	}
	public void setFromyear(WebElement fromyear) {
		this.fromyear = fromyear;
	}
	public WebElement getFrommonth() {
		return frommonth;
	}
	public void setFrommonth(WebElement frommonth) {
		this.frommonth = frommonth;
	}
	public WebElement getFromdate() {
		return fromdate;
	}
	public void setFromdate(WebElement fromdate) {
		this.fromdate = fromdate;
	}
	public WebElement getToyear() {
		return toyear;
	}
	public void setToyear(WebElement toyear) {
		this.toyear = toyear;
	}
	public WebElement getTomonth() {
		return tomonth;
	}
	public void setTomonth(WebElement tomonth) {
		this.tomonth = tomonth;
	}
	public WebElement getTodate() {
		return todate;
	}
	public void setTodate(WebElement todate) {
		this.todate = todate;
	}
	public WebElement getDownloadButton() {
		return downloadButton;
	}
	public void setDownloadButton(WebElement downloadButton) {
		this.downloadButton = downloadButton;
	}
	
	 
	
}
