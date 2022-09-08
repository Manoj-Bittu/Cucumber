package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	public ExtentReports report;
	public ExtentHtmlReporter htmlReporter;

	public void htmlReport() {
		report = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("Report/BDD.html");
		report.attachReporter(htmlReporter);
	}
}
