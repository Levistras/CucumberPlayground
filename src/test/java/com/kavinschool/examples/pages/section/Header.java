/*
 * Kangeyan Passoubady (Kangs)
 * Kavin School LLC
 */

package com.kavinschool.examples.pages.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kavinschool.examples.pages.SignInPage;

/**
 * The Class Header.
 */
public class Header {

	/** The driver. */
	private WebDriver driver;


	/** The sign in. */
	@FindBy(css = "a[href='/ticket/login.php']")
	@CacheLookup
	private WebElement signIn;

	/** The guest user label. */
	@FindBy(css = "//div[@id='header']//p[1]")
	@CacheLookup
	private WebElement guestUserLabel;

	/**
	 * Instantiates a new header.
	 *
	 * @param driver the driver
	 */
	public Header(WebDriver driver) {
		super();
		this.driver = driver;
	}

	/**
	 * Gets the guest user label.
	 *
	 * @return the guest user label
	 */
	public String getGuestUserLabel() {
		return guestUserLabel.getText();
	}

	/**
	 * Click sign in link.
	 *
	 * @return the sign in page
	 */
	public SignInPage clickSignInLink() {
		signIn.click();
		SignInPage target = new SignInPage(driver);
		PageFactory.initElements(driver, target);
		return target;
	}

}
