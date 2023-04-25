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

public class ChangePassword extends BaseTest {
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
	//Change password with old password cannot be empty
	public void Change_Password_01() {
		
	}
	
	@Test
	//Change password with new password cannot be empty
	public void Change_Password_02() {
		
	}
	
	@Test
	//Change password with new password must have one numeric value
	public void Change_Password_03() {
		
	}
	
	@Test
	//Change password with new password must have one special character
	public void Change_Password_04() {
		
	}
	
	@Test
	//Change password with password cannot have string password or Password
	public void Change_Password_05() {
		
	}
	
	@Test
	//Change password with confirm password and new password must be matched
	public void Change_Password_06() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
