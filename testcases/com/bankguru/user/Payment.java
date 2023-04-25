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

public class Payment extends BaseTest {
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
	//Create new customer account and check created successfully
	public void Payment_01() {
		
	}

	@Test
	//Edit customer account and check edited successfully
	public void Payment_02() {
		
	}
	
	@Test
	//Add new account and check created successfully, then verify 'Current Amount' and 'Initial Deposit' are equal
	public void Payment_03() {
		
	}
	
	@Test
	//Edit account anh check type of Account is 'Current'
	public void Payment_04() {
		
	}
	
	@Test
	//Transfer money into a current account and check account balance equal 55,000
	public void Payment_05() {
		
	}
	
	@Test
	//Withdraw money from current account and check account balance equal 40,000
	public void Payment_06() {
		
	}
	
	@Test
	//Transfer the money into another account and check amount equal 10,000
	public void Payment_07() {
		
	}
	
	@Test
	//Check current account balance equal 30,000
	public void Payment_08() {
		
	}
	
	@Test
	//Delete all account of this customer account and check deleted successfully
	public void Payment_09() {
		
	}
	
	@Test
	//Delete exist customer account and check deleted successfully
	public void Payment_10() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
