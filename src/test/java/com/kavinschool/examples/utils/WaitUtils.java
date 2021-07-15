/*
 * Kangeyan Passoubady
 * Version 1.0
 */
package com.kavinschool.examples.utils;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.lf5.LogLevel;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class WaitUtils.
 */
public class WaitUtils {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/** The Constant PICO_WAIT. */
	public static final int PICO_WAIT = 100;

	/** The Constant NANO_WAIT. */
	public static final int NANO_WAIT = 250;

	/** The Constant MICRO_WAIT. */
	public static final int MICRO_WAIT = 500;

	/** The Constant MILLI_WAIT. */
	public static final int MILLI_WAIT = 750;

	/** The Constant KILO_WAIT. */
	public static final int KILO_WAIT = 1000;

	/** The Constant MEGA_WAIT. */
	public static final int MEGA_WAIT = 2000;

	/** The Constant GIGA_WAIT. */
	public static final int GIGA_WAIT = 3000;

	/** The Constant TERA_WAIT. */
	public static final int TERA_WAIT = 4000;

	private static final long EXP_WAIT = 10;

	/**
	 * The Constant DEFAULT_MAX_TIME_OUT.
	 */
	public static final String DEFAULT_MAX_TIME_OUT = "180";

	/**
	 * The Constant DEFAULT_MAX_TIME_OUT_L.
	 */
	public static final long DEFAULT_MAX_TIME_OUT_L = 180L;

	/**
	 * The Constant DEFAULT_MAX_TIME_OUT_LIMS.
	 */
	public static final long DEFAULT_MAX_TIME_OUT_LIMS = 500L;

	/**
	 * The Constant DEFAULT_POLLING_TIME_REPEAT.
	 */
	public static final String DEFAULT_POLLING_TIME_REPEAT = "1";

	/**
	 * The Constant DEFAULT_POLLING_TIME_REPEAT_L.
	 */
	public static final long DEFAULT_POLLING_TIME_REPEAT_L = 1;

	/** The driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new wait utils.
	 */
	public WaitUtils() {
		super();
	}

