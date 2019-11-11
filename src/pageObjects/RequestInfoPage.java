package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestInfoPage extends BasePage {

	public RequestInfoPage(WebDriver driver) {
		super(driver);

	}
	public By emailEntry = By.cssSelector("#Email-clone");
	public By phoneEntry = By.cssSelector("#Phone-clone");
	public By companyEntry = By.cssSelector("#Company__c-clone");
	public By addressEntry = By.cssSelector("#Address-clone");
	public By cityEntry = By.cssSelector("#City-clone");
	public By postalCodeEntry = By.cssSelector("#PostalCode-clone");
	public By stateEntry = By.cssSelector("#State-clone");
	public By countryEntry = By.cssSelector("#Country-clone");
	public By travelWithPets = By.xpath("//p[contains(text(),'DO YOU HAVE A NEED TO TRAVEL WITH PETS?')]");
	public By secondHome = By.xpath("//p[contains(text(),'Do you own or travel to a second home?')]");
	public By privateFlightsPerYear = By.xpath("//div[@id='How_Many_Private_Flights_Per_Year__c-clone0']//div[@class='dropdown']");
	public By oneToFiveDropdownOptions = By.xpath("//div[@id='How_Many_Private_Flights_Per_Year__c-clone0']//li[2]");
	public By yesToTravelWithPets = By.xpath("//div[@id='Do_you_have_a_need_to_travel_with_pets__c-clone']//div[@class='listinputselect']//div[1]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]");
	public By jetCard = By.xpath("//div[@id='How_does_the_Lead_currently_Travel__c-clone']//div[3]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]");
	public By secondHomeSelection = By.xpath("//div[@id='Do_you_own_or_travel_to_a_second_home__c-cloneYes']//p[@class='label'][contains(text(),'Please select one')]");
	public By commercialFlightOption = By.xpath("//div[@id='How_does_the_Lead_currently_Travel__c-clone']//div[@class='listinputselect']//div[1]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]");
	public By secondHomeSelectNo = By.xpath("//li[@class='dropdown-box-items ng-star-inserted']//p[contains(text(),'No')]");
	public By wheelsUpConnectMembership = By.xpath("//div[@id='Product_Interest__c-clone']//div[@class='listinputselect']//div[1]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]");
	public By wheelsUpBusinessMembership = By.xpath("//div[@id='Product_Interest__c-clone']//div[3]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]");
	public By textArea = By.xpath("//textarea[@class='textarea-box']");
	public By hearAboutUsDropdown = By.xpath("//p[contains(text(),'Please select one')]");
	public By emailFromWheelsUpSelection = By.xpath("//div[@id='leadSourceWebList-cloneAdvertisement']//li[3]");
	public By closeButton = By.xpath("//div[@class='close']");
	
//	WebElement emailClone = driver.findElement(By.cssSelector("#Email-clone"));
//
//	 WebElement phoneClone = driver.findElement(By.cssSelector("#Phone-clone"));
//	 emailClone.sendKeys("travis@gmail.com");
//	 phoneClone.sendKeys("12035505005");
//	 wait3();
//
//	 WebElement companyClone = driver.findElement(By.cssSelector("#Company__c-clone"));
//	 WebElement addressClone = driver.findElement(By.cssSelector("#Address-clone"));
//	 companyClone.sendKeys("Wheels Up Then Down");
//	 addressClone.sendKeys("666 5th Ave");
//	 WebElement cityClone = driver.findElement(By.cssSelector("#City-clone"));
//	 cityClone.sendKeys("New York");
//	 WebElement zipCodeClone = driver.findElement(By.cssSelector("#PostalCode-clone"));
//	 zipCodeClone.sendKeys("10001");
//	 WebElement stateClone = driver.findElement(By.cssSelector("#State-clone"));
//	 stateClone.sendKeys("New York");
//	 WebElement countryClone = driver.findElement(By.cssSelector("#Country-clone"));
//	 countryClone.sendKeys("USA");
//	 
//	 WebElement travelWithPets = driver.findElement(By.xpath("//p[contains(text(),'DO YOU HAVE A NEED TO TRAVEL WITH PETS?')]"));
//	 WebElement secondHome = driver.findElement(By.xpath("//p[contains(text(),'Do you own or travel to a second home?')]"));
//	 actions.moveToElement(secondHome);
//	 actions.perform();
//	 wait3();
//	 
//	 //part2
//	 WebElement privateFlightsPerYear = driver.findElement(By.xpath("//div[@id='How_Many_Private_Flights_Per_Year__c-clone0']//div[@class='dropdown']"));
//	 privateFlightsPerYear.click();
//	 wait3();
//
//	 WebElement oneToFive = driver.findElement(By.xpath("//div[@id='How_Many_Private_Flights_Per_Year__c-clone0']//li[2]"));
//	 wait3();
//	 oneToFive.click();
//	 wait3();
//	 WebElement yesToPets = driver.findElement(By.xpath("//div[@id='Do_you_have_a_need_to_travel_with_pets__c-clone']//div[@class='listinputselect']//div[1]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]"));
//	 yesToPets.click();
//	 wait3();
//	 
//	 WebElement jetCard = driver.findElement(By.xpath("//div[@id='How_does_the_Lead_currently_Travel__c-clone']//div[3]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]"));
//	 actions.moveToElement(jetCard);
//	 actions.perform();
//	 logger.info("Moved to How do you currently fly?");
//	 wait3();
//	 WebElement secondHomeDropdown = driver.findElement(By.xpath("//div[@id='Do_you_own_or_travel_to_a_second_home__c-cloneYes']//p[@class='label'][contains(text(),'Please select one')]"));
//	 secondHomeDropdown.click();
//	 wait3();
//	 WebElement secondHomeNoAnswer = driver.findElement(By.xpath("//li[@class='dropdown-box-items ng-star-inserted']//p[contains(text(),'No')]"));
//	 secondHomeNoAnswer.click();
//	 wait3();
//	 WebElement commercialFlight = driver.findElement(By.xpath("//div[@id='How_does_the_Lead_currently_Travel__c-clone']//div[@class='listinputselect']//div[1]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]"));
//	 commercialFlight.click();
//	 wait3();
//	 //- Clich “X” at the top right corner
//	 WebElement wheelsUpConnectMembership = driver.findElement(By.xpath("//div[@id='Product_Interest__c-clone']//div[@class='listinputselect']//div[1]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]"));
//	 WebElement wheelsUpBusinessMembership = driver.findElement(By.xpath("//div[@id='Product_Interest__c-clone']//div[3]//app-input-select-box[1]//div[1]//div[1]//div[1]//label[1]"));
//	 actions.moveToElement(wheelsUpBusinessMembership);
//	 actions.perform();
//	 wait3();
//	 wheelsUpConnectMembership.click();
//	 wait3();
//	 WebElement textArea = driver.findElement(By.xpath("//textarea[@class='textarea-box']"));
//	 actions.moveToElement(textArea);
//	 actions.perform();
//	 wait3();
//	 WebElement hearAboutUsDropdown = driver.findElement(By.xpath("//p[contains(text(),'Please select one')]"));
//	 hearAboutUsDropdown.click();
//	 wait3();
//	 WebElement emailFromWheelsUpSelection = driver.findElement(By.xpath("//div[@id='leadSourceWebList-cloneAdvertisement']//li[3]"));
//	 emailFromWheelsUpSelection.click();
//	 wait3();
//	 textArea.sendKeys("Do you fly out of Westchester airport?");
//	 wait3();
//	 WebElement closeButton = driver.findElement(By.xpath("//div[@class='close']"));
//	 closeButton.click();
//	 wait3();
}
