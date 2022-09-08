package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(features = { "src/test/resources/end2endfeatures/end2end.feature" },tags= "@BA-login",  glue = {
		"stepDefinitions" }, plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)

public class End2EndRunner extends AbstractTestNGCucumberTests {
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	@BeforeClass
	@Parameters("browser")
	public WebDriver setUp(String browser) {
		System.out.println("browser value is : " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass the correct browser value :" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
