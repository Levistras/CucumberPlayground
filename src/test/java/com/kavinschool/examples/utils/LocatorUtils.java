package com.kavinschool.examples.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LocatorUtils {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private WebDriver driver;
	public static final long WAIT_TIME = 30L;

	/**
	 * Instantiates a new Common locators.
	 *
	 * @param driver the driver
	 */
	public LocatorUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Span with text web element.
	 *
	 * @param text the text
	 * @return the web element
	 */
	public WebElement spanWithText(final String text) {
		return spanWithText(text, "");
	}

	/**
	 * Span with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement spanWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "span", prefixLocator);
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Wait for span with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement waitForSpanWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "span", prefixLocator);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(locator)), text));
		return driver.findElement(By.xpath(locator));
	}

	public WebElement waitForText(final String text) {
		String locator = getLocator(text, "*", "");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(locator)), text));
		return driver.findElement(By.xpath(locator));
	}

	public String getText(final String text) {
		String locator = getLocatorText(text, "*", "");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(locator)), text));
		return driver.findElement(By.xpath(locator)).getText();
	}

	public String getTextContains(final String text) {
		String locator = getLocatorContainsText(text, "*", "");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.textToBe(By.xpath(locator), text));
		return driver.findElement(By.xpath(locator)).getText();
	}

	/**
	 * Div with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement divWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "div", prefixLocator);
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Div with text web element.
	 *
	 * @param text the text
	 * @return the web element
	 */
	public WebElement divWithText(final String text) {
		return divWithText(text, "");
	}

	/**
	 * Wait for div with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement waitForDivWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "div", prefixLocator);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
		// wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(locator)),
		// text));
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Wait for div with text web element.
	 *
	 * @param text the text
	 * @return the web element
	 */
	public WebElement waitForDivWithText(final String text) {
		return waitForDivWithText(text, "");
	}

	/**
	 * Link with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement linkWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "a", prefixLocator);
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Link with text web element.
	 *
	 * @param text the text
	 * @return the web element
	 */
	public WebElement linkWithText(final String text) {
		return linkWithText(text, "");
	}

	/**
	 * Wait for link with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement waitForLinkWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "a", prefixLocator);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Wait for link with text web element.
	 *
	 * @param text the text
	 * @return the web element
	 */
	public WebElement waitForLinkWithText(final String text) {
		return waitForLinkWithText(text, "");
	}

	/**
	 * Header with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement headerWithText(final String text, final String prefixLocator, final String headerTag) {
		String locator = getLocator(text, headerTag, prefixLocator);
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Header with text web element.
	 * <pre>
	 * headerWithText("headerTitle","h1")
	 * headerWithText("headerTitle","h2")
	 * headerWithText("headerTitle","h3")
	 *</pre>
	 * @param text the text
	 * @return the web element
	 */
	public WebElement headerWithText(final String text, final String headerTag) {
		return headerWithText(text, "", headerTag);
	}
	
//	public WebElement headerWithText(final String text, final String headerNum) {
//		return headerWithText(text, "");
//	}

	/**
	 * Wait for header with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement waitForHeaderWithText(final String text, final String prefixLocator, final String headerTag) {
		String locator = getLocator(text, headerTag, prefixLocator);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(locator)), text));
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Wait for header with text web element.
	 * waitForHeaderWithText("headerTitle","h1")
	 * waitForHeaderWithText("headerTitle","h2")
	 * waitForHeaderWithText("headerTitle","h3")
	 *
	 * @param text the text
	 * @return the web element
	 */
	public WebElement waitForHeaderWithText(final String text, final String headerTag) {
		return waitForHeaderWithText(text, "", headerTag);
	}

	/**
	 * Gets locator.
	 *
	 * @param text          the text
	 * @param tagName       the tag name
	 * @param prefixLocator the prefix locator
	 * @return the locator
	 */
	public String getLocator(final String text, final String tagName, final String prefixLocator) {
		return String.format("%s//%s[.='%s']", prefixLocator, tagName, text);
	}

	public String getLocatorText(final String text, final String tagName, final String prefixLocator) {
		return String.format("%s//%s[text()='%s']", prefixLocator, tagName, text);
	}

	/**
	 * Gets locator contains.
	 *
	 * @param text          the text
	 * @param tagName       the tag name
	 * @param prefixLocator the prefix locator
	 * @return the locator contains
	 */
	public String getLocatorContains(final String text, final String tagName, final String prefixLocator) {
		return String.format("%s//%s[contains(.,'%s')]", prefixLocator, tagName, text);
	}

	public String getLocatorContainsText(final String text, final String tagName, final String prefixLocator) {
		return String.format("%s//%s[contains(text(),'%s')]", prefixLocator, tagName, text);
	}

	/**
	 * Wait for paragraph with text web element.
	 *
	 * @param text          the text
	 * @param prefixLocator the prefix locator
	 * @return the web element
	 */
	public WebElement waitForParagraphWithText(final String text, final String prefixLocator) {
		String locator = getLocator(text, "p", prefixLocator);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Gets id locator. <br/>
	 * Example locator : <b>//*[@id='home_post-0-post']</b> <br/>
	 * In the above example: You will pass the below values: <br/>
	 * idDynamicValue : "0" <br/>
	 * idPrefix :"home_post-" <br/>
	 * idSuffix : "-post" <br/>
	 * <br/>
	 * prefixLocator : Optional locator if you need to pass any prefix for that Id,
	 * you can pass it, <br/>
	 * for an example: In the below XPath <br/>
	 * //div[contains(@class,'header-container')]//*[@id='home_post-0-post'] <br/>
	 * //div[contains(@class,'header-container')] - this is
	 * <i>prefixLocator</i><br/>
	 * <br/>
	 * <p>
	 * suffixLocator : In some case if you have an id with suffix location, then you
	 * can optionally pass it<br/>
	 * //*[@id='home_post-0-post']/ancestor::span <br/>
	 * In the above example <i>/ancestor::span</i> is the suffixLocator<br/>
	 *
	 * @param idDynamicValue the id dynamic value
	 * @param idPrefix       the id prefix
	 * @param idSuffix       the id suffix
	 * @param prefixLocator  the prefix locator
	 * @param suffixLocator  the suffix locator
	 * @return the id locator
	 */
	public String getIdLocator(final String idDynamicValue, final String idPrefix, final String idSuffix,
			final String prefixLocator, final String suffixLocator) {
		String locatorCreated = String.format("%s//*[@id='%s%s%s']%s", prefixLocator, idPrefix, idDynamicValue,
				idSuffix, suffixLocator);
		log.info("locatorCreated:{}", locatorCreated);
		return locatorCreated;
	}

	/**
	 * Wait for id locator web element.<br/>
	 * Example locator : <b>//*[@id='home_post-0-post']</b> <br/>
	 * * In the above example: You will pass the below values: <br/>
	 * * idDynamicValue : "0" <br/>
	 * * idPrefix :"home_post-" <br/>
	 * * idSuffix : "-post" <br/>
	 * * prefixLocator : Optional locator if you need to pass any prefix for that
	 * Id, you can pass it, <br/>
	 * * for an example: In the below XPath <br/>
	 * * //div[contains(@class,'header-container')]//*[@id='home_post-0-post'] <br/>
	 * * //div[contains(@class,'header-container')] - this is <i>prefixLocator</i>
	 *
	 * @param idDynamicValue the id dynamic value
	 * @param idPrefix       the id prefix
	 * @param idSuffix       the id suffix
	 * @param prefixLocator  the prefix locator
	 * @param suffixLocator  the suffix locator
	 * @return the web element
	 */
	public WebElement waitForIdLocator(final String idDynamicValue, final String idPrefix, final String idSuffix,
			final String prefixLocator, final String suffixLocator) {
		String locator = getIdLocator(idDynamicValue, idPrefix, idSuffix, prefixLocator, suffixLocator);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		return driver.findElement(By.xpath(locator));
	}

	/**
	 ** Wait for id locator web element.<br/>
	 * Example locator : <b>//a[@id='craze_featured']</b> <br/>
	 * In the above example: You will pass the below values: <br/>
	 * Only pass the idSuffix <br/>
	 * idSuffix : <b>"featured"</b> as an argument <br/>
	 * The rest of the values are automatically passed <br/>
	 * idDynamicValue : "_" <br/>
	 * idPrefix :"craze" <br/>
	 * prefixLocator: "" <br/>
	 * suffixLocator: "" </i>
	 * 
	 * @param idSuffix the id suffix
	 * @return the web element
	 */
	public WebElement waitForIdLocator(final String idSuffix) {
		String locator = getIdLocator("_", "craze", idSuffix, "", "");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		return driver.findElement(By.xpath(locator));
	}

	/**
	 * Click id locator. <br/>
	 * Pass the id and click on that element <br/>
	 *
	 * @param idLocator the id locator
	 * @return idLocator - the id which you clicked
	 */
	public String clickIdLocator(final String idLocator) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(idLocator))));
		new DriverUtils(driver).forceClickElement(By.id(idLocator));
		return idLocator;
	}

	public String clickCssLocator(final String cssLocator) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(cssLocator))));
		new DriverUtils(driver).forceClickElement(By.cssSelector(cssLocator));
		return cssLocator;
	}

	public String clickIdLocatorReturnAttribute(final String idLocator, final String attributeName) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(idLocator))));
		String attributeValue = driver.findElement(By.id(idLocator)).getAttribute(attributeName);
		new DriverUtils(driver).forceClickElement(By.id(idLocator));
		return attributeValue;
	}

	/**
	 * Is element displayed boolean. <br/>
	 * Example to pass: <br/>
	 * isElementDisplayed(By.xpath(locator)) <br/>
	 * isElementDisplayed(By.id(locator)) <br/>
	 * isElementDisplayed(By.cssSelector(locator)) <br/>
	 * Where locator is String value. <br/>
	 *
	 * @param by the by
	 * @return the boolean
	 */
	public boolean isElementDisplayed(final By by) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		return driver.findElement(by).isDisplayed();
	}
	
	public boolean isElementPresent(final By by) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		return driver.findElement(by).isDisplayed();
	}
}
