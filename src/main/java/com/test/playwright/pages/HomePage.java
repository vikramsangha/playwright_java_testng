package com.test.playwright.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class HomePage {
	
	private Page page;
	
	// Locators
	private String emailInput = "//input[@id = 'email']";
	private String passwordInput = "//input[@id = 'password']";
	private String loginButton = "//button[@id = 'taLogin']";
	private String nextButton = "//button[@id = 'next']";
	private String org = "//button[@id = 'tsc-choose-account-continue-button-TSC Admin us-west-2']";
	
	//private String emailInput = "//input[@id = 'email']";
	
	
	// Constructor
	public HomePage(Page page) {
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
	
	public HomePage clickOrg() {
		System.out.println("Clicking org");
		page.click(org);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return new HomePage(page);
	}
	

}
