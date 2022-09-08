package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dashboardPage {
	public static WebDriver driver;

	public static WebDriverWait wait;

	/* Constructor for the dashboardPage */
	public dashboardPage(WebDriver driver) {
		dashboardPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Element locator for capturing tile names */
	@FindBy(xpath = "//h5")
	public WebElement tailNames;

/* Element locator for welcome note*/
	@FindBy(xpath = "(//h4)[1]")
	WebElement welcome_note;
	
	/*  */
	@FindBy(xpath = "//h1")
	WebElement getPopUpTileNames;

	/* Element locator for App Switcher button element */
	@FindBy(xpath = "//button[@aria-label=\"App Switcher\"]")
	WebElement appSwitch_btn;

	/* Element locator for Listing module names from App Switcher */
	@FindBy(xpath = "//a[@class=\"bx--switcher__item-link\"]")
	WebElement print_module_names;

	/* Element locator for Language drop down */
	@FindBy(xpath = "//span[text()=' Languages']")
	WebElement language_dropDown;

	/* Element locator for Help button */
	@FindBy(xpath = "//div[@title=\"Help ?\"]")
	WebElement help_btn;

	/* Element locator for convert tile */
	@FindBy(xpath = "//h1[text()=\"Convert\"]")
	WebElement walkthrough_title;

	/* Element locator for walkthrough next button */
	@FindBy(xpath = "//a[text()=\"Next\"]")
	static WebElement next_btn;

	/* Element locator for monitor tile */
	@FindBy(xpath = "//h1[text()=\"  Monitor\"]")
	WebElement monitor_tile;

	/* Element locator for walkthrough back button */
	@FindBy(xpath = "//a[text()=\"Back\"]")
	WebElement back_btn;

	/* Element locator for walkthrough skip button */
	@FindBy(xpath = "//a[text()=\"Skip\"]")
	WebElement skip_btn;

	/* Element locator for walkthrough done button */
	@FindBy(xpath = "//a[text()=\"Done\"]")
	WebElement done_btn;

	@FindBy(xpath = "//h1")
	static WebElement getWalkthroughHeader;

	/* Element locator for dashboard text */
	@FindBy(xpath = "//h2[text()=\"Dashboard\"]")
	WebElement dashbord_txt;

	/* Element locator to identify Report Tile*/
	@FindBy(xpath = "//div[text()=\" Reports\"]")
	WebElement reportTile;
	
	public String getWelcomeNote() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(welcome_note));
		String get_welcome_note = welcome_note.getText();
		return get_welcome_note;
	}
	
	
	public int getTileNames() {
		String getTiles = tailNames.getText();
		int tileSize = getTiles.length();
		return tileSize;
	}

	public String getPopUpTileNames() {
		String names = getPopUpTileNames.getText();
		System.out.println(names);
		return names;
	}

	public void clickOnAppSwitchBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(appSwitch_btn));
		appSwitch_btn.click();
	}

	public void getListOfModuleNames() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(print_module_names));
		String module_names = print_module_names.getText();
		System.out.println(module_names);
	}

	public void verifyDashboard(String text, String key) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(dashbord_txt));
		text = dashbord_txt.getText();
	}

	public void walkthrough() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(help_btn));
		help_btn.click();
	}

	public void clickNextBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(next_btn));
		next_btn.click();
	}

	public void clickDoneBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(done_btn));
		done_btn.click();
	}

	public String getWalkthroughHeading() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(getWalkthroughHeader));
		String header = getWalkthroughHeader.getText();
		System.out.println(header);
		return header;
	}

	
	public void clickOnReportTile() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(reportTile));
		reportTile.click();
		Thread.sleep(3000);
	}
	
//	public void clickBackBtn() {
//		wait =new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait.until(ExpectedConditions.visibilityOf(back_btn));
//		back_btn.click();
//	}
//
//	public void clickSkipBtn() {
//		wait =new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait.until(ExpectedConditions.visibilityOf(skip_btn));
//		skip_btn.click();
//	}

}
