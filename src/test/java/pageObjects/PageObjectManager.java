package pageObjects;

import org.openqa.selenium.WebDriver;



public class PageObjectManager {
	
	public LandingPage landingPageObj;
	public OffersPage offersPageObj;
	public CheckoutPage checkoutPageObj;
    public WebDriver driver;
    
    
    public PageObjectManager(WebDriver driver) {
    	
    	this.driver=driver;
    	
    }
    
    public LandingPage getLandingPage() {
    	
    	landingPageObj= new LandingPage(driver);
    	return landingPageObj;
    	
    }
    
    public OffersPage getOffersPage() {
    	
    	offersPageObj= new OffersPage(driver);
    	
    	return offersPageObj;
    }
    
    public CheckoutPage getCheckoutPage() {
    	
    	checkoutPageObj = new CheckoutPage(driver);
    	
    	return checkoutPageObj;
    }
	
}
