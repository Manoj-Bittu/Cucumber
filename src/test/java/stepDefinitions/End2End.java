package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.*;
import pages.LogOutPage;
import pages.ManageUsersPage;
import pages.MonitorPage;
import pages.UtilitiePage;
import pages.convetPage;
import pages.dashboardPage;
import pages.loginPage;
import testRunners.End2EndRunner;
import util.ExcelReader;
import util.Snap;

public class End2End extends Snap {
	public loginPage log = new loginPage(End2EndRunner.getDriver());
	static convetPage cp = new convetPage(End2EndRunner.getDriver());
	MonitorPage mp = new MonitorPage(End2EndRunner.getDriver());
	dashboardPage dash = new dashboardPage(End2EndRunner.getDriver());
	ManageUsersPage manage = new ManageUsersPage(End2EndRunner.getDriver());
	UtilitiePage up = new UtilitiePage(End2EndRunner.getDriver());
	LogOutPage lp = new LogOutPage(End2EndRunner.getDriver());

	ExcelReader xlib = new ExcelReader();
	WebDriverWait wait;
	public String BaseUri;
	String screenShotPath;
	public WebDriver driver;

	@Given("I am in login page")
	public void i_am_in_login_page() {
		BaseClass.logger = BaseClass.report.startTest("End To End Test");
		try {
			BaseUri = xlib.getExcelData("Uri", 1, 0);
			BaseClass.logger.log(LogStatus.PASS, "Fetched url from excel file");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		End2EndRunner.getDriver().get(BaseUri);
		BaseClass.logger.log(LogStatus.PASS, "user navigated to webpage");
	}

	@When("I logged in with admin credentials")
	public void i_logged_in_with_admin_credentials() {
		String username = xlib.getExcelData("LoginData", 1, 0);
		try {
			log.inputUsername(username);
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Userame entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		String password = xlib.getExcelData("LoginData", 1, 1);
		try {
			log.inputPassword(password);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Password entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		try {
			log.clickLoginBtn();
			BaseClass.logger.log(LogStatus.PASS, "Clicked on Login button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I should navigate to Dashboard page")
	public void i_should_navigate_to_dashboard_page() throws InterruptedException, IOException {
		Thread.sleep(5000);
		BaseClass.logger.log(LogStatus.PASS,
				BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver())) + "user is on Dashboard Page");
		lp.clickLogOutBtn();
	}

	@Then("I do convert ECM and Parquet request")
	public void i_do_convert_ecm_abd_parquet_request() throws InterruptedException, IOException {
		try {
			cp.click_On_Convert_Tile();
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "user clicked on Convert Tile");
			Thread.sleep(3000);
			BaseClass.logger.log(LogStatus.INFO, "user is on convert ECM tab");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		if (cp.getConvertStatus1().contains("indicator green")) {
			BaseClass.logger.log(LogStatus.PASS,
					BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver())) + "Optim server is Up");
			try {
				cp.inputAppname();
				BaseClass.logger.log(LogStatus.PASS,
						BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
								+ "user entered Application Name");
			} catch (Exception e) {
				BaseClass.logger.log(LogStatus.FAIL, e);
			}
			Thread.sleep(1000);
			try {
				cp.inputSourcePath();
				BaseClass.logger.log(LogStatus.PASS,
						BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
								+ "user provided Source Location");
			} catch (Exception e) {
				BaseClass.logger.log(LogStatus.FAIL, e);
			}
			Thread.sleep(1000);
			try {
				cp.clickProcessBtn();
				BaseClass.logger.log(LogStatus.PASS,
						BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
								+ "user clicked on Run Process button");
				Thread.sleep(3000);
				if (cp.getECMFreshMessage()
						.contains("Your conversion request is successful with the given configurations.")) {
					Thread.sleep(5000);
					cp.clickOnFreshRunPopUpBtn();
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ cp.getECMFreshMessage());
					BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
				} else {
					Thread.sleep(1000);
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ cp.getOverWriteAllMessage());
					cp.clickOnOverwriteAllBtn();
					BaseClass.logger.log(LogStatus.PASS, "user clicked on OverwriteAll button");
					Thread.sleep(5000);
					cp.clickOnFreshRunPopUpBtn();
					Thread.sleep(5000);
					BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
					Thread.sleep(5000);
				}
				BaseClass.logger.log(LogStatus.INFO,
						BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver())) + "Request Id is : "
								+ mp.displayECMReqId());
				Thread.sleep(5000);
				mp.getECMReqID();
				Thread.sleep(2000);
				if (mp.getSuccessCode().contains("Success")) {
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ "Request Status is : " + mp.getSuccessCode());
//					Thread.sleep(2000);
					dash.clickOnAppSwitchBtn();
					BaseClass.logger.log(LogStatus.INFO, "user clicked on App Switch button");
					Thread.sleep(1000);
					cp.clickConvertOption();
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ "user clicked on Convert Option");
					cp.clickOnParquetTab();
					BaseClass.logger.log(LogStatus.PASS,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ "user clicked on Parquet tab");
					Thread.sleep(2000);
					cp.clickDropDown();
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ "user clicked on Request ID dropdown");
					mp.selectClobCheckBox();
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver())));

					cp.clickParquetConvertBtn();
					BaseClass.logger.log(LogStatus.PASS,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ "user clicked on Run Process button");
					Thread.sleep(3000);
					if (cp.getParquetFreshMessage()
							.contains("Your conversion request is successful with the given configurations.")) {
						Thread.sleep(5000);
						cp.clickOnOkPopUpBtn();
						Thread.sleep(3000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ cp.getParquetFreshMessage());
						Thread.sleep(3000);
						BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
					} else {
						Thread.sleep(3000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ cp.getOverWriteAllMessage());
						cp.clickOnOverwriteBtn();
						BaseClass.logger.log(LogStatus.PASS, "user clicked on Overwrite button");
						Thread.sleep(5000);
						cp.clickOnOkPopUpBtn();
//						Thread.sleep(5000);
						BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
						Thread.sleep(5000);
					}

					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver())) + "Request Id is : "
									+ mp.displayParquetReqId());
					Thread.sleep(5000);
					mp.getParquetReqId();
					Thread.sleep(2000);
					if (mp.getSuccessCode().contains("Success")) {
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "Request Status is : " + mp.getSuccessCode());
						Thread.sleep(2000);
						dash.clickOnAppSwitchBtn();
						BaseClass.logger.log(LogStatus.INFO, "user clicked on App Switch button");
						Thread.sleep(1000);
						up.clickOnUtilitiesOption();
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO, "user clicked on Utilities option");
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "user is on Utilities page");
						Thread.sleep(2000);
						up.clickOnECM();
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "user clicked on ECM");
						Thread.sleep(2000);
						up.clickOnAppnameDropDown();
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "user clicked Application Name drop down");
						Thread.sleep(2000);
						up.clickOnValidateButton();
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "user clicked on Validation button");
						Thread.sleep(2000);
						up.clickOnParquet();
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "user clicked on PARQUET");
						Thread.sleep(2000);
						up.clickOnValidateButton();
						Thread.sleep(2000);
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "user clicked Validation button");

					} else if (mp.getSuccessCode().contains("Processing")) {
						BaseClass.logger.log(LogStatus.INFO,
								BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
										+ "Request Status is : " + mp.getSuccessCode());
					}

				} else if (mp.getSuccessCode().contains("Processing")) {
					BaseClass.logger.log(LogStatus.INFO,
							BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
									+ "Request Status is : " + mp.getSuccessCode());
				}
			} catch (Exception e) {
				BaseClass.logger.log(LogStatus.FAIL, e);
			}
		} else {
			BaseClass.logger.log(LogStatus.FAIL, "Optim server is Down unable to run convert request");
		}
	}
	
	
	
	
	/*--------Creating new user---------*/
	@Given("User Logged In as admin")
	public void user_logged_in_as_admin() {
		BaseClass.logger = BaseClass.report.startTest("End To End Test - Create new user");
		try {
			BaseUri = xlib.getExcelData("Uri", 1, 0);
			BaseClass.logger.log(LogStatus.PASS, "Fetched url from excel file");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		End2EndRunner.getDriver().get(BaseUri);
		BaseClass.logger.log(LogStatus.PASS, "user navigated to webpage");
		String username = xlib.getExcelData("LoginData", 1, 0);
		try {
			log.inputUsername(username);
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Userame entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		String password = xlib.getExcelData("LoginData", 1, 1);
		try {
			log.inputPassword(password);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Password entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		try {
			log.clickLoginBtn();
			BaseClass.logger.log(LogStatus.PASS, "Clicked on Login button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I clicked on Manage Users")
	public void i_clicked_on_manage_users() {
		try {
			 manage.clickOnManageUsersTile();
			 manage.getUserRowCount();
			 BaseClass.logger.log(LogStatus.PASS, "Clicked on Manage Users Tile");
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "User is on Manage Users page");
			 manage.clickOnAddNewBtn();
			 BaseClass.logger.log(LogStatus.PASS, "User clicked on Add New button");
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "User is on Add New User page");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("I Create New user")
	public void i_create_new_user() {
	    try {
	    	String name = xlib.getExcelData("UserData", 1, 0);
	    	String email = xlib.getExcelData("UserData", 1, 1);
	    	String username = xlib.getExcelData("UserData", 1, 2);
	    	String password = xlib.getExcelData("UserData", 1, 3);
			manage.enterName(name);
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "Name entered successfully");
			 manage.clickOnSelectRole();
			 Thread.sleep(3000);
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "User clicked on Select Role");
			 manage.selectAdminRole();
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "User role selected successfully");
			 manage.inputEmail(email);
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "Email entered successfully");
			 manage.inputUsername(username);
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "Username entered successfully");
			 manage.inputPassword(password);
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "Password entered successfully");
			 manage.clickAddUserBtn();
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "User clicked on Add User");
			 manage.clickOkBtn();
			 BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
						+ "User Created Successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("User should be added")
	public void user_should_be_added() throws InterruptedException {
		System.out.println("Demo");
		lp.clickLogOutBtn();
		End2EndRunner.getDriver().quit();
	}
	
	
	
	/*-----------------Login With Business Analyst Role-------------------*/
	@Given("User is in login page")
	public void user_is_in_login_page() {
		BaseClass.logger = BaseClass.report.startTest("End To End Test");
		try {
			BaseUri = xlib.getExcelData("Uri", 1, 0);
			BaseClass.logger.log(LogStatus.PASS, "Fetched url from excel file");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		End2EndRunner.getDriver().get(BaseUri);
		BaseClass.logger.log(LogStatus.PASS, "user navigated to webpage");
	}

	@When("I logged in with BA credentials")
	public void i_logged_in_with_ba_credentials() {
		String username = xlib.getExcelData("UserData", 1, 2);
		try {
			log.inputUsername(username);
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Userame entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		String password = xlib.getExcelData("UserData", 1, 3);
		try {
			log.inputPassword(password);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Password entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		try {
			log.clickLoginBtn();
			BaseClass.logger.log(LogStatus.PASS, "Clicked on Login button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I should be in Dashboard page")
	public void i_should_be_in_dashboard_page() throws InterruptedException, IOException {
	    dash.clickOnReportTile();
	    BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
				+ "User is on Reports page");
//	    End2EndRunner.getDriver().quit();
	}

	@And("I should see reports tail")
	public void i_should_see_reports_tail() {
	   System.out.println(" ");
	}
	
	
	/*----------------Login with Operator Role -------------*/
	@Given("Operator is on login page")
	public void operator_is_on_login_page() {
		BaseClass.logger = BaseClass.report.startTest("End To End Test");
		try {
			BaseUri = xlib.getExcelData("Uri", 1, 0);
			BaseClass.logger.log(LogStatus.PASS, "Fetched url from excel file");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		End2EndRunner.getDriver().get(BaseUri);
		BaseClass.logger.log(LogStatus.PASS, "user navigated to webpage");
	}

	@When("I logged in as Operator")
	public void i_logged_in_as_operator() {
		String username = xlib.getExcelData("UserData", 2, 2);
		try {
			log.inputUsername(username);
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Userame entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		String password = xlib.getExcelData("UserData", 2, 3);
		try {
			log.inputPassword(password);
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(End2EndRunner.getDriver()))
					+ "Password entered successfully");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		try {
			log.clickLoginBtn();
			BaseClass.logger.log(LogStatus.PASS, "Clicked on Login button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
		 End2EndRunner.getDriver().quit();
	}

//	@When("I perform convert request")
//	public void i_perform_convert_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("I should navigate to monitor page")
//	public void i_should_navigate_to_monitor_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("I shoould verify my request details")
//	public void i_shoould_verify_my_request_details() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	
}
