package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import testRunners.FunctionalRunner;
import util.ExcelReader;
import util.Snap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;

public class LoginSteps extends Snap {

	public loginPage log = new loginPage(FunctionalRunner.getDriver());
	ExcelReader xlib = new ExcelReader();
	WebDriverWait wait;
	public String BaseUri;
	String screenShotPath;
	public WebDriver driver;

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		BaseClass.logger = BaseClass.report.startTest("Login Test", "User login with admin credentials");
		try {
			BaseUri = xlib.getExcelData("Uri", 1, 0);
			BaseClass.logger.log(LogStatus.PASS, "Fetched url from excel file");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		FunctionalRunner.getDriver().get(BaseUri);
		BaseClass.logger.log(LogStatus.PASS, "user navigated to webpage");
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		String username = xlib.getExcelData("LoginData", 1, 0);
		try {
			log.inputUsername(username);
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "Userame entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		String password = xlib.getExcelData("LoginData", 1, 1);
		try {
			log.inputPassword(password);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "Password entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		try {
			log.clickLoginBtn();
			BaseClass.logger.log(LogStatus.PASS, "Clicked on Login button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("User should logged In and navigated to Dashboard page")
	public void user_should_logged_in_and_navigated_to_dashboard_page() {
	   
	}
}