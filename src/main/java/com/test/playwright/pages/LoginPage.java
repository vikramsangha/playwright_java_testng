package com.test.playwright.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class LoginPage {
	
	private Page page;
	
	// Locators
	private String emailInput = "//input[@id = 'email']";
	private String passwordInput = "//input[@id = 'password']";
	private String loginButton = "//button[@id = 'taLogin']";
	private String nextButton = "//button[@id = 'next']";
	
	//private String emailInput = "//input[@id = 'email']";
	
	
	// Constructor
	public LoginPage(Page page) {
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
	
	public void clickNextButton() {
		page.click(nextButton);
	}
	
	public void clickLoginButton() {
		page.click(loginButton);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public HomePage navigateToHomePage() {
		page.click(loginButton);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return new HomePage(page);
	}
	
	public RegistrationPage navigateToRegistrationPage() {
		page.click(loginButton);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return new RegistrationPage(page);
	}
	
	public void enterPassword(String password) {
		page.fill(passwordInput, password);
	}
	

}
