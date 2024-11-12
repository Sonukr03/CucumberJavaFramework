package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utilis.TestContextSetUp;

public class OffersPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetUp testContextSetUp;
	PageObjectManager pageObjectManager;
	LandingPage landingPageObj;
	OffersPage offersPageObj;
	
	public OffersPageStepDefination(TestContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
		this.offersPageObj = testContextSetUp.pageObjectManager.getOffersPage();
		this.landingPageObj= testContextSetUp.pageObjectManager.getLandingPage();
	}

		
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		
	
	    switchToOffersPage();
	    offersPageObj.searchItem(shortName);
	    Thread.sleep(2000);
	    offersPageProductName= offersPageObj.getProductName();
	    
	}
	
	@Then("Validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {
		
		Assert.assertEquals(offersPageProductName, testContextSetUp.landingPageProductName);
	}
	
	public void switchToOffersPage() {
		
		//pageObjectManager = new PageObjectManager(testContextSetUp.driver);
		landingPageObj.selectTopDealsPage();
		//testContextSetUp.driver.findElement(By.linkText("Top Deals")).click();
	    testContextSetUp.genericUtils.switchWindowToChild();
		
	}

}
