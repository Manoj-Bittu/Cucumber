//package stepDefinitions;
//
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.MonitorPage;
//import pages.convetPage;
//import pages.dashboardPage;
//import pages.loginPage;
//import testRunners.ChromeRunner;
//import util.ExcelReader;
//import util.Snap;
//
//public class Demo extends Snap {
//	public loginPage log = new loginPage(ChromeRunner.getDriver());
//	static convetPage cp = new convetPage(ChromeRunner.getDriver());
//	MonitorPage mp = new MonitorPage(ChromeRunner.getDriver());
//	dashboardPage dash = new dashboardPage(ChromeRunner.getDriver());
//
//	ExcelReader xlib = new ExcelReader();
//	WebDriverWait wait;
//	public String BaseUri;
//	String screenShotPath;
//	public WebDriver driver;
//
//	@Given("I am in login page")
//	public void i_am_in_login_page() {
//		BaseClass.logger = BaseClass.report.startTest("End To End Test");
//		try {
//			BaseUri = xlib.getExcelData("Uri", 1, 0);
//			BaseClass.logger.log(LogStatus.PASS, "Fetched url from excel file");
//		} catch (Exception e) {
//			BaseClass.logger.log(LogStatus.FAIL, e);
//		}
//		ChromeRunner.getDriver().get(BaseUri);
//		BaseClass.logger.log(LogStatus.PASS, "user navigated to webpage");
//	}
//
//	@When("I logged in with admin credentials")
//	public void i_logged_in_with_admin_credentials() {
//		String username = xlib.getExcelData("LoginData", 1, 0);
//		try {
//			log.inputUsername(username);
//			Thread.sleep(1000);
//			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//					+ "Userame entered successfully");
//		} catch (Exception e) {
//			BaseClass.logger.log(LogStatus.FAIL, e);
//		}
//		String password = xlib.getExcelData("LoginData", 1, 1);
//		try {
//			log.inputPassword(password);
//			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//					+ "Password entered successfully");
//		} catch (Exception e) {
//			BaseClass.logger.log(LogStatus.FAIL, e);
//		}
//		try {
//			log.clickLoginBtn();
//			BaseClass.logger.log(LogStatus.PASS, "Clicked on Login button");
//		} catch (Exception e) {
//			BaseClass.logger.log(LogStatus.FAIL, e);
//		}
//	}
//
//	@Then("I should navigate to Dashboard page")
//	public void i_should_navigate_to_dashboard_page() throws InterruptedException, IOException {
//		Thread.sleep(5000);
//		BaseClass.logger.log(LogStatus.PASS,
//				BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver())) + "user is on Dashboard Page");
//	}
//
//	@Then("I do convert ECM and Parquet request")
//	public void i_do_convert_ecm_abd_parquet_request() throws InterruptedException, IOException {
//		cp.click_On_Convert_Tile();
//		BaseClass.logger.log(LogStatus.PASS,
//				BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver())) + "user clicked on Convert Tile");
//		Thread.sleep(3000);
//		BaseClass.logger.log(LogStatus.INFO, "user is on convert ECM tab");
//			if (cp.getConvertStatus1().contains("indicator green")) {
//				cp.inputAppname();
//				BaseClass.logger.log(LogStatus.PASS,
//						BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//								+ "user entered Application Name");
//				Thread.sleep(1000);
//				cp.inputSourcePath();
//				BaseClass.logger.log(LogStatus.PASS,
//						BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//								+ "user provided Source Location");
//				Thread.sleep(1000);
//				cp.clickProcessBtn();
//				BaseClass.logger.log(LogStatus.PASS,
//						BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//								+ "user clicked on Run Process button");
//				Thread.sleep(2000);
//				if (cp.getFreshMessage()
//						.contains("Your conversion request is successful with the given configurations.")) {
//					Thread.sleep(2000);
//					cp.clickOnFreshRunPopUpBtn();
//					BaseClass.logger.log(LogStatus.INFO,
//							BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//									+ cp.getFreshMessage());
//					BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
//				} else if (cp.getOverWriteAllMessage().contains(
//						"Looks like this source folder contains archive files which are already processed, do you want to overwrite the processed ones?")) {
//					Thread.sleep(1000);
//					BaseClass.logger.log(LogStatus.INFO,
//							BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver()))
//									+ cp.getOverWriteAllMessage());
//					cp.clickOnOverwriteAllBtn();
//					BaseClass.logger.log(LogStatus.PASS, "user clicked on OverwriteAll button");
//					Thread.sleep(5000);
//					cp.clickOnFreshRunPopUpBtn();
//					Thread.sleep(5000);
//					BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
//					Thread.sleep(5000);
//				}
//				BaseClass.logger.log(LogStatus.INFO,
//						BaseClass.logger.addScreenCapture(capture(ChromeRunner.getDriver())) + "Request Id is : "
//								+ mp.displayECMReqId());
//				Thread.sleep(5000);	
//			}			
//			else {
//				BaseClass.logger.log(LogStatus.FAIL, "Optim server is Down unable to run convert request");
//			}
//			
//		}
//
//}
