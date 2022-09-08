package pages;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageUsersPage {
	public WebDriver driver;
	WebDriverWait wait;
	Actions at;
	
	public ManageUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/* Element locator to identify Manage Users Tile */
	@FindBy(xpath = "//div[text()='Manage users']")
	WebElement manageUsersTile;
	
	/* Element locator to identify users row count */
	@FindBy(xpath = "//tr")
	WebElement getRowCount;
	
	/* Element locator to identify Add New button */
	@FindBy(xpath = "//button[text()='Add New']")
	WebElement addNewBtn;
	
	/* Element locator to identify Name input field */
	@FindBy(id = "name")
	WebElement enterName;
	
	/* Element locator to identify Select Roel field */
	@FindBy(xpath = "(//button)[7]")
	WebElement selectRoleDropdown;
	
	/* Element locator to capture Roles */
	@FindBy(xpath = "//div[@id=\"downshift-3054-menu\"]")
	WebElement captureRoles;
	
	/* Element locator to click on Admin*/
	@FindBy(xpath = "//div[@id=\"downshift-0-item-2\"]")
	WebElement selectRole;
	
	/* Element locator to identify Email input field */
	@FindBy(id = "email")
	WebElement inputEmail;
	
	/* Element locator to identify Username input field */
	@FindBy(id = "username")
	WebElement inputUsername;
	
	/* Element locator to identify Password input field*/
	@FindBy(id = "password")
	WebElement inputPassword;
	
	/* Element locator to identify Add User button */
	@FindBy(xpath = "//button[text()=\"Add User\"]")
	WebElement addUserBtn;
	
	/* Element locator to identify Ok button */
	@FindBy(xpath = "//button[text()=\"Ok\"]")
	WebElement clickOkBtn;
	
	/* Element locator to identify Help? */
	@FindBy(xpath = "//div[@title=\"Help ?\"]")
	WebElement usersHelp;
	
	/* Element locator to identify next button */
	@FindBy(xpath = "//a[text()=\"Next\"]")
	WebElement nxtBtn;

	/* Element locator to identify done button */
	@FindBy(xpath = "//a[text()=\"Done\"]")
	WebElement doneBtn;
	
	/* Element locator to identify go back button*/
	@FindBy(xpath = "//a[text()=\"Go Back\"]")
	WebElement goBack;
	
	
	/* Method to click on Manage Users Tile */
	public void clickOnManageUsersTile() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(manageUsersTile));
		manageUsersTile.click();
		Thread.sleep(3000);
	}
	
	/* Method to get row count */
	public void getUserRowCount() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(getRowCount));
	 Dimension getCount = getRowCount.getSize();
	 System.out.println(getCount);
	}
	
	
	/* Method to click on go back button*/
	public void clickGoBack() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(goBack));
		goBack.click();
	}
	
	
	/* Method to click on Add New button */
	public void clickOnAddNewBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(addNewBtn));
		addNewBtn.click();
	}
	
	/* Method to enter input for Name field */
	public void enterName(String name) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(enterName));
		enterName.sendKeys(name);
		Thread.sleep(2000);
	}
	
	/* Method to select role field */
	public void clickOnSelectRole() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(selectRoleDropdown));
		selectRoleDropdown.click();
	}
	
	/* Method to capture roles */
	public void captureRoles() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(captureRoles));
		String getRoles = captureRoles.getText();
		System.out.println(getRoles);
	}
	
	
	/* Method to click on Admin Role */
	public void selectAdminRole() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(selectRole));
		selectRole.click();
	}
	
	
	/* Method to input Email field */
	public void inputEmail(String email) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(inputEmail));
		inputEmail.sendKeys(email);
		Thread.sleep(2000);
	}
	
	/* Method to input username field */
	public void inputUsername(String username) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(inputUsername));
		inputUsername.sendKeys(username);
		Thread.sleep(2000);
	}
	
	/* Method to input password field */
	public void inputPassword(String password) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(inputPassword));
		inputPassword.sendKeys(password);
		Thread.sleep(2000);
	}
	
	/* Method to click Add User button */
	public void clickAddUserBtn() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(addUserBtn));
		addUserBtn.click();
		Thread.sleep(2000);
	}
	
	/* Method to click Ok button */
	public void clickOkBtn() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(clickOkBtn));
		clickOkBtn.click();
		Thread.sleep(2000);
	}
	
	/* Method to start convert tab walkthrough */
	public void usersWalkthrough() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(usersHelp));
		usersHelp.click();
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
	
}
