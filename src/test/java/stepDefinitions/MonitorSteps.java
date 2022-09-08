package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.*;
import pages.MonitorPage;
import pages.convetPage;
import testRunners.FunctionalRunner;
import util.Snap;

public class MonitorSteps extends Snap {
	MonitorPage mp = new MonitorPage(FunctionalRunner.getDriver());
	convetPage cp = new convetPage(FunctionalRunner.getDriver());

	/* Monitor ECM walkthrough */
	@Given("I am in monitor ECM tab")
	public void i_am_in_monitor_ecm_tab() {
		BaseClass.logger = BaseClass.report.startTest("Monitor ECM Walkthrough Functionality Test");
		try {
			mp.clickOnAppSwitchBtn();
			Thread.sleep(2000);
			mp.clickOnMonitorOption();
			Thread.sleep(2000);
			BaseClass.logger.log(LogStatus.INFO, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "user is on monitor page ECM tab");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on ECM tab help? button walkthrough starts")
	public void i_click_on_ecm_tab_help_button_walkthrough_starts() {
		try {
			mp.ConvertTabWalkthrough();
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, "user click on Help ? button");
			BaseClass.logger.log(LogStatus.PASS, "Walkthrough started");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I click on Next button to point to next ECM helper")
	public void i_click_on_next_button_to_point_to_next_ecm_helper() {
		try {
			for (int i = 1; i <= 4; i++) {
				BaseClass.logger.log(LogStatus.INFO,
						BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver())) + cp.captureText());
				mp.clickNextBtn();
				BaseClass.logger.log(LogStatus.INFO, "user clicked on Next button");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("I click on Done button to stop ECM tab walkthrough")
	public void i_click_on_done_button_to_stop_ecm_tab_walkthrough() {
		try {
			BaseClass.logger.log(LogStatus.INFO,
					BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver())) + cp.captureText());
			mp.clickDoneBtn();
			BaseClass.logger.log(LogStatus.PASS, "user clicked on Done button");
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	/* ECM Request Details walkthrough */

	@When("I click on ECM Request Id")
	public void i_click_on_ecm_request_id() {
		try {
			mp.getECMReqID();
			BaseClass.logger.log(LogStatus.INFO, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "Request Id is : " + mp.displayECMReqId());
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I should navigate to ECM Request details")
	public void i_should_navigate_to_ecm_request_details() {
		try {
			BaseClass.logger.log(LogStatus.INFO, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "User is on Request Details Page");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on ECM Request details help? button walkthrough starts")
	public void i_click_on_ecm_request_details_help_button_walkthrough_starts() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I click on Next button to point to next ECM Request details helper")
	public void i_click_on_next_button_to_point_to_next_ecm_request_details_helper() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@And("I click on Done button to stop ECM Request details walkthrough")
	public void i_click_on_done_button_to_stop_ecm_request_details_walkthrough() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("I am in monitor Parquet tab")
	public void i_am_in_monitor_parquet_tab() {
		try {
			mp.clickGoBackBtn();
			BaseClass.logger.log(LogStatus.INFO, "User clicked on Go Back button");
			mp.clickOnParquetTab();
			BaseClass.logger.log(LogStatus.INFO, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "User clicked on Parquet tab");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on Parquet tab help? button walkthrough starts")
	public void i_click_on_parquet_tab_help_button_walkthrough_starts() {
		try {
			mp.ParquetTabWalkthrough();
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, "user click on Help ? button");
			BaseClass.logger.log(LogStatus.PASS, "Walkthrough started");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I click on Next button to point to next Parquet helper")
	public void i_click_on_next_button_to_point_to_next_parquet_helper() {
		try {
			for (int i = 1; i <= 4; i++) {
				BaseClass.logger.log(LogStatus.INFO,
						BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver())) + cp.captureText());
				mp.clickNextBtn();
				BaseClass.logger.log(LogStatus.INFO, "user clicked on Next button");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("I click on Done button to stop Parquet tab walkthrough")
	public void i_click_on_done_button_to_stop_parquet_tab_walkthrough() {
		try {
			BaseClass.logger.log(LogStatus.INFO,
					BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver())) + cp.captureText());
			mp.clickDoneBtn();
			BaseClass.logger.log(LogStatus.PASS, "user clicked on Done button");
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on Parquet Request Id")
	public void i_click_on_parquet_request_id() {
		try {
			mp.getParquetReqId();
			BaseClass.logger.log(LogStatus.INFO, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "Request Id is : " + mp.displayParquetReqId());
			Thread.sleep(1000);
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("I should navigate to Parquet Request details")
	public void i_should_navigate_to_parquet_request_details() {
		try {
			BaseClass.logger.log(LogStatus.INFO, BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))
					+ "User is on Parquet Request Details Page");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@When("I click on Parquet Request details help? button walkthrough starts")
	public void i_click_on_parquet_request_details_help_button_walkthrough_starts() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I click on Next button to point to next Parquet Request details helper")
	public void i_click_on_next_button_to_point_to_next_parquet_request_details_helper() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@And("I click on Done button to stop Parquet Request details walkthrough")
	public void i_click_on_done_button_to_stop_parquet_request_details_walkthrough() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
