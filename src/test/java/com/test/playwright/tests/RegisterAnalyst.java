package com.test.playwright.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.test.playwright.factory.PlaywrightFactory;
import com.test.playwright.pages.HomePage;
import com.test.playwright.pages.LoginPage;
import com.test.playwright.pages.RegistrationPage;
import com.test.playwright.pages.SelectOrganisationPage;

public class RegisterAnalyst {
	
	PlaywrightFactory pf;
	Page page;
	RegistrationPage rp;
	LoginPage lp;
	HomePage hp;
	SelectOrganisationPage sp;
	protected Properties prop;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		rp = new RegistrationPage(page);
	}
	
	
	@Test (enabled=true)
	public void RegisterAnalystUser() throws InterruptedException {
		rp.enterEmailID(prop.getProperty("username").trim());
		lp = rp.navigateToLoginPage();
		Assert.assertEquals(rp.getPageTitle(), "TIBCO Accounts");
		lp.enterEmailID(prop.getProperty("username").trim());
		lp.clickNextButton();
		lp.enterPassword(prop.getProperty("password").trim());
		hp = lp.navigateToHomePage();
		// Land on home Page
		//Assert.assertEquals(lp.navigateToHomePage().getPageTitle(), "New analysis - TIBCO Spotfire");
		Assert.assertEquals(hp.getPageTitle(), "New analysis - TIBCO Spotfire");
		
	}
		
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
