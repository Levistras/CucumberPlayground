/*
 * Kangeyan Passoubady
 * Version 1.0
 */
package com.kavinschool.examples.utils;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Stack;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;

public class DriverUtils {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private WebDriver driver;
	private String browserType;
    private final Stack<String> windowHandles = new Stack<>();


	public DriverUtils(WebDriver driver) {
		this.driver = driver;
	}

	public DriverUtils(WebDriver driver, String browserType) {
		this.driver = driver;
		this.browserType = browserType;
	}

	public void clickAt(By by, int xOffset, int yOffset) {
		WebElement element = driver.findElement(by);
		Actions builder = new Actions(driver);
		builder.moveToElement(element, xOffset, yOffset).click().build().perform();
	}

	public void clickAt(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element, 5, 5).click().build().perform();
	}

	public void clickAt(WebElement element, int xOffset, int yOffset) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element, xOffset, yOffset).click().build().perform();
	}

	/**
     * Close alert and get its text.
     *
     * @param acceptNextAlert the accept next alert
     * @return the string
     */
    public String closeAlertAndGetItsText(final boolean acceptNextAlert) {
        try {
            final Alert alert = driver.switchTo().alert();
            final String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } catch (final Exception ex) {
            log.warn("Alert Not found!!!");
            return null;
        }
    }

	public void closeCurrentWindowAndSwitchToParentWindow() {
        driver.close();
        driver.switchTo().window(windowHandles.pop());
    }

	/**
	 * Focus element.
	 *
	 * @param elementId the id
	 */
	public void focusElement(final String elementId) {
		final JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("document.getElementById('" + elementId + "').focus()");
	}

	public void forceClickElement(By by) {
		boolean isClicked;
		int times = 0;
		do {
			try {
				++times;
				WebElement driverElement = driver.findElement(by);
				driverElement.click();
				isClicked = true;
			} catch (Exception ex) {
				isClicked = false;
				DriverUtils.delay(500);
			}
			log.info("isClicked:{}, times ={} \n", isClicked, times);
			if (times > 10)
				break;
		} while (!isClicked);
	}

	public void forceClickElement(final WebElement webElement) {
		boolean isClicked;
		int times = 0;
		do {
			try {
				++times;
				webElement.click();
				isClicked = true;
			} catch (Exception ex) {
				isClicked = false;
				DriverUtils.delay(500);
			}
			log.info("isClicked:{}, times ={} \n", isClicked, times);
			if (times > 10)
				break;
		} while (!isClicked);
	}

	public String getBrowserType() {
		return browserType;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getRandomResourceImageFile() {
		Random random = new Random();
		int picNumber = random.nextInt(18);
		String imageVideo = String.format("media/pic%s.jpeg", picNumber);
		URL url = Resources.getResource(imageVideo);
		log.info("url.getPath():{}", url.getPath());
		return url.getPath();
	}

	public String getScreenShotFileName(String methodName) {
		return getScreenShotFileName("", methodName);
	}

	/**
	 * Gets screen shot file name.
	 *
	 * @param className  the class name
	 * @param methodName the method name
	 * @return the screen shot file name
	 */
// This method creates a file name with the following format
	// ScreenShot/Date/time_classname_testname.png
	// ScreenShot is a folder
	// Date is a folder
	// time_classname_testname.png is a file
	// Date format is yyyyMMdd
	// time format is HHmmssSSS
	// className and methodName special characters ".][" are replaced with "_"
	public String getScreenShotFileName(String className, String methodName) {
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
		DateFormat dateFormat1 = new SimpleDateFormat("HHmmssSSS");
		String now = dateFormat1.format(new Date());
		String today = dateFormat2.format(new Date());
		String fileName;
		System.out.println("Method Name:" + methodName);
		System.out.println("Class Name:" + className);
		if (methodName != null && className != null)
			fileName = className + "." + methodName;
		else if (className != null)
			fileName = className;
		else
			fileName = methodName;
		fileName = "target/Screenshots/" + today + "/" + now + '_' + browserType + '_'
				+ fileName.replaceAll("[.\\[\\]]", "_") + ".png";
		System.out.println("name:" + fileName);
		return fileName;
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if text present.
	 *
	 * @param text the text
	 * @return true, if text present
	 */
	public boolean isTextPresent(final String text) {
		try {
			return driver.findElement(By.tagName("body")).getText().contains(text);
		} catch (final NoSuchElementException e) {
			return false;
		}
	}

	public void moveToElement(final WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			delay(500);
		} catch (MoveTargetOutOfBoundsException ex) {
			log.warn(ex.getMessage());
			log.error("Moving out of bound");
		}
	}

	/**
	 * Save screen shot to byte [ ].
	 *
	 * @param screenShotFileName the screen shotfile name
	 * @return the byte [ ]
	 */
	public byte[] saveScreenShotTo(String screenShotFileName) {
		log.info("saveScreenShotTo({})",screenShotFileName);
		if (browserType.equalsIgnoreCase("htmlunit"))
			return new byte[0];
		try {
			return writeScreenShot(screenShotFileName);
		} catch (Exception ex) {
			log.warn(ex.getMessage());
		}
		return new byte[0];
	}

	/**
	 * Scroll down.
	 *
	 * @param pixelToScroll the pixel to scroll
	 */
	public void scrollDown(final int pixelToScroll) {
		final int detPixelToScroll = pixelToScroll == 0 ? 250 : pixelToScroll;
		final JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("scrollBy(0, " + detPixelToScroll + ");");
		delay(1000);
	}

	/**
	 * Scroll Horizontal Left Direction.
	 */
	public void scrollHorizontalLeft() {
		final int pixelToScroll = -2000;
		final JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("scroll(" + pixelToScroll + ", 0);");
	}

	/**
	 * Scroll Horizontal Right Direction.
	 */
	public void scrollHorizontalRight() {
		final int pixelToScroll = 2000;
		final JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("scroll(" + pixelToScroll + ", 0);");
	}

	/**
	 * Scroll into view.
	 *
	 * @param byMethod the byMethod
	 */
	public void scrollIntoView(final By byMethod) {
		final WebElement element = driver.findElement(byMethod);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		delay(500);
	}

	public void scrollIntoView(final WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		delay(500);
	}

	/**
	 * Scroll into view. viewStatus - accepted values : true, false
	 *
	 * @param element    the element
	 * @param viewStatus the view status
	 */
	public void scrollIntoView(final WebElement element, final String viewStatus) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + viewStatus + ");", element);
		delay(500);
	}

	/**
	 * Scroll to bottom of page.
	 */
	public void scrollToBottomOfPage() {
		final JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * Scroll to page top.
	 */
	public void scrollToPageTop() {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		delay(1000);
	}

	/**
	 * Scroll up.
	 *
	 * @param driver        the driver
	 * @param pixelToScroll the pixel to scroll
	 */
	public void scrollUp(final WebDriver driver, Integer pixelToScroll) {
		pixelToScroll = pixelToScroll == 0 ? 250 : pixelToScroll;
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, -" + StringUtils.strip(pixelToScroll.toString()) + ");");
	}

	public DriverUtils setBrowserType(String browserType) {
		this.browserType = browserType;
		return this;
	}

	public DriverUtils setDriver(WebDriver driver) {
		this.driver = driver;
		return this;
	}

	public void switchToNewWindow() {
        String curWin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(curWin) && !windowHandles.contains(curWin)) {
                windowHandles.push(curWin);
                driver.switchTo().window(handle);
                break;
            }
        }
    }

	/**
	 * Switch to new window return win handle before.
	 *
	 * @return the string
	 */
	public String switchToNewWindowReturnWinHandleBefore() {
		// Store the current window handle
		final String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (final String winHandle : driver.getWindowHandles()) {
			if (!winHandleBefore.equals(winHandle))
				driver.switchTo().window(winHandle);
		}
		return winHandleBefore;
	}

	/**
	 * This method could be used only browser based, not for head-less browsers If
	 * the timeOut Exceeds, this method will make your test case to fail.
	 * 
	 * @param timeOutInSecs the time out in secs
	 */
	public void waitForPageToLoad(final long timeOutInSecs) {
		final ExpectedCondition<Boolean> expectation = driver -> {
			assert driver != null;
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		};
		final Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSecs);
		try {
			wait.until(expectation);
		} catch (final Throwable error) {
			delay(2000);
			log.warn(error.getMessage());
			log.error("Waiting for Page Load Request to complete is failed.");
		}
	}

	public void waitForTitleContains(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(title));
		delay(3000);
	}
	
    private byte[] writeScreenShot(String screenShotFileName) throws IOException {
		System.out.println("writeScreenShot: " + screenShotFileName);
		File tempScrShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tempScrShotFile, new File(screenShotFileName));
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
    
    public static void delay(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			log.warn(ex.getMessage());
		}
	}

    public static String getUniqueId() {
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
		DateFormat dateFormat1 = new SimpleDateFormat("HHmmssSSS");
		String now = dateFormat1.format(new Date());
		String today = dateFormat2.format(new Date());
		return today + "_" + now;
	}


}
