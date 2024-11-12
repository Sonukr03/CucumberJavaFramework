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
import utilis.TestContextSetUp;

public class LandingPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetUp testContextSetUp;
	LandingPage landingPageObj;

	public LandingPageStepDefination(TestContextSetUp testContextSetUp) {

		this.testContextSetUp = testContextSetUp;
		this.landingPageObj = testContextSetUp.pageObjectManager.getLandingPage();

	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() throws InterruptedException {
		// System.setProperty("webdriver.chrome,driver",
		// "/Users/arnu/Downloads/chromedriver-mac-x64/chromedriver");

		Thread.sleep(1000);
		Assert.assertTrue(landingPageObj.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

		landingPageObj.searchItem(shortName);
		Thread.sleep(1000);
		testContextSetUp.landingPageProductName = landingPageObj.getProductName().split("-")[0].trim();
		System.out.println("productName is extracted from Home Page : " + testContextSetUp.landingPageProductName);
		Thread.sleep(1000);

	}

	@When("Added {string} items of Selected product to cart")
	public void added_items_of_Selected_product_to_cart(String Quantity) {

		landingPageObj.incrementQuantity(Integer.parseInt(Quantity));
		landingPageObj.addToCart();

	}

}
