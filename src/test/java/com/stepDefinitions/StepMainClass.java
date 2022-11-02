package com.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.constants.Constants;
import com.pom.AccountStatement;
import com.pom.LoginPage;
import com.pom.UserLoggedPage;
import com.utilities.Commonutils;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepMainClass {

	@Then("user will be on the home page and validate word from customer id")
	public void user_will_be_on_the_home_page_and_validate_word_from_customer_id() throws IOException {
			Commonutils.getInstance().highlightWebelement(AccountStatement.getInstance().getAccountStatement());
			AccountStatement.getInstance().getAccountStatement().click();
	}
	@Given("the user click on account statement button")
	public void the_user_click_on_account_statement_button() throws InterruptedException {
		Commonutils.getInstance().highlightWebelement(AccountStatement.getInstance().getAccountStatement());
		Thread.sleep(3000);
		AccountStatement.getInstance().getAccountStatement().click();
	}
	@Given("the user click on custom button")
	public void the_user_click_on_custom_button() {
		Commonutils.getInstance().highlightWebelement(AccountStatement.getInstance().getCustom());
		AccountStatement.getInstance().getCustom().click();
	}
	@Given("the user click on from date dropdown and select month as {string} and year as {string} and date as {string}")
	public void the_user_click_on_from_date_dropdown_and_select_month_as_and_year_as_and_date_as(String month, String year, String date) {
		Commonutils.getInstance().highlightWebelement(AccountStatement.getInstance().getFromDateSelection());
		AccountStatement.getInstance().getFromDateSelection().click();
		Commonutils.getInstance().selectDropdown(AccountStatement.getInstance().getFromyear(), "text", year);
		Commonutils.getInstance().selectDropdown(AccountStatement.getInstance().getFrommonth(), "text", month);
		AccountStatement.getInstance().getFromdate().click();
	}
	@Given("the user click on to date dropdown and select month as {string} and year as {string} and date as {string}")
	public void the_user_click_on_to_date_dropdown_and_select_month_as_and_year_as_and_date_as(String month, String year, String date) throws InterruptedException {
		Commonutils.getInstance().highlightWebelement(AccountStatement.getInstance().getToDateSelection());
		AccountStatement.getInstance().getToDateSelection().click();
		Commonutils.getInstance().selectDropdown(AccountStatement.getInstance().getToyear(), "text", year);
		Commonutils.getInstance().selectDropdown(AccountStatement.getInstance().getTomonth(), "text", month);
		AccountStatement.getInstance().getTodate().click();
	}
	@When("the user click on download button it will download the file")
	public void the_user_click_on_download_button_it_will_download_the_file() throws InterruptedException {
		Commonutils.getInstance().highlightWebelement(AccountStatement.getInstance().getDownloadButton());
		AccountStatement.getInstance().getDownloadButton().click();
		Thread.sleep(10000);
	}
	@Then("user verify the file is downloaded with name contains {string}")
	public void user_verify_the_file_is_downloaded_with_name_contains(String filename) {
		File file=new File("C:\\Users\\ADMIN\\Downloads");
		File[] listFiles = file.listFiles();
		List<String> files=new ArrayList<String>();
		for (File file2 : listFiles) {
			files.add(file2.getName());
		}
		Assert.assertTrue(files.contains(filename));
	}

	
}
