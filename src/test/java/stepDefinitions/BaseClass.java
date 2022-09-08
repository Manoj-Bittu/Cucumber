package stepDefinitions;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeAll
	public static void before() {
		report = new ExtentReports(System.getProperty("user.dir") + "/target/test-report.html");
	}

	@AfterAll
	public static void after() {
		report.endTest(logger);
		report.flush();
//		report.close();
	}
}
