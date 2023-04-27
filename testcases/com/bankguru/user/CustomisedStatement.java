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

public class CustomisedStatement extends BaseTest {
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

	@Test(description = "Customized statement with account number cannot be empty")
	public void Customized_Statement_01() {
		
	}

	@Test(description = "Customized statement with account number must be numeric")
	public void Customized_Statement_02() {
		
	}

	@Test(description = "Customized statement with account number cannot have special character")
	public void Customized_Statement_03() {
		
	}
	
	@Test(description = "Customized statement with account number cannot have blank space")
	public void Customized_Statement_04() {
		
	}
	
	@Test(description = "Customized statement with account number first character cannot be space")
	public void Customized_Statement_05() {
		
	}
	
	@Test(description = "Customized statement with amount lower limit cannot be empty")
	public void Customized_Statement_06() {
		
	}

	@Test(description = "Customized statement with amount lower limit must be numeric")
	public void Customized_Statement_07() {
		
	}

	@Test(description = "Customized statement with amount lower limit cannot have special character")
	public void Customized_Statement_08() {
		
	}
	
	@Test(description = "Customized statement with amount lower limit cannot have blank space")
	public void Customized_Statement_09() {
		
	}
	
	@Test(description = "Customized statement with amount lower limit first character cannot be space")
	public void Customized_Statement_10() {
		
	}
	
	@Test(description = "Customized statement with number of transaction limit cannot be empty")
	public void Customized_Statement_11() {
		
	}

	@Test(description = "Customized statement with number of transaction limit must be numeric")
	public void Customized_Statement_12() {
		
	}

	@Test(description = "Customized statement with number of transaction limit cannot have special character")
	public void Customized_Statement_13() {
		
	}
	
	@Test(description = "Customized statement with number of transaction limit cannot have blank space")
	public void Customized_Statement_14() {
		
	}
	
	@Test(description = "Customized statement with number of transaction limit first character cannot be space")
	public void Customized_Statement_15() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
