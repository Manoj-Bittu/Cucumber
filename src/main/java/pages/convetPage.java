package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class convetPage {

	public WebDriver driver;
	WebDriverWait wait;
	Actions at;
	public String sourceLocation;
	public String applicationName;
	public static util.ExcelDataReader xlib;

	public convetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Element locator to identify Convert Tile */
	@FindBy(xpath = "//h5[text()=\"Convert\"]")
	WebElement convertTile;

	/* Element locator to identify Convert menu form App Switch */
	@FindBy(xpath = "//a[text()=\"Convert\"]")
	WebElement appSwitchConvertOption;

	/* Element locator to identify To ECM tab */
	@FindBy(xpath = "//button[text()=\"ECM\"]")
	WebElement ecmTab;

	/* Element locator to identify Parquet tab */
	@FindBy(xpath = "//button[text()=\" Parquet \"]")
	WebElement parquetTab;

	/* Element locator to identify ECM tab Help ? */
	@FindBy(xpath = "(//div[@title=\"Help ?\"])[1]")
	WebElement ecmTabHelp;

	/* Element locator to identify walkthrough text */
	@FindBy(xpath = "//div[@class=\"introjs-tooltiptext\"]")
	WebElement getWalkthroughText;

	/* Element locator to identify Parquet tab Help ? */
	@FindBy(xpath = "(//div[@title=\"Help ?\"])[2]")
	WebElement parquetHelp;

	/* Element locator to identify Walkthrough Next Button */
	@FindBy(xpath = "//a[text()=\"Next\"]")
	WebElement nxtBtn;

	/* Element locator to identify Walkthrough Done button */
	@FindBy(xpath = "//a[text()=\"Done\"]")
	WebElement doneBtn;

	/* Element locator to identify server up indicator */
	@FindBy(xpath = "((//h5)[5]/../..//div)[2]")
	WebElement checkConvertServerUpStatus1;

	@FindBy(xpath = "((//h5)[5]/../..//div)[2]")
	WebElement checkConvertServerUpStatus2;

	/* Element locator to identify server down indicator */
	@FindBy(xpath = "(//h5)[9]/../..//div[2]")
	WebElement checkConvertServerDownStatus1;

	@FindBy(xpath = "((//h5)[9]/../..//div[2]")
	WebElement checkConvertServerDownStatus2;

	/* Element locator to identify app name input field */
	@FindBy(id = "appName")
	WebElement appname;

	/* Element locator to identify source input field */
	@FindBy(xpath = "//input[@id=\"sourceXFilePath\"]")
	WebElement sourcePath;

	/* Element locator to identify ECM convert button */
	@FindBy(xpath = "(//button[text()=\"Convert\"])[1]")
	WebElement ecmConvertBtn;

	/* Element locator to identify Parquet convert button */
	@FindBy(xpath = "(//button[text()=\"Convert\"])[2]")
	WebElement parquetConvertBtn;

	/* Element locator to identify ok button for fresh run */
	@FindBy(xpath = "(//button[text()=\"OK\"])[1]")
	WebElement freshConvertRunOkBtn;

	/* Element locator to identify ok button for fresh run */
	@FindBy(xpath = "(//button[text()=\"OK\"])[2]")
	WebElement ConvertRunOkBtn;

	/* Element locator to identify fresh convert success message */
	@FindBy(xpath = "(//div)[21]")
	WebElement getECMFreshMessage;

	/* Element locator to identify fresh convert success message */
	@FindBy(xpath = "(//div)[84]")
	WebElement getParquetFreshMessage;

	/* Element locator to identify convert all warning messgae */
	@FindBy(xpath = "(//h3)[2]")
	WebElement getOverWriteAllMessage;

	/* Element locator to identify recently generated request id */
	@FindBy(xpath = "(//a)[13]")
	WebElement getId;

	/* Element locator to identify over write all warning btn */
	@FindBy(xpath = "//button[text()=\"Overwrite All\"]")
	WebElement overWriteAllBtn;

	/* Element locator to identify over write all warning btn */
	@FindBy(xpath = "//button[text()=\"OverWrite\"]")
	WebElement overWriteBtn;

	/* Method to capture Dashboard page url */
	public String captureDashboardPageUrl() {
		String getDashboardPageUrl = driver.getCurrentUrl();
		System.out.println(getDashboardPageUrl);
		return getDashboardPageUrl;
	}

	/* Method to perform click operation on Convert Tile */
	public void click_On_Convert_Tile() throws InterruptedException {
		// to perform scrolling up
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(convertTile));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", convertTile);
	}

	/* Method to capture Convert page url */
	public String captureConvertPageUrl() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String getConvertPageUrl = driver.getCurrentUrl();
		System.out.println(getConvertPageUrl);
		return getConvertPageUrl;
	}

	/* Method to start convert tab walkthrough */
	public void convertEcmWalkthrough() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ecmTabHelp));
		ecmTabHelp.click();
	}

	/* Method to click on nextBtn */
	public void clickNextBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(nxtBtn));
		nxtBtn.click();
	}

	/* Method to click on doneBtn */
	public void clickDoneBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(doneBtn));
		doneBtn.click();
	}

	/* Method to click on Parquet Tab */
	public void clickOnParquetTab() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(parquetTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", parquetTab);
	}

	/* Method to start parquet tab walkthrough */
	public void parquetWalkthrough() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(parquetHelp));
		parquetHelp.click();
	}

	/* Method to capture walkthrough text */
	public String captureText() {
		String text = getWalkthroughText.getText();
		return text;
	}

	/* Method to capture Run Process header text */
	public String captureRunProcessHeaderText() {
		String getRunProcessHeaderText = ecmConvertBtn.getText();
		System.out.println(getRunProcessHeaderText);
		return getRunProcessHeaderText;
	}

	/* Method to check the server status */
	public String getConvertStatus1() {
		String convertStatus1 = checkConvertServerUpStatus1.getAttribute("class");
		return convertStatus1;
	}

	public String getConvertStatus2() {
		String convertStatus2 = checkConvertServerUpStatus2.getAttribute("class");
		return convertStatus2;
	}

	public String getParquetStatus1() {
		String parquetStatus1 = checkConvertServerDownStatus1.getAttribute("class");
		return parquetStatus1;
	}

	public String getParquetStatus2() {
		String parquetStatus2 = checkConvertServerDownStatus2.getAttribute("class");
		return parquetStatus2;
	}

	/* Method to input appname */
	public void inputAppname() {
		xlib = new util.ExcelDataReader();
		applicationName = xlib.getExcelData("FileLocation", 1, 1);
		appname.sendKeys(applicationName);
	}

	/* Method to input sourcePath */
	public void inputSourcePath() {
		while (!sourcePath.getAttribute("value").equals("")) {
			sourcePath.sendKeys(Keys.BACK_SPACE);
		}
		xlib = new util.ExcelDataReader();
		sourceLocation = xlib.getExcelData("FileLocation", 1, 0);
		sourcePath.sendKeys(sourceLocation);
	}

	/* Method to click on ecm convert button */
	public void clickProcessBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ecmConvertBtn));
		ecmConvertBtn.click();
	}

	/* Method to click on parquet convert button */
	public void clickParquetConvertBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(parquetConvertBtn));
		parquetConvertBtn.click();
	}

	/* Method to click on fresh run popup model */
	public void clickOnFreshRunPopUpBtn() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(freshConvertRunOkBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", freshConvertRunOkBtn);
//		freshConvertRunOkBtn.click();
	}

	public void clickOnOkPopUpBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ConvertRunOkBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ConvertRunOkBtn);
