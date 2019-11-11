package tests;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.IndivdualMembershipPage;
import pageObjects.RequestInfoPage;
import utils.SocialResponses;
import utils.Utils;

public class TestWheelsUp extends BaseTest {

	// Page Objects
	HomePage homePage;
	IndivdualMembershipPage indivMembershipPage;
	RequestInfoPage requestInfoPage;

	// Tests
	@Test
	public void testWheelsUpWebsite() {
		homePage = new HomePage(driver);
		homePage.loadHomePage();
		String actualHeadingText = homePage.readHeaderText(HomePage.headingText);
		System.out.println("The Homepage Heading says: " + actualHeadingText);
		assertEquals(actualHeadingText, "A Revolution Has Taken Flight");
		homePage.scrollToBottom(driver);
		String actualEmailAddress = homePage.readText(HomePage.emailAddressText);
		System.out.println("The Email Address is: " + actualEmailAddress);
		assertEquals(actualEmailAddress, "INFO@WHEELSUP.COM");
		String actualPhoneNumberText = homePage.readText(HomePage.phoneNumberText);
		System.out.println("The Phone Number is: " + actualPhoneNumberText);
		assertEquals(actualPhoneNumberText, "855-FLY-8760");
		String actualAddressFindUs = homePage.readText(HomePage.addressFindUsText);
		System.out.println("The Address for WheelsUp is: " + actualAddressFindUs);
		assertEquals(actualAddressFindUs, "220 West 42nd St\nNew York, NY 10036");
		homePage.scrollToTop(driver);
		homePage.explicitWait();
		homePage.goToCoreMembershipPage();
		homePage.explicitWait();
		indivMembershipPage = new IndivdualMembershipPage(driver);

		indivMembershipPage.moveToElement(IndivdualMembershipPage.headerBecomingWheelsUpCoreMemberText);
		String actualCoreMembershipHeaderText = indivMembershipPage
				.readHeaderText(IndivdualMembershipPage.headerBecomingWheelsUpCoreMemberText);
		System.out.println("The Individual Membership/Core Membership Header says: " + actualCoreMembershipHeaderText);
		assertEquals(actualCoreMembershipHeaderText, "Becoming a Wheels Up Core Member is easy");
		indivMembershipPage.explicitWait();
		indivMembershipPage.moveToElement(IndivdualMembershipPage.oneTimeInitiationFeeText);
		String actualOneTimeInitiationFee = indivMembershipPage
				.readHeaderText(IndivdualMembershipPage.oneTimeInitiationFeeText);
		System.out.println("One Time Init Fee is: " + actualOneTimeInitiationFee);
		assertEquals(actualOneTimeInitiationFee, "One-time initiation fee");
		indivMembershipPage.explicitWait();
		indivMembershipPage.moveToElement(IndivdualMembershipPage.firstNameTextEntry);
		indivMembershipPage.writeText(IndivdualMembershipPage.firstNameTextEntry, "Travis");
		indivMembershipPage.writeText(IndivdualMembershipPage.lastNameTextEntry, "Statham");
		indivMembershipPage.click(IndivdualMembershipPage.continueButton);
		requestInfoPage = new RequestInfoPage(driver);
		requestInfoPage.writeText(requestInfoPage.emailEntry, "travis@wheelsup.com");
		requestInfoPage.writeText(requestInfoPage.phoneEntry, "2035505005");
		requestInfoPage.writeText(requestInfoPage.companyEntry, "Wheels Down");
		requestInfoPage.writeText(requestInfoPage.addressEntry, "650 5th Ave");
		requestInfoPage.writeText(requestInfoPage.cityEntry, "New York");
		requestInfoPage.writeText(requestInfoPage.postalCodeEntry, "10001");
		requestInfoPage.writeText(requestInfoPage.stateEntry, "NY");
		requestInfoPage.writeText(requestInfoPage.countryEntry, "USA");
		requestInfoPage.explicitWait();
		requestInfoPage.moveToElement(requestInfoPage.secondHome);
		requestInfoPage.explicitWait();
		requestInfoPage.click(requestInfoPage.privateFlightsPerYear);
		requestInfoPage.explicitWait();
		requestInfoPage.click(requestInfoPage.oneToFiveDropdownOptions);
		requestInfoPage.click(requestInfoPage.yesToTravelWithPets);
		requestInfoPage.moveToElement(requestInfoPage.jetCard);
		requestInfoPage.click(requestInfoPage.secondHomeSelection);
		requestInfoPage.explicitWait();
		requestInfoPage.click(requestInfoPage.secondHomeSelectNo);
		requestInfoPage.click(requestInfoPage.commercialFlightOption);
		requestInfoPage.moveToElement(requestInfoPage.wheelsUpBusinessMembership);
		requestInfoPage.click(requestInfoPage.wheelsUpConnectMembership);
		requestInfoPage.moveToElement(requestInfoPage.textArea);

		requestInfoPage.click(requestInfoPage.hearAboutUsDropdown);
		requestInfoPage.click(requestInfoPage.emailFromWheelsUpSelection);
		requestInfoPage.writeText(requestInfoPage.textArea, "Do you fly out of Westchester?");
		requestInfoPage.explicitWait();
		requestInfoPage.click(requestInfoPage.closeButton);
		requestInfoPage.explicitWait();
	}

	@Test
	public void testSocialAccounts() throws IOException {
		String twitter = "https://twitter.com/WheelsUp";
		String instagram = "http://instagram.com/wheelsup8760";
		SocialResponses responses = Utils.verifySocialAccounts(twitter, instagram);
		assertThat(twitter, Matchers.is(responses.getTwitter()));
		assertThat(instagram, Matchers.is(responses.getInstagram()));
	}
}
