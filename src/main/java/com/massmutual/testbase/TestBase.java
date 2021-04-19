package com.massmutual.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Properties OR = new Properties();
	private static final Logger log = Logger.getLogger(TestBase.class.getName());

	/**
	 * Load the data from external properties file
	 * 
	 * @param fileName
	 */
	public void loadData(String fileName) {
		try {
			File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\massmutual\\config\\"
					+ fileName + ".properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			OR.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To launch a specific browser
	 * 
	 * @param browser
	 * @return
	 */
	public void init_driver(String browser) {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		log.info("navigating to :-" + browser + " browser");
		System.out.println("Browser value is :-" + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
	}

	/**
	 * Browser Navigate to specified browser
	 * 
	 * @param url
	 */
	public void getUrl(String url) {
		driver.get(url);
		log.info("navigating to :-" + url);
		driver.manage().window().maximize();
	}

	/**
	 * ##################### perform Basic operations on WebElement
	 * ######################
	 */
	/**
	 * To perform click operation on a specific webElenment
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		try {
			element.click();
			log.info("To Perform Click Operation on : " + element);
		} catch (Exception e) {
			log.info("Not able to click on element : " + element);
		}
	}

	/**
	 * Click operation on specific element coordinates
	 * 
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 */
	public void clickCoordinates(WebElement element, int xOffset, int yOffset) {
		Actions actions = new Actions(driver);
		try {
			actions.moveToElement(element, xOffset, yOffset).click().build().perform();
			log.info("To Perform Click Operation on on Coordinates : " + element);
		} catch (Exception e) {
			log.info("Not able to click on Coordinates : " + element);
		}
	}

	/**
	 * Enter text into a particular textbaox/WebElement
	 * 
	 * @param element
	 * @param text
	 */
	public void enterTextInElement(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			log.info("Entered text into Element and text is : " + text);
		} catch (Exception e) {
			log.info("Not able to enter text into element : " + element);
		}
	}

	/**
	 * To get css attribute vale of particular element
	 * 
	 * @param element
	 * @param attribute
	 * @return
	 */
	public String getElementCSSValue(WebElement element, String attribute) {
		String cssValue = "";
		try {
			cssValue = element.getCssValue(attribute);
			log.info("To get Element CSS value : " + cssValue);
		} catch (Exception e) {
			log.info("Not able to get Element CSS value : " + element);
		}
		return cssValue;
	}

	/**
	 * To get webElement width
	 * 
	 * @param element
	 * @return
	 */
	public int getElementWidth(WebElement element) {
		int width = 0;
		try {
			width = element.getSize().getWidth();
			log.info("The width of Element is : " + width);
		} catch (Exception e) {
			log.info("Unable to get width of the Element : " + element);
		}
		return width;
	}

	/**
	 * To get WebElement coordinates
	 * 
	 * @param element
	 */
	public void getCoordinatesOfElement(WebElement element) {
		try {
			Point point = element.getLocation();
			log.info("X Cordinates of selected Element is : " + point.getX());
			log.info("Y Cordinates of selected Element is : " + point.getY());
		} catch (Exception e) {
			log.info("Not able to Identifi the X and Y Coordinates :- ");
		}
	}

	/**
	 * To get WebElement text
	 * 
	 * @param element
	 * @return
	 */
	public String getElementText(WebElement element) {
		String text = "";
		try {
			text = element.getText();
			log.info("The Text of the Element is : " + text);
		} catch (Exception e) {
			log.info("Unable to get the text of the Element : " + element);
		}
		return text;
	}

	/**
	 * To get all links count in a webPage
	 */
	public void getAllLinksCount() {
		try {
			List<WebElement> element = driver.findElements(By.tagName("a"));
			log.info("All Links in Current Web Page : " + element.size());
			for (WebElement allElements : element) {
				log.info("All Links Text : " + allElements.getText());
			}
		} catch (Exception e) {
			log.info("Not able to find the Links");
		}
	}

	/**
	 * To verify element is displayed or not in web Page
	 * 
	 * @param element
	 */
	public void elementIsDisplayed(WebElement element) {
		boolean elementStatus = element.isDisplayed();
		log.info("element is Displayed and Status is : " + elementStatus);
		Assert.assertTrue(elementStatus);
	}

	/**
	 * To verify element is enabled or not in web Page
	 * 
	 * @param element
	 */
	public void elementIsEnabled(WebElement element) {
		boolean elementStatus = element.isEnabled();
		log.info("element is Enabled and Status is : " + elementStatus);
		Assert.assertTrue(elementStatus);
	}

	/**
	 * To verify element is selected or not in web Page
	 * 
	 * @param element
	 */
	public void elementIsSelected(WebElement element) {
		element.click();
		boolean elementStatus = element.isSelected();
		log.info("element is Selected and Status is : " + elementStatus);
		Assert.assertTrue(elementStatus);
	}
	// *****************************************Operations on
	// JavascriptExecutor***************************************

	/*
	 * To perform JavaScript execution
	 * 
	 */
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info(script);
		return exe.executeScript(script);
	}

	/*
	 * To perform JavaScript execution
	 * 
	 * @param script
	 * 
	 * @param args
	 */
	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info(script);
		return exe.executeScript(script, args);
	}

	/*
	 * To perform scroll into particular WebElement
	 * 
	 * @param element
	 * 
	 */
	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
		log.info(element);
	}

	/*
	 * To perform scroll into particular WebElement and perform click operation
	 * 
	 * @param element
	 * 
	 */
	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		log.info(element);
	}

	/*
	 * To perform scroll into particular WebElement
	 * 
	 * @param element
	 * 
	 */
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		log.info(element);
	}

	/*
	 * To perform scroll into particular WebElement and click
	 * 
	 * @param element
	 * 
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info(element);
	}

	/*
	 * To perform scroll Down operation vertically
	 * 
	 */
	public void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/*
	 * To perform scroll Up operation vertically
	 * 
	 */
	public void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	/*
	 * To perform scroll Down operation by pixels
	 * 
	 */
	public void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
	}

	/*
	 * To perform scroll Up operation by pixels
	 * 
	 */
	public void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	/*
	 * To perform Zoom operation by percentage
	 * 
	 */
	public void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	/*
	 * To perform Zoom operation by 100 percentage
	 * 
	 */
	public void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	/*
	 * Scroll to particular web element
	 * 
	 * @param element
	 * 
	 */
	public void ScrollByElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * To perform click operation with JavaScript
	 * 
	 * @param element
	 */
	public void clickOperation(WebElement element) {
		try {
			executeScript("arguments[0].click();", element);
			log.info("To Perform Click Operation on : " + element);
		} catch (Exception e) {
			log.info("Not able to click on element : " + element);
		}
	}

	/**
	 * TO Perform sendKeys operation with java script
	 * 
	 * @param element
	 * @param text
	 */
	public void sendKeysOperation(WebElement element, String text) {
		try {
			executeScript("arguments[0].value = '\" + text + \"'\"", element);
			log.info("To Perform SendKeys Operation on : " + element);
		} catch (Exception e) {
			log.info("Not able to SendKeys on element : " + element);
		}
	}

	/**
	 * To perform Highlighting an element operation
	 * 
	 * @param element
	 */
	public void highlightElement(WebElement element) {
		try {
			executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			log.info("To Perform Highlight element : " + element);
		} catch (Exception e) {
			log.info("Not able to highlight on element : " + element);
		}
	}

}