//		freshConvertRunOkBtn.click();
	}

	/* Method to fetch ECM fresh convert success message */
	public String getECMFreshMessage() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(getECMFreshMessage));
		String text = getECMFreshMessage.getText();
		return text;
	}

	/* Method to fetch Parquet fresh convert success message */
	public String getParquetFreshMessage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(getParquetFreshMessage));
		String text = getParquetFreshMessage.getText();
		return text;
	}

	/* Method to fetch over write all warning message */
	public String getOverWriteAllMessage() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(getOverWriteAllMessage));
		String text = getOverWriteAllMessage.getText();
		System.out.println("over write warning " + text);
		return text;
	}

	/* Method to click on Overwrite All button */
	public void clickOnOverwriteAllBtn() {
		overWriteAllBtn.click();
	}

	/* Method to click on OverWrite button */
	public void clickOnOverwriteBtn() {
		overWriteBtn.click();
	}

	/* Method to click on recent request id */
	public void getRecentId() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(getId));
		String recentId = getId.getText();
		System.out.println(recentId);
		Thread.sleep(5000);
		getId.click();
	}

	/* Method to click on recent request id */
	public void clickOnRecentRequestId() {
		getId.click();
	}

	/* Method to click on ECM Tab */
	public String navigateToEcmTab() {
		at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();
		String text = ecmTab.getText();
		return text;
	}

	/* Method to click on Convert Option */
	public void clickConvertOption() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(appSwitchConvertOption));
		appSwitchConvertOption.click();
	}

	
	/* Method to click on DropDown */
	public void clickDropDown() {
		Select se = new Select(driver.findElement(By.xpath("//div[@id=\"convertRequestId\"]")));
		List<WebElement> webElementList = se.getOptions();
		if(webElementList.size()>1) {
			se.selectByIndex(webElementList.size() - 1);
		}else if(webElementList.size()<2){
			se.selectByIndex(1);
		}
	}
//	public String confirmRequest() {
//		if(convetPage.checkServerUpStatus.("indicator green")) {
//			System.out.println(convetPage.checkServerUpStatus);
//		}
//		else if(convetPage.checkServerDownStatus.equals("indicator red")) {
//			System.out.println(convetPage.checkServerDownStatus);
//		}
//		return confirmRequest();
//	}

}
