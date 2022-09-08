package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitiePage {
	public static WebDriver driver;
	WebDriverWait wait;
	Actions at;
	public String applicationName;
	public static util.ExcelDataReader xlib;

	public UtilitiePage(WebDriver driver) {
		UtilitiePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* Element locator for App Switcher button element */
	@FindBy(xpath = "//button[@aria-label=\"App Switcher\"]")
	WebElement appSwitch_btn;
	
	/* Element locator to identify Monitor option */
	@FindBy(xpath = "//a[text()=\" Utilities\"]")
	WebElement clickOnUtilities;
	
	/* Element locator to identify Help? */
	@FindBy(xpath = "//div[@title=\"Help ?\"]")
	WebElement utiliteHelp;
	
	/* Element locator to identify next button */
	@FindBy(xpath = "//a[text()=\"Next\"]")
	WebElement nxtBtn;

	/* Element locator to identify done button */
	@FindBy(xpath = "//a[text()=\"Done\"]")
	WebElement doneBtn;
	
	/* Element locator to identify go back button*/
	@FindBy(xpath = "//a[text()=\"Go Back\"]")
	WebElement goBack;
	
	/* Element locator to identify ECM button */
	@FindBy(xpath = "//div[text()=\"ECM\"]")
	WebElement ecmButton;
	
	/* Element locator to identify Parquet button */
	@FindBy(xpath = "//div[contains(text(),'PARQUET')]")
	WebElement parquetButton;
	
	/* Element locator to identify Appname drop down*/
	@FindBy(xpath = "//select[@id='appName']")
	WebElement clickOnAppnameDropDown;
	
	/* Element locator to identify Validate button*/
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickOnValidateButton;
	
	/* Method to click on go back button*/
	public void clickGoBack() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(goBack));
		goBack.click();
	}
	
	public void clickOnAppSwitchBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(appSwitch_btn));
		appSwitch_btn.click();
	}
	
	public void clickOnUtilitiesOption() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(clickOnUtilities));
		clickOnUtilities.click();
	}
	
	/* Method to start convert tab walkthrough */
	public void utilitieWalkthrough() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(utiliteHelp));
		utiliteHelp.click();
	}

	/* Method to click on nextBtn */
	public void clickNextBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(nxtBtn));
		nxtBtn.click();
	}

	/* Method to click on doneBtn*/
	public void clickDoneBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(doneBtn));
		doneBtn.click();
	}
	
	/* Method to click on ECM button*/
	public void clickOnECM() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ecmButton));
		ecmButton.click();
	}
	
	/* Method to click on Parquet button*/
	public void clickOnParquet() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(parquetButton));
		parquetButton.click();
	}
	
	/* Method to click on application name drop down */
	public void clickOnAppnameDropDown() {
		xlib = new util.ExcelDataReader();
		applicationName = xlib.getExcelData("FileLocation", 1, 1);
		Select se = new Select(driver.findElement(By.id("appName")));
		se.selectByVisibleText(applicationName);
	}
	
	/* Method to click on Validate button */
	public void clickOnValidateButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(clickOnValidateButton));
		clickOnValidateButton.click();
	}
}
