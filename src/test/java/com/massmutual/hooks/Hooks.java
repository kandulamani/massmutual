package com.massmutual.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.massmutual.pageobjects.BalanceCheckPageObjects;
import com.massmutual.testbase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase {

	@Before(order = 0)
	public void launchBrowser() {
		loadData("config");
		init_driver(OR.getProperty("browser"));
		getUrl(System.getProperty("user.dir") + OR.getProperty("url"));

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshots
			String screenShotName = scenario.getName().replaceAll("", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);

		}
	}
}
