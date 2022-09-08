package stepDefinitions;

import io.cucumber.java.en.*;
import pages.UtilitiePage;
import testRunners.FunctionalRunner;

public class UtilitieSteps {
	UtilitiePage up = new UtilitiePage(FunctionalRunner.getDriver());

	@Given("user is on monitor page")
	public void user_is_on_monitor_page() {

	}

	@When("user clicks on App Switch button")
	public void user_clicks_on_app_switch_button() throws InterruptedException {
	    up.clickOnAppSwitchBtn();
	    Thread.sleep(1000);
	}

	@And("use choose Utilities option")
	public void use_choose_utilities_option() throws InterruptedException {
	    up.clickOnUtilitiesOption();
	    Thread.sleep(1000);
	}

	@Then("user should navigate to Utilities page")
	public void user_should_navigate_to_utilities_page() {

	}

	@When("user clicks on utilities help? button")
	public void user_clicks_on_utilities_help_button() throws InterruptedException {
		up.utilitieWalkthrough();
		Thread.sleep(1000);
	}

	@Then("walkthrough should start for utilities page")
	public void walkthrough_should_start_for_utilities_page() throws InterruptedException {
		for (int i = 1; i <= 1; i++) {
			up.clickNextBtn();
			Thread.sleep(1000);
		}
		up.clickDoneBtn();
		Thread.sleep(1000);
	}
}
