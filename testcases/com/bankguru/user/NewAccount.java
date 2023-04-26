package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class NewAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;

	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition: Step 01 - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		
		log.info("Pre-condition: Step 02 - Set login page cookie");
		loginPage.setAllCookies(driver, Login.loginPageCookie);
		loginPage.sleepInSecond(2);
		loginPage.refreshCurrentPage(driver);
		
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test(description = "Add new account with customer id cannot be empty")
	public void New_Account_01() {
		
	}
	
	@Test(description = "Add new account with customer id must be numeric")
	public void New_Account_02() {
		
	}
	
	@Test(description = "Add new account with customer id cannot have special character")
	public void New_Account_03() {
		
	}
	
	@Test(description = "Add new account with customer id cannot have blank space")
	public void New_Account_04() {
		
	}
	
	@Test(description = "Add new account with customer id first character cannot be space")
	public void New_Account_05() {
		
	}
	
	@Test(description = "Add new account with initial deposit cannot be empty")
	public void New_Account_06() {
		
	}
	
	@Test(description = "Add new account with initial deposit must be numeric")
	public void New_Account_07() {
		
	}
	
	@Test(description = "Add new account with initial deposit cannot have special character")
	public void New_Account_08() {
		
	}
	
	@Test(description = "Add new account with initial deposit cannot have blank space")
	public void New_Account_09() {
		
	}
	
	@Test(description = "Add new account with initial deposit first character cannot be space")
	public void New_Account_10() {
		
	}

	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
