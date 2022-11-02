package reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reports {

	public static void generateJvmReport(String jsonFile) {
		File reportDirectory= new File("E:\\java files\\IdfcAutomation\\target");
		Configuration conf=new Configuration(reportDirectory, "IDFC AUtomation");	
		conf.addClassifications("os","windows 8.1" );
		conf.addClassifications("browswe","Edge" );
		List<String>jsonfiles= new ArrayList<String>();
		jsonfiles.add(jsonFile);
		ReportBuilder reportBuilder=new ReportBuilder(jsonfiles,conf);
		reportBuilder.generateReports();
	}

}



