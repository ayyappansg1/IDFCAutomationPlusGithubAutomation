package com.hooks;

import java.time.Duration;

import org.junit.After;

import com.constants.Constants;
import com.pom.LoginPage;
import com.pom.UserLoggedPage;
import com.utilities.Commonutils;
import com.utilities.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass {
	private static String scenarioName=null;

	public static String getScenarioName() {
		return scenarioName;
	}
	@Before
	public void initial(Scenario scenario) {
		Commonutils.getInstance().loadProperties();	
		if(DriverManager.getDriver()==null) {
			DriverManager.launchBrowser();
		}
		scenarioName = scenario.getName();
		DriverManager.getDriver().get(Constants.APP_URL);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage.getInstance().sendMobileNumber(Constants.MOBILE);
		LoginPage.getInstance().clickProceedLogin();
		LoginPage.getInstance().sendPassword(Constants.PASSWORD);
		LoginPage.getInstance().clickLoginSecurely();
	}
	@After
	public void logout(Scenario scen) {
		if(scen.isFailed()) {
			
		UserLoggedPage.getInstance().clickLogout();}
		
	}
	
	
	
	
}
