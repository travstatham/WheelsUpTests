package tests;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.HomePage;
import pageObjects.IndivdualMembershipPage;
import pageObjects.RequestInfoPage;

public class TestWheelsUp extends BaseTest{

	//Page Objects
	HomePage homePage;
	IndivdualMembershipPage indivMembershipPage;
	RequestInfoPage requestInfoPage;
    
	//Tests
    @Test
    public void testWheelsUpWebsite() {
    	homePage = new HomePage(driver);
    	homePage.loadHomePage();
    	System.out.println("The Heading says: " + homePage.readHeaderText(homePage.headingText));
    	homePage.scrollToBottom(driver);
    	System.out.println("The Email Address is: " + homePage.readText(homePage.emailAddressText));
    	System.out.println("The Phone Number is: " + homePage.readText(homePage.phoneNumberText));
    	System.out.println("The Address for WheelsUp is: " + homePage.readText(homePage.addressFindUsText));
    	homePage.scrollToTop(driver);
    	homePage.explicitWait();
    	homePage.goToCoreMembershipPage();
    	homePage.explicitWait();
    	indivMembershipPage = new IndivdualMembershipPage(driver); 
    	
    	indivMembershipPage.moveToElement(indivMembershipPage.headerBecomingWheelsUpCoreMemberText);
    	System.out.println("The Individual Membership/Core Membership Header says: " + indivMembershipPage.readHeaderText(indivMembershipPage.headerBecomingWheelsUpCoreMemberText));
    	indivMembershipPage.explicitWait();
    	indivMembershipPage.moveToElement(indivMembershipPage.oneTimeInitiationFeeText);
    	System.out.println("One Time Init Fee is: " + indivMembershipPage.readHeaderText(indivMembershipPage.oneTimeInitiationFeeText));
    	indivMembershipPage.explicitWait();
    	indivMembershipPage.moveToElement(indivMembershipPage.firstNameTextEntry);
    	indivMembershipPage.writeText(indivMembershipPage.firstNameTextEntry, "Travis");
    	indivMembershipPage.writeText(indivMembershipPage.lastNameTextEntry, "Statham");
    	indivMembershipPage.click(indivMembershipPage.continueButton);
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
    
//    - Create a method called “verifySocialAccounts(String twitter, String instagram)”
//    - Twitter “https://twitter.com/WheelsUp”
//    - Instagram “http://instagram.com/wheelsup8760”
//    - Use this endpoint (https://marketingapi.wheelsup.com/api/initial-data/)
//    - Get the JSON response and parse it
//    - Verify if passed social accounts matches the fields from the JSON response (Use any
//    class assert)
    
    @Test
    public void testSocialAccounts() throws IOException {
    	String twitter = "https://twitter.com/WheelsUp";
    	String instagram = "http://instagram.com/wheelsup8760";
    	SocialResponses responses = verifySocialAccounts(twitter, instagram);
    	
    	assertThat( twitter, Matchers.is( responses.getTwitter() ) );
	    assertThat( instagram, Matchers.is( responses.getInstagram()));
    }
    public SocialResponses verifySocialAccounts(String twitter, String instagram) {
    	
    	String endpoint = "https://marketingapi.wheelsup.com/api/initial-data/";
        HttpUriRequest request = new HttpGet( endpoint );
     
        // When
        HttpResponse httpResponse = null;
        SocialResponses resource = null;
		try {
			httpResponse = HttpClientBuilder.create().build().execute( request );
			resource = retrieveResourceFromResponse(httpResponse, SocialResponses.class);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return resource;
        
    }
   
    	
    
    public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) 
    		  throws IOException {
    		  
	    String jsonFromResponse = EntityUtils.toString(response.getEntity());
	    ObjectMapper mapper = new ObjectMapper()
	      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    return mapper.readValue(jsonFromResponse, clazz);
	    
//	    {"keys":
//	    {"mapbox_accesstoken":"pk.eyJ1IjoiaGF5c29tIiwiYSI6ImNqMXphNzhiMTAxbGMyd3FsY2p6cTRkaDUifQ.i1LAjsh8bZTnx26Q6ltVhw",
//	    	"marketo_form_account":"541-LAT-007",
//	    	"marketo_form_id":"3101",
//	    	"instagram":"http://instagram.com/wheelsup8760",
//	    	"email":"info@wheelsup.com",
//	    	"google_places":"AIzaSyAuNQF6Dm6ESVt_dSc3xLHQHQNFemcOcfA",
//	    	"mapbox_flight_estimator_style":"mapbox://styles/haysom/cj7v13o5j2nqs2rn4zicugrql",
//	    	"twitter":"https://twitter.com/WheelsUp",
//	    	"footer_disclaimer":"Wheels Up does not operate aircraft; FAA licensed and DOT registered air carriers participating in the program exercise full operational control of all flights offered by or arranged through Wheels Up. For on-demand flights and shuttle flights operated as scheduled service, Wheels Up acts solely as an agent for Wheels Up members and guests in arranging these flights on their behalf. For shuttle flights operated as Public Charter service, Wheels Up acts as principal in offering these flights subject to the DOT’s Public Charter rules contained in 14 CFR Part 380. All aircraft owned or leased by Wheels Up are leased to the operating air carrier and are operated exclusively by that air carrier.",
//	    	"mapbox_style":"mapbox://styles/haysom/cj9zzc58490o72supmyf1aowh",
//	    	"google_tag_manager":"GTM-558MLHC",
//	    	"password":"",
//	    	"google_plus":"https://plus.google.com/+WheelsUp8760",
//	    	"facebook":"https://www.facebook.com/WheelsUp8760"},
//	    "header":[{"subitems":[{"title":"Connect Membership",
//	    		"url":"/connect-membership/"},
//	                           {"title":"Core Membership","url":"/individual-membership/"},{"title":"Business Membership","url":"/corporate-membership/"},{"title":"Membership Comparison","url":"/membership-comparison/"}],"title":"Membership Options"},{"subitems":[{"title":"King Air 350i","url":"/fleet/king-air-350i/"},{"title":"Citation Excel/XLS","url":"/fleet/citation-xls/"}],"title":"Members Only Fleet"},{"subitems":[],"title":"Charter Marketplace","url":"/charter-marketplace/"}],"redirects":{"fleet/flight-desk":"/fleet/king-air-350i/","company/testimonials?1744":"/our-story/","benefits-coordinator":"/our-story/","company/testimonials?1823":"/our-story/","financial-analyst":"/our-story/","cnbc_12-23_1.html":"/","membership":"/individual-membership/","vice-president-of-sales-3":"/our-story/","vice-president-of-sales-7":"/our-story/","membership/individual-and-family":"/individual-membership/","why-the-citation-excelxls":"/fleet/citation-xls/","fleet/king-air-350ifdsfsdfdsf":"/fleet/king-air-350i/","q-a":"/our-story/","fleet/the-wheels-up-citation-excelxls":"/fleet/citation-xls/","nyt":"http://www.wheelsup.com/request-info?utm_source=NYT&utm_medium=print&utm_campaign=NYT","company/wheelsup8760":"/our-story/","vice-president-of-sales-5":"/our-story/","company/news":"/our-story/","company/testimonials?3796":"/our-story/","digital-product-manager":"/our-story/","fleet":"/fleet/king-air-350i/","vice-president-of-sales-4":"/our-story/","company/testimonials?1926":"/our-story/","business-analyst-for-salesforce-com":"/our-story/","vice-president-of-sales-6":"/our-story/","careers":"https://careers-wheelsup.icims.com/jobs/search","senior-devops-engineer":"/our-story/","vice-president-of-sales-8":"/our-story/","range-map":"/","fleet/helicopter":"/fleet/king-air-350i/","why-the-king-air-350i":"/fleet/king-air-350i/","manager-talent-acquisition":"/our-story/","membership/corporate-membership":"/corporate-membership/","quiet-cabin-noise-control":"/fleet/king-air-350i/","range-and-travel-time":"/individual-membership/","form":"/request-info/","626":"/safety/","member-services-representative":"/our-story/","ux-ui-design-lead":"/our-story/","company/testimonials":"/our-story/","analyst-advanced-analytics":"/our-story/","wsj":"http://www.wheelsup.com/request-info?utm_source=WSJ&utm_medium=print&utm_campaign=WSJ","business-analyst":"/our-story/","advantages-over-traditional-charter-brokers":"/individual-membership/","evp-member-experience-and-retention":"/our-story/","company/our-story":"/our-story/","company/leadership":"/our-story/","wheels-down":"/our-story/","key-areas-of-safety-assessment":"/safety/"},"request-info":{"cta_text":"Request info","cta_url":"/request-info/"},"footer":[{"subitems":[{"title":"News","url":"/news/"},{"title":"Our Story","url":"/our-story/"},{"title":"Our Safety","url":"/safety/"},{"title":"Privacy Policy","url":"/privacypolicy/"}],"title":"About Us"},{"subitems":[],"title":"Ignore this! - test"},{"subitems":[{"title":"Member Events & Benefits","url":"/events-experiences/"},{"title":"Wheels Up Cares","url":"/wheelsupcares/"},{"title":"Careers","url":"https://careers-wheelsup.icims.com/jobs/search"},{"title":"Request Info","url":"/request-info/"}],"title":"Learn More"},{"subitems":[{"title":"855-FLY-8760","url":""},{"title":"info@wheelsup.com","url":"mailto:info@wheelsup.com"}],"title":"Contact Us"}]}
    }
}
