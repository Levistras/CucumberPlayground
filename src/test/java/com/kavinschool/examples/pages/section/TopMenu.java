package com.kavinschool.examples.pages.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kavinschool.examples.pages.CheckTicketStatusPage;
import com.kavinschool.examples.pages.OpenNewTicketPage;
import com.kavinschool.examples.pages.SupportCenterHomePage;

public class TopMenu {
    private WebDriver driver;
	private int timeout = 15;
    
	@FindBy(xpath = "//a[.='Open a New Ticket']")
	@CacheLookup
	private WebElement openANewTicket;

	@FindBy(xpath = "//a[.='Check Ticket Status']")
	@CacheLookup
	private WebElement checkTicketStatus;
	
	
	@FindBy(xpath = "//a[.='Support Center Home']")
	@CacheLookup
	private WebElement supportCenterHome;


	public TopMenu(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	/**
	 * Click on Open A New Ticket Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public OpenNewTicketPage clickOpenANewTicketLink() {
		openANewTicket.click();
		OpenNewTicketPage target = new OpenNewTicketPage(driver);
        PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Click on Open A New Ticket Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public CheckTicketStatusPage clickCheckTicketStatusLink() {
		checkTicketStatus.click();
		CheckTicketStatusPage target = new CheckTicketStatusPage(driver);
        PageFactory.initElements(driver, target);
		return target;
	}
	
	/**
	 * Click on Support Center Home Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public SupportCenterHomePage clickSupportCenterHomeLink() {
		supportCenterHome.click();
		SupportCenterHomePage target = new SupportCenterHomePage(driver, timeout);
        PageFactory.initElements(driver, target);
		return target;
	}

	
}
