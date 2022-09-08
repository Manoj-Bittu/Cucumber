package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.*;
import pages.dashboardPage;
import testRunners.FunctionalRunner;
import util.Snap;

public class DashboardSteps extends Snap{

	LoginSteps ls = new LoginSteps();
	dashboardPage dash = new dashboardPage(FunctionalRunner.getDriver());

	@Given("User logged into application")
	public void user_logged_into_application() {
	   
	}

	@When("User navigates to Dashboard page")
	public void user_navigates_to_dashboard_page() {
	   
	}

	@Then("Welcome note with user name should visible")
	public void welcome_note_with_user_name_should_visible() {
	   try {
//		Assert.assertEquals(dash.getWelcomeNote(), );
	} catch (AssertionError e) {
		
	}
	}
	
	
	@When("user clicks on Help ? button walkthrough start")
	public void user_clicks_on_help_button_walkthrough_start() throws InterruptedException {
		BaseClass.logger = BaseClass.report.startTest("Dashboard Walkthrough Functionality Test");
		try {
			dash.walkthrough();
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS, "user click on Help ? button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@Then("user clicks on Next button walkthrough point to next tail")
	public void user_clicks_on_next_button_walkthrough_point_to_next_tail() throws InterruptedException {
		try {
			BaseClass.logger.log(LogStatus.PASS, "Walkthrough started");
			for (int i = 1; i <= dash.getTileNames() - 1; i++) {
				BaseClass.logger.log(LogStatus.INFO,BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))+  "triggered "+ dash.getPopUpTileNames() + " pop up");
				dash.clickNextBtn();
				BaseClass.logger.log(LogStatus.PASS,BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))+  "user clicked on Next button");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}

	@And("User clicks on Done button walkthrough stops")
	public void user_clicks_on_done_button_walkthrough_stops() throws InterruptedException {
		try {
			dash.clickDoneBtn();
			Thread.sleep(1000);
			BaseClass.logger.log(LogStatus.PASS,BaseClass.logger.addScreenCapture(capture(FunctionalRunner.getDriver()))+  "user clicked on Done button");
		} catch (Exception e) {
			BaseClass.logger.log(LogStatus.FAIL, e);
		}
	}
}
