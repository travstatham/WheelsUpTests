package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//Page Variables
	String baseURL = "https://wheelsup.com";
	
	//Web Elements
	
//	WebElement headingText = driver.findElement(By.xpath("//h1[@class='heading ui-reveal']"));
//	WebElement emailAddressText = driver.findElement(By.xpath("//ul[@id='option_3']//li[2]"));
//	WebElement phoneNumberText = driver.findElement(By.xpath("//ul[@id='option_3']//li[1]"));
//	WebElement addressFindUsText = driver.findElement(By.xpath("//span[@class='base-label']"));
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
	
	public void doStuff() {
	//HomePage
	//- Find and print out in the console the following title “A Revolution Has Taken Flight”
	//wait3();
	WebElement heading = driver.findElement(By.xpath("//h1[@class='heading ui-reveal']"));	
	
	System.out.println("heading is:" + heading.getAttribute("innerHTML"));
	
	//- Scroll to the bottom, print out phone number, email(Contact Us), and address(Find Us)

	 //JavascriptExecutor js = (JavascriptExecutor) driver;
	 //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	scrollToBottom(driver);
	 //wait3();
	 WebElement emailAddress = driver.findElement(By.xpath("//ul[@id='option_3']//li[2]"));
	 System.out.println("Email is:" + emailAddress.getText());
	 WebElement phoneNumber = driver.findElement(By.xpath("//ul[@id='option_3']//li[1]"));
	 System.out.println("PhoneNumber is:" + phoneNumber.getText());
	 WebElement addressFindUs = driver.findElement(By.xpath("//span[@class='base-label']"));
	 System.out.println("Address is:" + addressFindUs.getText());
	 //- Scroll up to the top of the page
	 //js.executeScript("window.scrollBy(0,- document.body.scrollHeight)");
	 //wait3();
	 //wait3();
	 //- Header menu, click “MEMBERSHIP OPTIONS” and then “CORE MEMBERSHIP”
	//li[1]//app-menu-item[1]//div[1]
	 WebElement membershipOptionsButton = driver.findElement(By.xpath("//li[1]//app-menu-item[1]//div[1]"));//   /a[contains(text(),'Membership Options')]"));
	 membershipOptionsButton.click();
	 //wait3();
	 WebElement coreOptionsButton = driver.findElement(By.xpath("//a[contains(text(),'CORE MEMBERSHIP')]"));
	 coreOptionsButton.click();
	 //wait3();
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
