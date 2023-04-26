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

public class FundTransfer extends BaseTest {
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

	@Test(description = "Fund transfer with bank code cannot be empty")
	public void Fund_Transfer_01() {
		
	}

	@Test(description = "Fund transfer with bank code cannot have special character")
	public void Fund_Transfer_02() {
		
	}

	@Test(description = "Fund transfer with bank code first character cannot have space")
	public void Fund_Transfer_03() {
		
	}
	
	@Test(description = "Fund transfer with payers account number cannot be empty")
	public void Fund_Transfer_04() {
		
	}
	
	@Test(description = "Fund transfer with payers account number must be numeric")
	public void Fund_Transfer_05() {
		
	}
	
	@Test(description = "Fund transfer with payers account number must cannot have special character")
	public void Fund_Transfer_06() {
		
	}
	
	@Test(description = "Fund transfer with payee account number cannot be empty")
	public void Fund_Transfer_07() {
		
	}
	
	@Test(description = "Fund transfer with payee account number must be numeric")
	public void Fund_Transfer_08() {
		
	}
	
	@Test(description = "Fund transfer with payee account number cannot have special character")
	//
	public void Fund_Transfer_09() {
		
	}
	
	@Test(description = "Fund transfer with amount cannot be empty")
	public void Fund_Transfer_10() {
		
	}
	
	@Test(description = "Fund transfer with amount must be numeric")
	public void Fund_Transfer_11() {
		
	}
	
	@Test(description = "Fund transfer with amount cannot have special character")
	public void Fund_Transfer_12() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
