package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndivdualMembershipPage extends BasePage{

	public IndivdualMembershipPage(WebDriver driver) {
		super(driver);
	}
	
	//By IDs for WebElements
	public static final By headerBecomingWheelsUpCoreMemberText = By.xpath("//h1[contains(text(),'Becoming a Wheels Up Core Member is easy')]");
	public static final By oneTimeInitiationFeeText = By.xpath("//h3[contains(text(),'One-time initiation fee')]");
	public static final By firstNameTextEntry = By.xpath("//input[@id='FirstName-clone']");
	public static final By lastNameTextEntry = By.xpath("//input[@id='LastName-clone']");
	public static final By continueButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-page[1]/div[1]/div[1]/div[2]/app-soft-footer-module[1]/div[1]/div[3]/div[1]/div[2]/div[2]/app-button[1]/a[1]");
}
