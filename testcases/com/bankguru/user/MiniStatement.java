package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.MiniStatementPageObject;
import pageObjects.bankguru.PageGenerator;

public class MiniStatement extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	MiniStatementPageObject miniStatementPage;

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

	@Test(description = "Mini statement with account number cannot be empty")
	public void Mini_Statement_01() {
		log.info("Mini_Statement_01 - Step 01: Open 'Mini Statement' page");
		homePage.openMenuPage(driver, "Edit Account");
		miniStatementPage = PageGenerator.getMiniStatementPage(driver);
		
		log.info("Mini_Statement_01 - Step 02: Sendkey to 'Account No' field");
		miniStatementPage.enterToTextboxByIDName(driver, "accountno", "");
		
		log.info("Mini_Statement_01 - Step 03: Click 'Tab'");
		miniStatementPage.sendkeyBoardToElement(driver, "accountno", Keys.TAB);
		
		log.info("Mini_Statement_01 - Step 04: Verify error message");
		verifyEquals(miniStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Account Number is required");
	}

	@Test(description = "Mini statement with account number must be numeric")
	public void Mini_Statement_02() {
		log.info("Mini_Statement_02 - Step 01: Refresh 'Mini Statement' page");
		miniStatementPage.refreshCurrentPage(driver);
		
		log.info("Mini_Statement_02 - Step 02: Sendkey to 'Account No' field");
		miniStatementPage.enterToTextboxByIDName(driver, "accountno", "1234Acc");
		
		log.info("Mini_Statement_02 - Step 03: Verify error message");
		verifyEquals(miniStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
		
		log.info("Mini_Statement_02 - Step 04: Sendkey to 'Account No' field");
		miniStatementPage.enterToTextboxByIDName(driver, "accountno", "Acc123");
		
		log.info("Mini_Statement_02 - Step 05: Verify error message");
		verifyEquals(miniStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}

	@Test(description = "Mini statement with account number cannot have special character")
	public void Mini_Statement_03() {
		log.info("Mini_Statement_03 - Step 01: Refresh 'Mini Statement' page");
		miniStatementPage.refreshCurrentPage(driver);
		
		log.info("Mini_Statement_03 - Step 02: Sendkey to 'Account No' field");
		miniStatementPage.enterToTextboxByIDName(driver, "accountno", "123!@#");
		
		log.info("Mini_Statement_03 - Step 03: Verify error message");
		verifyEquals(miniStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
		
		log.info("Mini_Statement_03 - Step 04: Sendkey to 'Account No' field");
		miniStatementPage.enterToTextboxByIDName(driver, "accountno", "!@#");
		
		log.info("Mini_Statement_03 - Step 05: Verify error message");
		verifyEquals(miniStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
	}
	
	@Test(description = "Mini statement with account number cannot have blank space")
	public void Mini_Statement_04() {
		log.info("Mini_Statement_04 - Step 01: Refresh 'Mini Statement' page");
		miniStatementPage.refreshCurrentPage(driver);
		
		log.info("Mini_Statement_04 - Step 02: Sendkey to 'Account No' field");
		miniStatementPage.enterToTextboxByIDName(driver, "accountno", "551 43");
		
		log.info("Mini_Statement_04 - Step 03: Verify error message");
		verifyEquals(miniStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
