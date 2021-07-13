/*
 * Kangeyan Passoubady
 * Version 1.0
 */
package com.kavinschool.examples.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class VerifyUtils {
	private WebDriver driver;
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public VerifyUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyPageHeader(String pageHeader) {
		String actualHeaderText = new LocatorUtils(driver).waitForHeaderWithText(pageHeader, "h1").getText();
		Assert.assertEquals(actualHeaderText, pageHeader);
		log.info("Page Header:{}", pageHeader);
	}

	public void verifyTitle(final String titlePrefix, final String titleMiddle, final String titleSuffix) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(titlePrefix + " " + titleMiddle + " " + titleSuffix, actualTitle);
		log.info("Actual Title:{}", actualTitle);
	}

	public void verifyURL(String urlText) {
		String url = driver.getCurrentUrl();
		new DriverUtils(driver).waitForPageToLoad(10);
		log.info("Current URL:{}", url);
		Assert.assertTrue("URL does not contain " + urlText, url.contains(urlText));
	}

}
