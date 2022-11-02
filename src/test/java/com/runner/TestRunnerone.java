package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import reporting.Reports;

@RunWith(Cucumber.class)
@CucumberOptions
(
		//features= "src/test/resources/FeatureFiles/Applyloan.feature",
				features= "src/test/resources/FeatureFiles/VerifyCustomerID.feature",
					//	features= "src/test/resources/FeatureFiles",
						//features= "src/test/resources/FeatureFiles",
							//	features= "src/test/resources/FeatureFiles",
glue= {"com.stepDefinitions","com.hooks"},
dryRun=false,
monochrome=true,
tags="@PrintStatement",
plugin= {"pretty","json:src/test/resourses/Reports/output.json"})
public class TestRunnerone {
	@AfterClass
	public static void afterClass() {
		Reports.generateJvmReport("src/test/resourses/Reports/output.json");
	}
}
