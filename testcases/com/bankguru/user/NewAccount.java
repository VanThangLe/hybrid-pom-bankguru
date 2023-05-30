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
import pageObjects.bankguru.NewAccountPageObject;
import pageObjects.bankguru.PageGenerator;

public class NewAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewAccountPageObject newAccountPage;
	public static String accountID;

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
		log.info("New_Account_01 - Step 01: Open 'New Account' page");
		homePage.openMenuPage(driver, "Delete Customer");
		newAccountPage = PageGenerator.getNewAccountPage(driver);
		
		log.info("New_Account_01 - Step 02: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "");
		
		log.info("New_Account_01 - Step 03: Click 'Tab'");
		newAccountPage.sendkeyBoardToElement(driver, "cusid", Keys.TAB);
		
		log.info("New_Account_01 - Step 04: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "Customer ID is required");
	}
	
	@Test(description = "Add new account with customer id must be numeric")
	public void New_Account_02() {
		log.info("New_Account_02 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_02 - Step 02: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "1234Acc");
		
		log.info("New_Account_02 - Step 03: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
		
		log.info("New_Account_02 - Step 04: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "Acc123");
		
		log.info("New_Account_02 - Step 05: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
	}
	
	@Test(description = "Add new account with customer id cannot have special character")
	public void New_Account_03() {
		log.info("New_Account_03 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_03 - Step 02: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "123!@#");
		
		log.info("New_Account_03 - Step 03: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "Special characters are not allowed");
		
		log.info("New_Account_03 - Step 04: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "!@#");
		
		log.info("New_Account_03 - Step 05: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "Special characters are not allowed");
	}
	
	@Test(description = "Add new account with customer id cannot have blank space")
	public void New_Account_04() {
		log.info("New_Account_04 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_04 - Step 02: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "551 43");
		
		log.info("New_Account_04 - Step 03: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
	}
	
	@Test(description = "Add new account with customer id first character cannot be space")
	public void New_Account_05() {
		log.info("New_Account_05 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_05 - Step 02: Sendkey to 'Customer ID' field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", " 55143");
		
		log.info("New_Account_05 - Step 03: Click 'Tab'");
		newAccountPage.sendkeyBoardToElement(driver, "cusid", Keys.TAB);
		
		log.info("New_Account_05 - Step 04: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message14"), "First character can not have space");
	}
	
	@Test(description = "Add new account with initial deposit cannot be empty")
	public void New_Account_06() {
		log.info("New_Account_06 - Step 01: Open 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_06 - Step 02: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "");
		
		log.info("New_Account_06 - Step 03: Click 'Tab'");
		newAccountPage.sendkeyBoardToElement(driver, "inideposit", Keys.TAB);
		
		log.info("New_Account_06 - Step 04: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "Initial Deposit must not be blank");
	}
	
	@Test(description = "Add new account with initial deposit must be numeric")
	public void New_Account_07() {
		log.info("New_Account_07 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_07 - Step 02: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "1234Acc");
		
		log.info("New_Account_07 - Step 03: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "Characters are not allowed");
		
		log.info("New_Account_07 - Step 04: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "Acc123");
		
		log.info("New_Account_07 - Step 05: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "Characters are not allowed");
	}
	
	@Test(description = "Add new account with initial deposit cannot have special character")
	public void New_Account_08() {
		log.info("New_Account_08 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_08 - Step 02: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "123!@#");
		
		log.info("New_Account_08 - Step 03: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "Special characters are not allowed");
		
		log.info("New_Account_08 - Step 04: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "!@#");
		
		log.info("New_Account_08 - Step 05: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "Special characters are not allowed");
	}
	
	@Test(description = "Add new account with initial deposit cannot have blank space")
	public void New_Account_09() {
		log.info("New_Account_09 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_09 - Step 02: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "100 00");
		
		log.info("New_Account_09 - Step 03: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "Characters are not allowed");
	}
	
	@Test(description = "Add new account with initial deposit first character cannot be space")
	public void New_Account_10() {
		log.info("New_Account_10 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_10 - Step 02: Sendkey to 'Initial deposit' field");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", " 10000");
		
		log.info("New_Account_10 - Step 03: Click 'Tab'");
		newAccountPage.sendkeyBoardToElement(driver, "inideposit", Keys.TAB);
		
		log.info("New_Account_10 - Step 04: Verify error message");
		verifyEquals(newAccountPage.getErrorMessageByIDLabel(driver, "message19"), "First character can not have space");
	}
	
	@Test(description = "Add new account success")
	public void New_Account_11() {
		log.info("New_Account_11 - Step 01: Refresh 'New Account' page");
		newAccountPage.refreshCurrentPage(driver);
		
		log.info("New_Account_11 - Step 02: Sendkey to all field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", "55143");
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "10000");
		
		log.info("New_Account_11 - Step 03: Click to 'Submit' button");
		newAccountPage.clickToButtonByIDName(driver, "button2");
		
		log.info("New_Account_11 - Step 04: Verify data value");
		verifyEquals(newAccountPage.getTextByIDName(driver, "Customer ID"), "55143");
		verifyEquals(newAccountPage.getTextByIDName(driver, "Current Amount"), "10000");
		accountID = newAccountPage.getTextByIDName(driver, "Account ID");
	}

	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
