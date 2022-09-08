package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.convetPage;
import testRunners.FunctionalRunner;
import util.ExcelReader;
import util.Snap;

public class ConvertSteps extends Snap {
	WebDriver driver;
	ExcelReader xlib = new ExcelReader();
	static convetPage cp = new convetPage(FunctionalRunner.getDriver());

	/*convert ECM walkthrough*/
	@Given("I am in Convert To ECM page")
	public void i_am_in_convert_to_ecm_page() {
		BaseClass.logger = BaseClass.report.startTest("Convert ECM Walkthrough Functionality Test");
		try {
			cp.click_On_Convert_Tile();
			cp.navigateToEcmTab();
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "user is on convert To ECM tab");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on convert request help? button walkthrough starts")
	public void i_click_on_convert_request_help_button_walkthrough_starts() {
		try {
			cp.convertEcmWalkthrough();
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, "user click on Help ? button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I click on Next button to point to next convert helper")
	public void i_click_on_next_button_to_point_to_next_convert_helper() {
		try {
			BaseClass.logger.log(LogStatus.PASS, "Walkthrough started");
			for (int i = 1; i <= 2; i++) {
				BaseClass.logger.log(LogStatus.INFO,
						BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
								+cp.captureText());
				cp.clickNextBtn();
				BaseClass.logger.log(LogStatus.INFO, "user clicked on Next button");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("I click on Done button to stop convert tab walkthrough")
	public void i_click_on_done_button_to_stop_convert_tab_walkthrough() {
		try {
			BaseClass.logger.log(LogStatus.INFO,
					BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
							+cp.captureText());
			cp.clickDoneBtn();
			BaseClass.logger.log(LogStatus.PASS, "user clicked on Done button");
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	
	/*convert Parquet walkthrough*/
	@Given("I am in Convert To Parquet page")
	public void i_am_in_convert_to_parquet_page() {
		BaseClass.logger = BaseClass.report.startTest("Convert Parquet Walkthrough Functionality Test");
	    try {
			cp.clickOnParquetTab();
			BaseClass.logger.log(LogStatus.PASS, "user navigated to Parquet Tab");
			Thread.sleep(2000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on Parquet request help? button walkthrough starts")
	public void i_click_on_parquet_request_help_button_walkthrough_starts() {
		try {
			cp.parquetWalkthrough();
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, "user click on Help ? button");
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I click on Next button to point to next parquet helper")
	public void i_click_on_next_button_to_point_to_next_parquet_helper() {
		BaseClass.logger.log(LogStatus.PASS, "Walkthrough started");
		try {
			for (int i = 1; i <= 2; i++) {
				BaseClass.logger.log(LogStatus.INFO,
						BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
								+cp.captureText());
				cp.clickNextBtn();
				BaseClass.logger.log(LogStatus.INFO,"user clicked on Next button");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("I click on Done button to stop parquet tab walkthrough")
	public void i_click_on_done_button_to_stop_parquet_tab_walkthrough() {
		try {
			BaseClass.logger.log(LogStatus.INFO,
					BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
							+cp.captureText());
			cp.clickDoneBtn();
			BaseClass.logger.log(LogStatus.PASS, "user clicked on Done button");
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}
	
	
	
	
	
	

	@Given("user is on ECM request tab")
	public void user_is_on_ecm_request_tab() throws InterruptedException {
		Thread.sleep(5000);
		try {
			BaseClass.logger = BaseClass.report.startTest("Convert request Test");
			cp.click_On_Convert_Tile();
//			Assert.assertEquals(cp.navigateToEcmTab(), "To ECM");
			BaseClass.logger.log(LogStatus.PASS, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "user is on convert To ECM tab");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

//	@When("user ensures the Optim server status and provides inputs")
//	public void user_ensures_the_optim_server_status_and_provides_inputs() throws InterruptedException, IOException {
//		if (cp.getConvertStatus1().contains("indicator green")) {
//			BaseClass.logger.log(LogStatus.PASS,
//					BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver())) + "Optim server is Up");
//			try {
//				cp.inputAppname();
//				BaseClass.logger.log(LogStatus.PASS,
//						BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
//								+ "user entered Application Name");
//			} catch (Exception e) {
//				BaseClass.logger.log(LogStatus.FAIL, e);
//			}
//			Thread.sleep(1000);
//			try {
//				cp.inputSourcePath();
//				BaseClass.logger.log(LogStatus.PASS,
//						BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
//								+ "user provided Source Location");
//			} catch (Exception e) {
//				BaseClass.logger.log(LogStatus.FAIL, e);
//			}
//			Thread.sleep(1000);
//			try {
//				cp.clickProcessBtn();
//				BaseClass.logger.log(LogStatus.PASS, "user clicked on Run Process button");
//				Thread.sleep(3000);
//				if (cp.getFreshMessage()
//						.contains("Your conversion request is successful with the given configurations.")) {
//					Thread.sleep(2000);
//					cp.clickOnFreshRunPopUpBtn();
//					BaseClass.logger.log(LogStatus.INFO,
//							BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
//									+ cp.getFreshMessage());
//					BaseClass.logger.log(LogStatus.PASS, "user clicked on OK button from success model");
//				} else if (cp.getOverWriteAllMessage().contains(
//						"Looks like this source folder contains archive files which are already processed, do you want to overwrite the processed ones?")) {
//					Thread.sleep(1000);
//					BaseClass.logger.log(LogStatus.INFO, cp.getOverWriteAllMessage());
//					cp.clickOnOverwriteAllBtn();
//					BaseClass.logger.log(LogStatus.PASS,
//							BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
//									+ "user clicked on OverwriteAll button");
//					Thread.sleep(3000);
//					cp.clickOnFreshRunPopUpBtn();
//					BaseClass.logger.log(LogStatus.PASS,
//							BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
//									+ "user clicked on OK button from success model");
//				}
//			} catch (Exception e) {
//				BaseClass.logger.log(LogStatus.FAIL, e);
//			}
//			Thread.sleep(1000);
//		} else {
//			BaseClass.logger.log(LogStatus.FAIL, "Optim server is Down");
//		}
//		Thread.sleep(1000);
//	}

	@Then("conversion will start processing")
	public void conversion_will_start_processing() {

	}

	@When("user clicks on parquet request help? button")
	public void user_clicks_on_parquet_request_help_button() throws InterruptedException {
		BaseClass.logger.log(LogStatus.PASS, "Parquet tab walkthrough");
		cp.clickOnParquetTab();
		Thread.sleep(1000);
		cp.parquetWalkthrough();
		Thread.sleep(1000);
	}

	@Then("walkthrough should start for parquet help")
	public void walkthrough_should_start_for_parquet_help() throws InterruptedException {
		for (int i = 1; i <= 2; i++) {
			cp.clickNextBtn();
			Thread.sleep(1000);
		}
		cp.clickDoneBtn();
		Thread.sleep(1000);
		if (cp.getParquetStatus1().contains("indicator green")) {
			System.out.println("Thrift server is up => " + cp.getParquetStatus1());
			BaseClass.logger.log(LogStatus.PASS, "Thrift server is Up");
		} else {
			System.out.println("Thrift server is down => " + cp.getParquetStatus2());
			BaseClass.logger.log(LogStatus.FAIL, "Thrift server is Down");
		}
	}

	@Then("if server is up the convert request id will be generated and user will be landed in monitor page if server is down user will not be able to run request")
	public void if_server_is_up_the_convert_request_id_will_be_generated_and_user_will_be_landed_in_monitor_page_if_server_is_down_user_will_not_be_able_to_run_request() {
	}

}
