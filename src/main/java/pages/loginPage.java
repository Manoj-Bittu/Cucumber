package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import java.time.Duration;

public class loginPage {
	public WebDriver driver;
	Scenario scn;
	WebDriverWait wait;

	/*
	 * Constructor for the LoginPage
	 */
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Locating the Elements with their tags names
	 */
	@FindBy(xpath = "//input[@id=\"username\"]")
	WebElement user_name;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement user_password;

	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElement loginbtn;

	@FindBy(xpath = "//h2[text()=\"Dashboard\"]")
	WebElement dashboard_txt;

	@FindBy(xpath = "//h4[text()=\"Admin\"]")
	WebElement getwelcome_text;

	/*
	 * Methods to perform actions on the Located elements
	 */
	public void inputUsername(String username) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(user_name));
		user_name.sendKeys(username);
	}

	public void inputPassword(String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(user_password));
		user_password.sendKeys(password);
	}

	public void clickLoginBtn() throws InterruptedException {
		loginbtn.click();
		Thread.sleep(2000);
	}

	public String getHeadingTxt() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashboard_txt));
		String getText = dashboard_txt.getText();
		return getText;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println(pageUrl);
		return pageUrl;
	}

	public String getWelcomeText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(getwelcome_text));
		String getText = getwelcome_text.getText();
		return getText;
	}

}
