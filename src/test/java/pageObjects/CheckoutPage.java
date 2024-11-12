package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
	}

	// private By search = ;//
	private By cartBag = By.cssSelector("img[alt='Cart']");
	private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoBtn = By.cssSelector("input.promoCode");
    private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
    private By checkOutPageProductName= By.cssSelector("p.product-name");
    
	// div.stepper-input > a.increment
	// //button[contains(text(),'ADD TO CART')]

	// //button[contains(text(),'PROCEED TO CHECKOUT')]
	
	//    input.promoCode
	//    button.promoBtn
	

	public void CheckOutItems() throws InterruptedException {

		driver.findElement(cartBag).click();
		//Thread.sleep(1000);
		driver.findElement(checkOutButton).click();;
		
	}
	
	public String getCheckOutPagrProductName() {
		
	return	driver.findElement(checkOutPageProductName).getText();
		
	}
	
	public boolean verifyPromoBtn() {
		
		return driver.findElement(promoBtn).isDisplayed();
	
	}
	
	public boolean verifyPlaceOrder() {
		
		return driver.findElement(placeOrder).isDisplayed();
	}

}
