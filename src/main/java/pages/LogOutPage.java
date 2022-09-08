package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutPage {
	public static WebDriver driver;

	public static WebDriverWait wait;

	/* Constructor for the dashboardPage */
	public LogOutPage(WebDriver driver) {
		LogOutPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label=\"Logout\"]")
	WebElement logoutBtn;
	
	public void clickLogOutBtn() throws InterruptedException {
		Thread.sleep(3000);
		logoutBtn.click();
	}
}
