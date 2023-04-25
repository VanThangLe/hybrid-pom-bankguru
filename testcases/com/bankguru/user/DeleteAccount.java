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

public class DeleteAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
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

	@Test
	//Delete account with account number cannot be empty
	public void Delete_Account_01() {
		
	}
	
	@Test
	//Delete account with account number must be numeric
	public void Delete_Account_02() {
		
	}
	
	@Test
	//Delete account with account number cannot have special character
	public void Delete_Account_03() {
		
	}
	
	@Test
	//Delete account with account number cannot have blank space
	public void Delete_Account_04() {
		
	}
	
	@Test
	//Delete account with account number first character cannot be space
	public void Delete_Account_05() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true) 
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
