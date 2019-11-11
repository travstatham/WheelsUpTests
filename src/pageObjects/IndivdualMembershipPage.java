package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IndivdualMembershipPage extends BasePage{

	public IndivdualMembershipPage(WebDriver driver) {
		super(driver);
	}

//	//- Scroll to section “Becoming a Wheels Up Core Member is easy”
//		 WebElement isEasyText = driver.findElement(By.xpath("//h1[contains(text(),'Becoming a Wheels Up Core Member is easy')]"));
//		 //WebElement element = driver.findElement(By.id("my-id"));
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(isEasyText);
//		 actions.perform();
//		 System.out.println("isEasyText is: " + isEasyText.getAttribute("innerHTML"));
//		 wait3();
//		 //- Print out “ONE-TIME INITIATION FEE”
//		 WebElement oneTimeInitiationFeeText = driver.findElement(By.xpath("//h3[contains(text(),'One-time initiation fee')]"));
//		 logger.info("One Time Init Fee is: " + oneTimeInitiationFeeText.getAttribute("innerHTML"));
//		 //- Scroll to “Learn more today” section (Enter first and last name)
//		 WebElement firstNameTextEntry = driver.findElement(By.xpath("//input[@id='FirstName-clone']"));
//		 firstNameTextEntry.sendKeys("Travis");
//
//		 WebElement lastNameTextEntry = driver.findElement(By.xpath("//input[@id='LastName-clone']"));
//		 lastNameTextEntry.sendKeys("Statham");
//		 //- Click continue
//		 WebElement continueButton = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-page[1]/div[1]/div[1]/div[2]/app-soft-footer-module[1]/div[1]/div[3]/div[1]/div[2]/div[2]/app-button[1]/a[1]"));
//		 continueButton.click();
//		 wait3();
	//Web Elements
	public By headerBecomingWheelsUpCoreMemberText = By.xpath("//h1[contains(text(),'Becoming a Wheels Up Core Member is easy')]");
	public By oneTimeInitiationFeeText = By.xpath("//h3[contains(text(),'One-time initiation fee')]");
	public By firstNameTextEntry = By.xpath("//input[@id='FirstName-clone']");
	public By lastNameTextEntry = By.xpath("//input[@id='LastName-clone']");
	public By continueButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-page[1]/div[1]/div[1]/div[2]/app-soft-footer-module[1]/div[1]/div[3]/div[1]/div[2]/div[2]/app-button[1]/a[1]");
	
	
}
