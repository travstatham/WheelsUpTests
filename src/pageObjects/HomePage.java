package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//Page Variables
	String baseURL = "https://wheelsup.com";
	
	//By IDs for WebElements
	public static final By headingText = By.xpath("//h1[@class='heading ui-reveal']");
	public static final By emailAddressText = By.xpath("//ul[@id='option_3']//li[2]");
	public static final By phoneNumberText = By.xpath("//ul[@id='option_3']//li[1]");
	public static final By addressFindUsText = By.xpath("//span[@class='base-label']");
	public static final By membershipOptionsButton = By.xpath("//li[1]//app-menu-item[1]//div[1]");
	public static final By coreOptionsButton = By.xpath("//a[contains(text(),'CORE MEMBERSHIP')]");
	 
	public HomePage loadHomePage() {
		driver.get(baseURL);
		return this;
	}
	
	public HomePage scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		return this;
	}
	public HomePage scrollToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,- document.body.scrollHeight)");
		return this;
	}
	
	public void goToCoreMembershipPage() {
		click(membershipOptionsButton);
		explicitWait();
		click(coreOptionsButton);
	}
	 
}