	/**
	 * Instantiates a new wait utils.
	 *
	 * @param driver the driver
	 */
	public WaitUtils(final WebDriver driver) {
		super();
		this.driver = driver;
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Sets the driver.
	 *
	 * @param driver the new driver
	 */
	public void setDriver(final WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Delay.
	 *
	 * @param milliSeconds the ms
	 */
	public static void delay(final int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (final InterruptedException e) {
			LogUtils.writeLog(e.getMessage(), LogLevel.WARN);
		}
	}

	/**
	 * Hold.
	 *
	 * @param milliSeconds the milli seconds
	 */
	public void hold(final int milliSeconds) {
		WaitUtils.delay(milliSeconds);
	}

	/**
	 * Pico hold.
	 */
	public void picoHold() {
		WaitUtils.delay(WaitUtils.PICO_WAIT);
	}

	/**
	 * Nano hold.
	 */
	public void nanoHold() {
		WaitUtils.delay(WaitUtils.NANO_WAIT);
	}

	/**
	 * Milli hold.
	 */
	public void milliHold() {
		WaitUtils.delay(WaitUtils.MILLI_WAIT);
	}

	/**
	 * Kilo hold.
	 */
	public void kiloHold() {
		WaitUtils.delay(WaitUtils.KILO_WAIT);
	}

	/**
	 * Mega hold.
	 */
	public void megaHold() {
		WaitUtils.delay(WaitUtils.MEGA_WAIT);
	}

	/**
	 * Giga hold.
	 */
	public void gigaHold() {
		WaitUtils.delay(WaitUtils.GIGA_WAIT);
	}

	/**
	 * Tera hold.
	 */
	public void teraHold() {
		WaitUtils.delay(WaitUtils.TERA_WAIT);
	}

	/**
	 * Wait for alert present.
	 *
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the alert
	 */
	public Alert waitForAlertPresent(final long timeoutInSeconds) {
		log.info("waitForAlertPresent({})", timeoutInSeconds);
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Wait for element selection state to be.
	 *
	 * @param webBy    the webBy
	 * @param selected the selected
	 * @return true, if successful
	 */
	public boolean waitForElementSelectionStateToBe(final By webBy, final boolean selected) {
		return waitForElementSelectionStateToBe(webBy, selected, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for element selection state to be.
	 *
	 * @param webBy            the webBy
	 * @param selected         the selected
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForElementSelectionStateToBe(final By webBy, final boolean selected,
			final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementSelectionStateToBe(webBy, selected));
	}

	/**
	 * Wait for element selection state to be.
	 *
	 * @param element  the element
	 * @param selected the selected
	 * @return true, if successful
	 */
	public boolean waitForElementSelectionStateToBe(final WebElement element, final boolean selected) {
		return waitForElementSelectionStateToBe(element, selected, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for element selection state to be. Note: An expectation for checking if
	 * the given element is selected.
	 *
	 * @param element          the element
	 * @param selected         the selected
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForElementSelectionStateToBe(final WebElement element, final boolean selected,
			final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}

	/**
	 * Wait for element to be clickable.
	 *
	 * @param webBy the webBy
	 * @return the web element
	 */
	public WebElement waitForElementToBeClickable(final By webBy) {
		return waitForElementToBeClickable(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for element to be clickable. Note: An expectation for checking an
	 * element is visible and enabled such that you can click it.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */

	public WebElement waitForElementToBeClickable(final By webBy, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(webBy));
	}

	/**
	 * Wait for element to be clickable. Note: An expectation for checking an
	 * element is visible and enabled such that you can click it.
	 *
	 * @param element          the element
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */
	public WebElement waitForElementToBeClickable(final WebElement element, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait for element to be selected. Note: An expectation for checking if the
	 * given element is selected.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForElementToBeSelected(final By webBy, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementToBeSelected(webBy));
	}

	/**
	 * Wait for element to be selected.
	 *
	 * @param element the element
	 * @return true, if successful
	 */
	public boolean waitForElementToBeSelected(final WebElement element) {
		final WebDriverWait wait = new WebDriverWait(driver, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
		return wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * Wait for element to be selected. Note: An expectation for checking if the
	 * given element is selected.
	 *
	 * @param element          the element
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForElementToBeSelected(final WebElement element, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * Wait for frame to be available and switch to it.
	 *
	 * @param webBy the webBy
	 * @return the web driver
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(final By webBy) {
		return waitForFrameToBeAvailableAndSwitchToIt(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for frame to be available and switch to it. Note: An expectation for
	 * checking whether the given frame is available to switch to. If the frame is
	 * available it switches the given driver to the specified frame.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web driver
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(final By webBy, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webBy));
	}

	/**
	 * Wait for frame to be available and switch to it.
	 *
	 * @param frameLocator the frame locator
	 * @return the web driver
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(final String frameLocator) {
		return waitForFrameToBeAvailableAndSwitchToIt(frameLocator, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for frame to be available and switch to it. Note: An expectation for
	 * checking whether the given frame is available to switch to. If the frame is
	 * available it switches the given driver to the specified frame.
	 *
	 * @param frameLocator     the frame locator
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web driver
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(final String frameLocator, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/**
	 * Wait till page to load completely includes JScript & Jquery.
	 *
	 * @param driver        the driver
	 * @param timeOutInSecs the time out in secs
	 */
	public void waitForJSJQPageToLoad(final long timeOutInSecs) {

		final Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSecs);

		final ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(final WebDriver driver) {
				return (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0;
			}
		};

		final ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(final WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		try {

			wait.until(expectation);
			wait.until(jQueryLoad);
		} catch (final Throwable error) {
			DriverUtils.delay(2000);
			LogUtils.writeLog("Waiting for Page Load Request to complete is failed.", LogLevel.WARN);
		}

	}

	/**
	 * Gets all the images in a URL if the images did not get loaded properly it
	 * will be added to error count.
	 *
	 * @param driver the driver
	 * @return number of Images did not get loaded (errorCount)
	 */
	public int waitForImageToGetLoaded() {
		final StringBuffer verificationErrors = new StringBuffer(17);
		int errCount = 0;

		final List<WebElement> allImages = driver.findElements(By.tagName("img"));
		final int totalImagesFound = allImages.size();
		int count = 0;

		LogUtils.writeLog("totalImagesFound:" + totalImagesFound);
		for (final WebElement image : allImages) {
			LogUtils.writeLog("Count:" + count++);
			boolean loaded;
			loaded = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					image);
			if (!loaded) {
				LogUtils.writeLog("Image not found");
				verificationErrors.append("Image " + count + " Not found ");
				errCount++;
			}
		}
		LogUtils.writeLog("errCount:" + errCount);

		return errCount;
	}

	/**
	 * Wait for invisibility of element located.
	 *
	 * @param webBy the webBy
	 * @return true, if successful
	 */
	public boolean waitForInvisibilityOfElementLocated(final By webBy) {
		return waitForInvisibilityOfElementLocated(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for invisibility of element located. Note: An expectation for checking
	 * that an element is either invisible or not present on the DOM.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForInvisibilityOfElementLocated(final By webBy, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(webBy));
	}

	/**
	 * Wait for invisibility of element with text.
	 *
	 * @param webBy the webBy
	 * @param text  the text
	 * @return true, if successful
	 */
	public boolean waitForInvisibilityOfElementWithText(final By webBy, final String text) {

		return waitForInvisibilityOfElementWithText(webBy, text, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for invisibility of element with text. Note: An expectation for checking
	 * that an element is either invisible or not present on the DOM.
	 *
	 * @param webBy            the webBy
	 * @param text             the text
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForInvisibilityOfElementWithText(final By webBy, final String text,
			final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.invisibilityOfElementWithText(webBy, text));
	}

	/**
	 * Wait for presence of all elements located webBy.
	 *
	 * @param webBy the webBy
	 * @return the list
	 */
	public List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By webBy) {
		return waitForPresenceOfAllElementsLocatedBy(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for presence of all elements located webBy.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the list
	 */
	public List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By webBy, final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(webBy));
	}

	/**
	 * Wait for presence of element located.
	 *
	 * @param webBy the webBy
	 * @return the web element
	 */
	public WebElement waitForPresenceOfElementLocated(final By webBy) {
		return waitForPresenceOfElementLocated(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for presence of element located. Note: An expectation for checking that
	 * an element is present on the DOM of a page.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */
	public WebElement waitForPresenceOfElementLocated(final By webBy, final long timeoutInSeconds) {
		return new WebDriverWait(driver, timeoutInSeconds < WaitUtils.EXP_WAIT ? WaitUtils.EXP_WAIT : timeoutInSeconds)
				.until(ExpectedConditions.presenceOfElementLocated(webBy));
	}

	/**
	 * Wait for text.
	 *
	 * @param text             the text
	 * @param webBy            the webBy
	 * @param timeoutMsg       the timeout msg
	 * @param timeOutInSeconds the time out in seconds
	 */
	public void waitForText(final String text, final By webBy, final String timeoutMsg, final long timeOutInSeconds) {

		for (int second = 0;; second++) {
			if (second >= timeOutInSeconds) {
				Assert.fail(timeoutMsg + " for " + text);
			}
			try {
				if (text.equals(driver.findElement(webBy).getText())) {
					break;
				}
			} catch (final Exception e) {
				delay(Integer.parseInt(WaitUtils.DEFAULT_POLLING_TIME_REPEAT) * 10);
			}
			delay(Integer.parseInt(WaitUtils.DEFAULT_POLLING_TIME_REPEAT) * 1000);
		}
	}

	/**
	 * Wait for text to be present in element. Note: An expectation for checking if
	 * the given text is present in the specified element.
	 *
	 * @param element          the element
	 * @param text             the text
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForTextToBePresentInElement(final WebElement element, final String text,
			final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Wait for text to be present in element located.
	 *
	 * @param webBy the webBy
	 * @param text  the text
	 * @return true, if successful
	 */
	public boolean waitForTextToBePresentInElementLocated(final By webBy, final String text) {
		return waitForTextToBePresentInElementLocated(webBy, text, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for text to be present in element located. An expectation for checking
	 * if the given text is present in the element that matches the given locator
	 *
	 * @param webBy            the webBy
	 * @param text             the text
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitForTextToBePresentInElementLocated(final By webBy, final String text,
			final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.textToBePresentInElementLocated(webBy, text));
	}

	/**
	 * Wait for title.
	 *
	 * @param pageTitle the page title
	 */
	public void waitForTitle(final String pageTitle) {
		waitForTitle(pageTitle, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for title. Note: Looks for exact title match
	 *
	 * @param pageTitle        the page title
	 * @param timeoutInSeconds the timeout in seconds
	 */
	public void waitForTitle(final String pageTitle, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.titleIs(pageTitle));
	}

	/**
	 * Wait for title contains.
	 *
	 * @param pageTitle the page title
	 */
	public void waitForTitleContains(final String pageTitle) {
		waitForTitleContains(pageTitle, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for title contains. Note: Matches partial title
	 *
	 * @param pageTitle        the page title
	 * @param timeoutInSeconds the timeout in seconds
	 */
	public void waitForTitleContains(final String pageTitle, final long timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	/**
	 * Wait fort text to be present in element value.
	 *
	 * @param webBy the webBy
	 * @param text  the text
	 * @return true, if successful
	 */
	public boolean waitFortTextToBePresentInElementValue(final By webBy, final String text) {
		return waitFortTextToBePresentInElementValue(webBy, text, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait fort text to be present in element value. Note: An expectation for
	 * checking if the given text is present in the specified elements value
	 * attribute.
	 *
	 * @param webBy            the webBy
	 * @param text             the text
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitFortTextToBePresentInElementValue(final By webBy, final String text,
			final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.textToBePresentInElementValue(webBy, text));
	}

	/**
	 * Wait fort text to be present in element value.
	 *
	 * @param driver           the driver
	 * @param element          the element
	 * @param text             the text
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitFortTextToBePresentInElementValue(final WebDriver driver, final WebElement element,
			final String text, final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	/**
	 * Wait fort text to be present in element value.
	 *
	 * @param element the element
	 * @param text    the text
	 * @return true, if successful
	 */
	public boolean waitFortTextToBePresentInElementValue(final WebElement element, final String text) {
		return waitFortTextToBePresentInElementValue(element, text, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait fort text to be present in element value. Note: An expectation for
	 * checking if the given text is present in the specified elements value
	 * attribute.
	 *
	 * @param element          the element
	 * @param text             the text
	 * @param timeoutInSeconds the timeout in seconds
	 * @return true, if successful
	 */
	public boolean waitFortTextToBePresentInElementValue(final WebElement element, final String text,
			final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	/**
	 * Wait for visibility of.
	 *
	 * @param element the element
	 * @return the web element
	 */
	public WebElement waitForVisibilityOf(final WebElement element) {

		return waitForVisibilityOfElement(element, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for visibility of. Note: An expectation for checking that an element,
	 * known to be present on the DOM of a page, is visible. Visibility means that
	 * the element is not only displayed but also has a height and width that is
	 * greater than 0.
	 *
	 * @param element          the element
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */
	public WebElement waitForVisibilityOf(final WebElement element, final long timeoutInSeconds) {

		return waitForVisibilityOfElement(element, timeoutInSeconds);
	}

	/**
	 * Wait for visibility of all elements.
	 *
	 * @param elements the elements
	 * @return the list
	 */
	public List<WebElement> waitForVisibilityOfAllElements(final List<WebElement> elements) {
		return waitForVisibilityOfAllElements(elements, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for visibility of all elements. Note: An expectation for checking that
	 * all elements present on the web page that match the locator are visible.
	 *
	 * @param elements         the elements
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the list
	 */
	public List<WebElement> waitForVisibilityOfAllElements(final List<WebElement> elements,
			final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Wait for visibility of all elements located webBy.
	 *
	 * @param webBy the webBy
	 * @return the list
	 */
	public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(final By webBy) {

		return waitForVisibilityOfAllElementsLocatedBy(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Visibility of all elements located webBy. Note: An expectation for checking
	 * that all elements present on the web page that match the locator are visible.
	 * Visibility means that the elements are not only displayed but also have a
	 * height and width that is greater than 0.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the list
	 */
	public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(final By webBy, final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webBy));
	}

	/**
	 * Wait for visibility of element.
	 *
	 * @param element the element
	 * @return the web element
	 */
	public WebElement waitForVisibilityOfElement(final WebElement element) {

		return waitForVisibilityOfElement(element, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for visibility of element.
	 *
	 * @param webBy the web by
	 * @return the web element
	 */
	public WebElement waitForVisibilityOfElement(final By webBy) {

		return waitForVisibilityOfElement(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for visibility of element. Note: An expectation for checking that an
	 * element, known to be present on the DOM of a page, is visible.
	 *
	 * @param element          the element
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */
	public WebElement waitForVisibilityOfElement(final WebElement element, final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for visibility of element.
	 *
	 * @param element          the element
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */
	public WebElement waitForVisibilityOfElement(final By element, final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf((WebElement) element));
	}

	/**
	 * Wait for visibility of element located.
	 *
	 * @param webBy the webBy
	 * @return the web element
	 */
	public WebElement waitForVisibilityOfElementLocated(final By webBy) {

		return waitForVisibilityOfElementLocated(webBy, WaitUtils.DEFAULT_MAX_TIME_OUT_L);
	}

	/**
	 * Wait for visibility of element located.
	 *
	 * @param webBy            the webBy
	 * @param timeoutInSeconds the timeout in seconds
	 * @return the web element
	 */
	public WebElement waitForVisibilityOfElementLocated(final By webBy, final long timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(webBy));
	}

	/**
	 * Wait until element gets value.
	 *
	 * @param webBy the webBy
	 * @param text  the text
	 */
	public void waitUntilElementGetsValue(final By webBy, final String text) {
		waitUntilElementGetsValue(webBy, text, WaitUtils.DEFAULT_MAX_TIME_OUT_L,
				WaitUtils.DEFAULT_POLLING_TIME_REPEAT_L);
	}

	/**
	 * Wait until element gets value. Note: This methods ignores the generic
	 * NoSuchElementException class
	 *
	 * @param webBy               the webBy
	 * @param text                the text
	 * @param timeoutInSeconds    the timeout in seconds
	 * @param pollingEveryInMills the polling every in seconds
	 */
	public void waitUntilElementGetsValue(final By webBy, final String text, final long timeoutInSeconds,
			final long pollingEveryInMills) {

		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMills)).ignoring(NoSuchElementException.class)
				.until(new ExpectedCondition<Boolean>() {

					/*
					 * (non-Javadoc)
					 *
					 * @see com.google.common.base.Function#apply(java.lang.Object)
					 */
					@Override
					public Boolean apply(final WebDriver driver) {
						final WebElement element = driver.findElement(webBy);
						return element.getText().equals(text);
					}
				});
	}

	/**
	 * Wait until element gets value.
	 *
	 * @param element the element
	 * @param text    the text
	 */
	public void waitUntilElementGetsValue(final WebElement element, final String text) {
		waitUntilElementGetsValue(element, text, WaitUtils.DEFAULT_MAX_TIME_OUT_L,
				WaitUtils.DEFAULT_POLLING_TIME_REPEAT_L);
	}

	/**
	 * Wait until element gets value. Note: This methods ignores the generic
	 * NoSuchElementException class
	 *
	 * @param element               the element
	 * @param text                  the text
	 * @param timeoutInSeconds      the timeout in seconds
	 * @param pollingEveryInSeconds the polling every in seconds
	 */
	public void waitUntilElementGetsValue(final WebElement element, final String text, final long timeoutInSeconds,
			final long pollingEveryInSeconds) {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingEveryInSeconds)).ignoring(NoSuchElementException.class)
				.until(new ExpectedCondition<Boolean>() {

					/*
					 * (non-Javadoc)
					 *
					 * @see com.google.common.base.Function#apply(java.lang.Object)
					 */
					@Override
					public Boolean apply(final WebDriver driver) {
						return element.getText().equals(text);
					}
				});
	}

	/**
	 * Wait for element present.
	 *
	 * @param element the element
	 * @param driver  the driver
	 */
	public void waitForElementPresent(final WebElement element) {

		try {
			final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (final Exception ex) {
			LogUtils.writeLog("Exception occured while waiting for element");
			LogUtils.writeLog(ex.getMessage(), LogLevel.DEBUG);
		}
	}

	public boolean waitForElementPresent(final By by) {
		return waitForElementPresent(by, WaitUtils.MEGA_WAIT / 1000);
	}

	public boolean waitForElementPresent(final By by, long timeout) {
		try {
			final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofMillis(500))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (final Exception ex) {
			LogUtils.writeLog("Exception occured while waiting for element");
			LogUtils.writeLog(ex.getMessage(), LogLevel.DEBUG);
			return false;
		}
	}

	/**
	 * Wait downloading of file.
	 *
	 * @param fullPathToFile the full path to file
	 * @param timeoutSeconds the timeout seconds
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitDownloadingOfFile(final String fullPathToFile, final int timeoutSeconds)
			throws InterruptedException {
		int i = 0;
		final File file = new File(fullPathToFile);
		while (!file.exists() && i < timeoutSeconds) {
			Thread.sleep(1000);
			i++;
		}
		if (i == timeoutSeconds) {
			LogUtils.writeLog("File " + fullPathToFile + " is not downloaded");
		}
	}

	/**
	 * Wait changing of url.
	 *
	 * @param driver         the driver
	 * @param keyword        the keyword
	 * @param timeoutSeconds the timeout seconds
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitChangingOfUrl(final String keyword, final int timeoutSeconds) throws InterruptedException {
		int i = 0;
		while (!driver.getCurrentUrl().contains(keyword) && i < timeoutSeconds) {
			Thread.sleep(1000);
			i++;
		}
		if (i == timeoutSeconds) {
			LogUtils.writeLog("Url was not changed - keyword " + keyword + " is not present");
		}
	}

	/**
	 * Wait for page to load.
	 *
	 * @param driver the driver
	 */
	public void waitForPageLoad() {
		WaitUtils.delay(2000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
					.executeScript("return document.readyState").equals("complete"));
		} catch (TimeoutException e) {
			LogUtils.writeLog("document.readyState is not complete ");
		}
	}

}
