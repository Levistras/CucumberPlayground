package com.kavinschool.examples.pages;

import org.openqa.selenium.WebDriver;

public class CheckTicketStatusPage {
	private WebDriver driver;
	private int timeout = 15;

	public CheckTicketStatusPage() {
		super();
	}
	public CheckTicketStatusPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public CheckTicketStatusPage(WebDriver driver, int timeout) {
		super();
		this.driver = driver;
		this.timeout = timeout;
	}

}
