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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utilis.TestContextSetUp;

public class CheckOutPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetUp testContextSetUp;
	public CheckoutPage checkoutPageObj;

	public CheckOutPageStepDefination(TestContextSetUp testContextSetUp) {

		this.testContextSetUp = testContextSetUp;
		this.checkoutPageObj = testContextSetUp.pageObjectManager.getCheckoutPage();

	}

	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {

		// checkoutPageObj = testContextSetUp.pageObjectManager.getCheckoutPage();
		Assert.assertTrue(checkoutPageObj.verifyPlaceOrder());
	}

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_Checkout(String Name) throws InterruptedException {

		checkoutPageObj.CheckOutItems();
		Thread.sleep(1000);
		String checkOutPageProductName = checkoutPageObj.getCheckOutPagrProductName().split("-")[0].trim();
		Assert.assertTrue(checkOutPageProductName.contains(Name));

	}
}
