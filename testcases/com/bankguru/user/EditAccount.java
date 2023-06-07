package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.EditAccountPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class EditAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject  homePage;
	EditAccountPageObject editAccountPage;

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

	@Test(description = "Edit account with account number cannot be empty")
	public void Edit_Account_01() {
		log.info("Edit_Account_01 - Step 01: Open 'Edit Account' page");
		homePage.openMenuPage(driver, "Edit Account");
		editAccountPage = PageGenerator.getEditAccountPage(driver);
		
		log.info("Edit_Account_01 - Step 02: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "");
		
		log.info("Edit_Account_01 - Step 03: Click 'Tab'");
		editAccountPage.sendkeyBoardToElement(driver, "accountno", Keys.TAB);
		
		log.info("Edit_Account_01 - Step 04: Verify error message");
		verifyEquals(editAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Account Number must not be blank");
	}
	
	@Test(description = "Edit account with account number must be numeric")
	public void Edit_Account_02() {
		log.info("Edit_Account_02 - Step 01: Refresh 'Edit Account' page");
		editAccountPage.refreshCurrentPage(driver);
		
		log.info("Edit_Account_02 - Step 02: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "1234Acc");
		
		log.info("Edit_Account_02 - Step 03: Verify error message");
		verifyEquals(editAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
		
		log.info("Edit_Account_02 - Step 04: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "Acc123");
		
		log.info("Edit_Account_02 - Step 05: Verify error message");
		verifyEquals(editAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}
	
	@Test(description = "Edit account with account number cannot have special character")
	public void Edit_Account_03() {
		log.info("Edit_Account_03 - Step 01: Refresh 'Edit Account' page");
		editAccountPage.refreshCurrentPage(driver);
		
		log.info("Edit_Account_03 - Step 02: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "123!@#");
		
		log.info("Edit_Account_03 - Step 03: Verify error message");
		verifyEquals(editAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
		
		log.info("Edit_Account_03 - Step 04: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "!@#");
		
		log.info("Edit_Account_03 - Step 05: Verify error message");
		verifyEquals(editAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
	}
	
	@Test(description = "Edit account with valid account number")
	public void Edit_Account_04() {
		log.info("Edit_Account_04 - Step 01: Refresh 'Edit Account' page");
		editAccountPage.refreshCurrentPage(driver);
		
		log.info("Edit_Account_04 - Step 02: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "551431");
		
		log.info("Edit_Account_04 - Step 03: Click to 'Submit' button");
		editAccountPage.clickToButtonByIDName(driver, "AccSubmit");
		
		log.info("Edit_Account_04 - Step 04: Verify title display");
		verifyTrue(editAccountPage.isEditCustomerPageDisplayed(driver, "Edit Account"));
	}
	
	@Test(description = "Edit account with account number cannot have blank space")
	public void Edit_Account_05() {
		log.info("Edit_Account_05 - Step 01: Refresh 'Edit Account' page");
		editAccountPage.refreshCurrentPage(driver);
		
		log.info("Edit_Account_05 - Step 02: Sendkey to 'Account No' field");
		editAccountPage.enterToTextboxByIDName(driver, "accountno", "551 43");
		
		log.info("Edit_Account_05 - Step 03: Verify error message");
		verifyEquals(editAccountPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
