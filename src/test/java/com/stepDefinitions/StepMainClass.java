package com.stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.constants.Constants;
import com.pom.AccountStatement;
import com.pom.LoginPage;
import com.pom.UserLoggedPage;
import com.utilities.Commonutils;
import com.utilities.DriverManager;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepMainClass extends DriverManager  {

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

	@Given("user send login credentials")
	public void user_send_login_credentials() {
		DriverManager.getDriver().get(Constants.APP_URL);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		DriverManager.getDriver().findElement(By.xpath("//input[@id='login_field']")).sendKeys(Constants.USERNAME);
		DriverManager.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(Constants.PASSWORD);
		DriverManager.getDriver().findElement(By.xpath("//input[@name='commit']")).click();
	}

	@Given("user is on home page")
	public void user_is_on_home_page() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("user click on New Repo Text box")
	public void user_click_on_new_repo_text_box() {

	}

	@When("the user send the name as {string} click on CreateRepo Box")
	public void the_user_send_the_name_as_click_on_create_repo_box(String string) {
		DriverManager.getDriver().findElement(By.xpath("//input[@name='repository[name]']")).sendKeys(string);
		DriverManager.getDriver().findElement(By.xpath("(//input[@name='repository[visibility]'])[1]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Create a new repository')]")).click();
	}

	@Then("validate the Current url contains {string} or not")
	public void validate_the_current_url_contains_or_not(String string) {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		DriverManager.getDriver().findElement(By.xpath("(//summary[@class='Header-link'])[2]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();

		if(currentUrl.contains(string)) {
		}else {
			Assert.fail("Url not contains New repo");
		}
	}

	@When("user click on search repo Text box with {string}")
	public void user_click_on_search_repo_text_box_with(String string) {
		DriverManager.getDriver().findElement(By.xpath("(//input[@class='form-control input-contrast input-block mb-3 js-filterable-field js-your-repositories-search'])[1]")).sendKeys(string);


	}

	@When("the user click on first repo with has {string}")
	public void the_user_click_on_first_repo(String string) {
		DriverManager.getDriver().findElement(By.xpath("(//a[contains(@href,'yyappansg1/"+string+"')])[2]")).click();
	}

	@When("the user click on setting tab")
	public void the_user_click_on_setting_tab() {
		DriverManager.getDriver().findElement(By.xpath("//a[@id='settings-tab']")).click();
	}

	@When("user click on rename field and send name as {string} and click on rename button")
	public void user_click_on_rename_field_and_send_name_as_and_click_on_rename_button(String string) throws AWTException {
		DriverManager.getDriver().findElement(By.xpath("//input[@id='rename-field']")).click();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		
		DriverManager.getDriver().findElement(By.xpath("//input[@id='rename-field']")).sendKeys(string);
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Rename')]")).click();
	}

	@Then("validate the Current url contains the expected {string} or not")
	public void validate_the_current_url_contains_the_expected_or_not(String string) {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		DriverManager.getDriver().findElement(By.xpath("(//summary[@class='Header-link'])[2]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();

		if(currentUrl.contains(string)) {
			System.out.println("TEst PAssed");
		}else {
			Assert.fail("URl is not contains "+string);
		}
	}

	@When("user click on profile button")
	public void user_click_on_profile_button() {
		DriverManager.getDriver().findElement(By.xpath("(//summary[@class='Header-link'])[2]")).click();
	}

	@When("the user click on your profile button and click on edit profile button")
	public void the_user_click_on_your_profile_button_and_click_on_edit_profile_button() {
		DriverManager.getDriver().findElement(By.xpath("//a[contains(text(),'Your profile')]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[text()='Edit profile']")).click();
	}

	@When("the user send name as {string}")
	public void the_user_send_name_as(String string) {
		DriverManager.getDriver().findElement(By.xpath("//input[@id='user_profile_name']")).sendKeys(string);
	}

	@When("user click on save button")
	public void user_click_on_save_button() {
		DriverManager.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		DriverManager.getDriver().findElement(By.xpath("(//summary[@class='Header-link'])[2]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
	}

	@When("the user send Bio as {string}")
	public void the_user_send_bio_as(String string) {
		DriverManager.getDriver().findElement(By.xpath("//textarea[@id='user_profile_bio']")).sendKeys(string);
		DriverManager.getDriver().findElement(By.xpath("(//summary[@class='Header-link'])[2]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();

	}

	@When("user click on search box and pass data as {string} and press enter")
	public void user_click_on_search_box_and_pass_data_as_and_press_enter(String string) {
		DriverManager.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(string+Keys.ENTER);
	
	}

	@When("the user click on particular repo")
	public void the_user_click_on_particular_repo() {
		DriverManager.getDriver().findElement(By.xpath("(//a[contains(@href,'ninadpchaudhari/React-Tutorial')])[1]")).click();
	}

	@Then("verify current url contains {string}")
	public void verify_current_url_contains(String string) {

		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		DriverManager.getDriver().findElement(By.xpath("(//summary[@class='Header-link'])[2]")).click();
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();

		if(currentUrl.contains(string)) {
			System.out.println("Url is PAssed");
		}else {
			Assert.fail("Url not containing Required RePo");
		}
	}




}
