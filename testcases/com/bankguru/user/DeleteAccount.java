package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.DeleteAccountPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class DeleteAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	DeleteAccountPageObject deleteAccountPage;

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

	@Test(description = "Delete account with account number cannot be empty")
	public void Delete_Account_01() {
		log.info("Delete_Account_01 - Step 01: Open 'Delete Account' page");
		homePage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Delete_Account_01 - Step 02: Sendkey to 'Account No' field");
		deleteAccountPage.enterToTextboxByIDName(driver, "accountno", "");
		
		log.info("Delete_Account_01 - Step 03: Click 'Tab'");
		deleteAccountPage.sendkeyBoardToElement(driver, "accountno", Keys.TAB);
		
		log.info("Delete_Account_01 - Step 04: Verify error message");
		verifyEquals(deleteAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Account Number must not be blank");
	}
	
	@Test(description = "Delete account with account number must be numeric")
	public void Delete_Account_02() {
		log.info("Delete_Account_02 - Step 01: Refresh 'Delete Account' page");
		deleteAccountPage.refreshCurrentPage(driver);
		
		log.info("Delete_Account_02 - Step 02: Sendkey to 'Account No' field");
		deleteAccountPage.enterToTextboxByIDName(driver, "accountno", "1234Acc");
		
		log.info("Delete_Account_02 - Step 03: Verify error message");
		verifyEquals(deleteAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
		
		log.info("Delete_Account_02 - Step 04: Sendkey to 'Account No' field");
		deleteAccountPage.enterToTextboxByIDName(driver, "accountno", "Acc123");
		
		log.info("Delete_Account_02 - Step 05: Verify error message");
		verifyEquals(deleteAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}
	
	@Test(description = "Delete account with account number cannot have special character")
	public void Delete_Account_03() {
		log.info("Delete_Account_03 - Step 01: Refresh 'Delete Account' page");
		deleteAccountPage.refreshCurrentPage(driver);
		
		log.info("Delete_Account_03 - Step 02: Sendkey to 'Account No' field");
		deleteAccountPage.enterToTextboxByIDName(driver, "accountno", "123!@#");
		
		log.info("Delete_Account_03 - Step 03: Verify error message");
		verifyEquals(deleteAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
		
		log.info("Delete_Account_03 - Step 04: Sendkey to 'Account No' field");
		deleteAccountPage.enterToTextboxByIDName(driver, "accountno", "!@#");
		
		log.info("Delete_Account_03 - Step 05: Verify error message");
		verifyEquals(deleteAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
	}
	
	@Test(description = "Delete account with account number cannot have blank space")
	public void Delete_Account_04() {
		log.info("Delete_Account_04 - Step 01: Refresh 'Delete Account' page");
		deleteAccountPage.refreshCurrentPage(driver);
		
		log.info("Delete_Account_04 - Step 02: Sendkey to 'Account No' field");
		deleteAccountPage.enterToTextboxByIDName(driver, "accountno", "551 43");
		
		log.info("Delete_Account_04 - Step 03: Verify error message");
		verifyEquals(deleteAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true) 
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
