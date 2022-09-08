package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonitorPage {
	public WebDriver driver;
	WebDriverWait wait;
	Actions at;
	
	public MonitorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/* Element locator for App Switcher button element */
	@FindBy(xpath = "//button[@aria-label=\"App Switcher\"]")
	WebElement appSwitch_btn;
	
	/* Element locator to identify Monitor option */
	@FindBy(xpath = "//a[text()=\"  Monitor\"]")
	WebElement clickOnMonitor;
	
	/* Element locator to identify To ECM Help ?*/
	@FindBy(xpath = "(//div[@title=\"Help ?\"])[1]")
	WebElement convertHelp;
	
	/* Element locator to identify To Parquet Help ?*/
	@FindBy(xpath = "(//div[@title=\"Help ?\"])[2]")
	WebElement ParquetHelp;

	/* Element locator to identify next button */
	@FindBy(xpath = "//a[text()=\"Next\"]")
	WebElement nxtBtn;

	/* Element locator to identify done button */
	@FindBy(xpath = "//a[text()=\"Done\"]")
	WebElement doneBtn;
	
	
	/* Element locator to identify ECM Request Id */
	@FindBy(xpath = "(//a[contains(@href,'/details/ecm/')])[1]")
	WebElement getEcmReqId;
	
	/* Element locator to identify Parquet Request Id*/
	@FindBy(xpath = "(//a[contains(@href,'/details/parquet/')])[1]")
	WebElement getParquetID;

	
	/*Element locator to identify success code */
//	@FindBy(xpath = "(//span[contains(text(),'success')])[1]")
//	WebElement succesCode;
	
	/* Element locator to identify Success code */
	@FindBy(xpath = "//span[@title='success']")
	WebElement getSuccessCode;
	
	/* Element locator to identify Request Id Details page*/
	@FindBy(xpath = "(//h2)[4]")
	static
	WebElement getReqID;
	
	
	/* Element locator to identify Go Back button */
	@FindBy(xpath = "//a[text()=\"Go Back\"]")
	WebElement goBackBtn;
	
	/* Element locator to identify parquet tab*/
	@FindBy(xpath = "//button[text()=\" Parquet \"]")
	WebElement parquetTab;
	
	/* Element locator to identify dropdown*/
	@FindBy(xpath = "//div[@id=\"convertRequestId\"]")
	WebElement clickDropdown;
	
	/* Element locator to identify Include Clob check box */
	@FindBy(xpath = "//label[@for='checkbox-withClob']")
	WebElement clobCheckBox;
	
	public void clickOnAppSwitchBtn() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(appSwitch_btn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", appSwitch_btn);
		
	}
	
	public void clickOnMonitorOption() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(clickOnMonitor));
		clickOnMonitor.click();
	}
	
	public void ConvertTabWalkthrough() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(convertHelp));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", toEcmHelp);
		convertHelp.click();
	}
	
	public void ParquetTabWalkthrough() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ParquetHelp));
		ParquetHelp.click();
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
	
	/* Method to get ECM request Id */
	public String displayECMReqId() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(getEcmReqId));
		String getEcmID = getEcmReqId.getText().substring(1);
		return getEcmID;
	}
	
	/* Method to click ECM request Id*/
	public void getECMReqID() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(getEcmReqId));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getEcmReqId);
//		getEcmReqId.click();
	}
	
	/* Method to get Parquet request Id */
	public String displayParquetReqId() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(getParquetID));
		String getEcmID = getParquetID.getText().substring(1);
		return getEcmID;
	}
	
	/* Method to click Parquet request Id*/
	public void getParquetReqId() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(getParquetID));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getParquetID);
//		getEcmReqId.click();
	}
	
	
	/* Method to get RequestId from Details page */
	public String getID() {
		String reId=getReqID.getText().substring(1);
		System.out.println(reId.substring(1));
		return reId;
	}
	
	/* Method to get success code */
	public String getSuccessCode() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(240));
		wait.until(ExpectedConditions.visibilityOf(getSuccessCode));
		String text = getSuccessCode.getText();
		return text;
	}
	
	/* Method to click on Go Back button */
	public void clickGoBackBtn() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(goBackBtn));
		goBackBtn.click();
	}
	
	/* Method to click on To parquet*/
	public void clickOnParquetTab() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(parquetTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", parquetTab);
	}

	

	/* Methos to click on Include Clob */
	public void selectClobCheckBox() {
		clobCheckBox.click();
	}
}
