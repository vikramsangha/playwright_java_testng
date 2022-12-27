package com.test.playwright.pages;

import com.microsoft.playwright.Page;

public class RegistrationPage {
	
	private Page page;
	
	// Locators
	private String emailInput = "//input[@id = 'email']";
	private String signInButton = "//button[@ng-click = 'signIn()']";
	//private String emailInput = "//input[@id = 'email']";
	
	
	// Constructor
	public RegistrationPage(Page page) {
		this.page = page;
	}
	
	// Action methods
	public String getPageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getPageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}
	
	public void enterEmailID(String emailID) {
		page.fill(emailInput, emailID);
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(signInButton);
		return new LoginPage(page);
	}
	
	public void waitforpagetoload() {
		page.waitForLoadState();
	}
	
	public Boolean verifySignInButton() {
		return page.isVisible(signInButton);
	}
	
	
	
}
