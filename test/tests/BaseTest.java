package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
 
public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void setup () {
        //Create a Chrome driver. 
    	System.setProperty("webdriver.chrome.driver","drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }
 
    @AfterTest
    public void teardown () {
        driver.quit();
    }
}