package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilis.TestContextSetUp;

public class Hooks {

	TestContextSetUp testContextSetUp;

	public Hooks(TestContextSetUp testContextSetUp) {

		this.testContextSetUp = testContextSetUp;

	}

	@After
	public void AfterScenario() throws IOException {

		testContextSetUp.testBase.WebDriverManager().quit();

	}

	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {

		WebDriver driver = testContextSetUp.testBase.WebDriverManager();
		
		if (scenario.isFailed()) {

			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourceFile);
			scenario.attach(fileContent, "image/png", "image");

		}

	}
}
