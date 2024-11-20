package utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String url = prop.getProperty("QAurl");
		String browser_porprties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		// java ternary operator --> result = testCondition ? value1 : value2;
		
		String browser= browser_maven!=null ? browser_maven : browser_porprties;

		if (driver == null) {

			if (browser.equalsIgnoreCase("chrome")) {

				//System.setProperty("webdriver.chrome,driver",
				//		System.getProperty("user.dir") + "/src/test/resources/chromedriver");
				
				
				// Set W3C-compliant capabilities
		        MutableCapabilities capabilities = new MutableCapabilities();

		        // BrowserStack-specific settings
		        MutableCapabilities browserstackOptions = new MutableCapabilities();
		        browserstackOptions.setCapability("os", "Windows");
		        browserstackOptions.setCapability("osVersion", "11");
		        browserstackOptions.setCapability("resolution", "1920x1080");
		        browserstackOptions.setCapability("browserVersion", "latest");
		        browserstackOptions.setCapability("projectName", "BrowserStack Integration");
		        browserstackOptions.setCapability("buildName", "Build-1");
		        browserstackOptions.setCapability("sessionName", "Sample Test");

		        // Add browserstackOptions to main capabilities
		        capabilities.setCapability("bstack:options", browserstackOptions);
		        capabilities.setCapability("browserName", "Chrome");

			        // Replace USERNAME and ACCESS_KEY with your BrowserStack credentials
			        String username = "sonukumar_fumScC";
			        String accessKey = "Hqx7bCuZf9krCQabWJhq";
			        
			    String URll =    "https://sonukumar_fumScC:Hqx7bCuZf9krCQabWJhq@hub-cloud.browserstack.com/wd/hub";

			//        URL browserStackUrl = new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");

			        driver = new RemoteWebDriver(new URL(URll), capabilities);
			       // driver.get("https://www.example.com");
				
				
				//-------------=================---------------===========-------------
				//driver = new ChromeDriver();
			}

			else if (browser.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko,driver",
				System.getProperty("user.dir") + "/src/test/resources/geckodriver");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}

		return driver;
	}

}
