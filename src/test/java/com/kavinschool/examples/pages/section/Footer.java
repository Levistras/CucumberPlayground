package com.kavinschool.examples.pages.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * The Class Footer.
 */
public class Footer {

	/** The driver. */
	private WebDriver driver;

	/** The powered by. */
	@FindBy(id = "poweredBy")
	@CacheLookup
	private WebElement poweredBy;
	
	
	@FindBy(xpath = "//div[@id='footer']")
	@CacheLookup
	private WebElement footerMessage;

	/**
	 * Click on Helpdesk Software Powered By Osticket Link.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public Footer clickPoweredBy() {
		poweredBy.click();
		return this;
	}

	/**
	 * Instantiates a new footer.
	 *
	 * @param driver the driver
	 */
	public Footer(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getFooterMessage() {
		return footerMessage.getText();
	}

}
