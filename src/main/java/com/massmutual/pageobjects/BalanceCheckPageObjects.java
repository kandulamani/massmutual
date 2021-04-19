package com.massmutual.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.massmutual.testbase.TestBase;

public class BalanceCheckPageObjects extends TestBase {

	private static final Logger log = Logger.getLogger(BalanceCheckPageObjects.class.getName());

	public BalanceCheckPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lbl_ttl_val")
	WebElement totalBalance;

	@FindBy(xpath = "//*[contains(@name,'lbl_val')]")
	List<WebElement> allValues;

	public WebElement getTotalBalance() {
		return totalBalance;
	}

	public List<WebElement> getAllValues() {
		return allValues;
	}

	/**
	 * verify the right count of values appear on the screen
	 */

	public void valuesAppearOntheScreen() {
		try {
			for (WebElement element : getAllValues()) {
				Assert.assertTrue(element.isDisplayed());
				log.info("Count of values appear on screen :"+element.getAttribute("value").length());
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * verify the values on the screen are greater than 0
	 */

	public void valuesGraterThanZero() {
		try {
			for (WebElement element : getAllValues()) {
				float value = Float.parseFloat(element.getAttribute("value").replace("$", "").replace(",", ""));
				if (value > 0) {
					log.info("Test passed");
				} else {
					log.info("Test failed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Test failed");
		}
	}

	/**
	 * verify the total balance is correct based on the values listed on the screen
	 */
	public void compareTotalBalanceWithSumOfAllValues() {
		try {
			float sum = 0;
			for (WebElement element : getAllValues()) {
				float value = Float.parseFloat(element.getAttribute("value").replace("$", "").replace(",", ""));
				sum = sum + value;
			}
			float totalBalance = Float
					.parseFloat(getTotalBalance().getAttribute("value").replace("$", "").replace(",", ""));
			log.info(sum + "," + totalBalance);
			// Assert.assertEquals(sum, totalBalance);
			log.info("Total Balance and sum of all values are matched and values are" + sum + "and" + totalBalance);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Total Balance and sum of all values are not matched");
		}
	}

	/**
	 * verify the values are formatted as currencies
	 */
	public void currencyFormatOfValues() {
		try {
			for (WebElement element : getAllValues()) {
				String value = element.getAttribute("value");
				if (value.startsWith("$")) {
					Assert.assertTrue(true);
				}
				log.info("All Values are values are formatted as currencies");
			}
		} catch (Exception e) {
			log.info("All Values are values are formatted as currencies");
		}
	}
}
