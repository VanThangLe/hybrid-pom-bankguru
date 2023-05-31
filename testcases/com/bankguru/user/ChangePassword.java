package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.ChangePasswordPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class ChangePassword extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	ChangePasswordPageObject changePasswordPage;

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

	@Test(description = "Change password with old password cannot be empty")
	public void Change_Password_01() {
		log.info("Change_Password_01 - Step 01: Open 'Change Password' page");
		homePage.openMenuPage(driver, "Change Password");
		changePasswordPage = PageGenerator.getChangePasswordPage(driver);
		
		log.info("Change_Password_01 - Step 02: Sendkey to 'Old Password' field");
		changePasswordPage.enterToTextboxByIDName(driver, "oldpassword", "");
		
		log.info("Change_Password_01 - Step 03: Click 'Tab'");
		changePasswordPage.sendkeyBoardToElement(driver, "oldpassword", Keys.TAB);
		
		log.info("Change_Password_01 - Step 04: Verify error message");
		verifyEquals(changePasswordPage.getErrorMessageByIDLabel(driver, "message20"), "Old Password must not be blank");
	}
	
	@Test(description = "Change password with new password cannot be empty")
	public void Change_Password_02() {
		log.info("Change_Password_02 - Step 01: Open 'Change Password' page");
		changePasswordPage.refreshCurrentPage(driver);
		
		log.info("Change_Password_02 - Step 02: Sendkey to 'New Password' field");
		changePasswordPage.enterToTextboxByIDName(driver, "newpassword", "");
		
		log.info("Change_Password_02 - Step 03: Click 'Tab'");
		changePasswordPage.sendkeyBoardToElement(driver, "newpassword", Keys.TAB);
		
		log.info("Change_Password_02 - Step 04: Verify error message");
		verifyEquals(changePasswordPage.getErrorMessageByIDLabel(driver, "message21"), "New Password must not be blank");
	}
	
	@Test(description = "Change password with new password must have one numeric value")
	public void Change_Password_03() {
		log.info("Change_Password_03 - Step 01: Refresh 'Change Password' page");
		changePasswordPage.refreshCurrentPage(driver);
		
		log.info("Change_Password_03 - Step 02: Sendkey to 'New Password' field");
		changePasswordPage.enterToTextboxByIDName(driver, "newpassword", "Guru!@#$");
		
		log.info("Change_Password_03 - Step 03: Verify error message");
		verifyEquals(changePasswordPage.getErrorMessageByIDLabel(driver, "message21"), "Enter at-least one numeric value");
	}
	
	@Test(description = "Change password with new password must have one special character")
	public void Change_Password_04() {
		log.info("Change_Password_04 - Step 01: Refresh 'Change Password' page");
		changePasswordPage.refreshCurrentPage(driver);
		
		log.info("Change_Password_04 - Step 02: Sendkey to 'New Password' field");
		changePasswordPage.enterToTextboxByIDName(driver, "newpassword", "Guru99");
		
		log.info("Change_Password_04 - Step 03: Verify error message");
		verifyEquals(changePasswordPage.getErrorMessageByIDLabel(driver, "message21"), "Enter at-least one special character");
	}
	
	@Test(description = "Change password with password cannot have string password or Password")
	public void Change_Password_05() {
		log.info("Change_Password_05 - Step 01: Refresh 'Change Password' page");
		changePasswordPage.refreshCurrentPage(driver);
		
		log.info("Change_Password_05 - Step 02: Sendkey to 'New Password' field");
		changePasswordPage.enterToTextboxByIDName(driver, "newpassword", "Guru99!@Password");
		
		log.info("Change_Password_05 - Step 03: Verify error message");
		verifyEquals(changePasswordPage.getErrorMessageByIDLabel(driver, "message21"), "Choose a difficult Password");
	}
	
	@Test(description = "Change password with confirm password and new password must be matched")
	public void Change_Password_06() {
		log.info("Change_Password_06 - Step 01: Refresh 'Change Password' page");
		changePasswordPage.refreshCurrentPage(driver);
		
		log.info("Change_Password_06 - Step 02: Sendkey to all field");
		changePasswordPage.enterToTextboxByIDName(driver, "newpassword", "Guru99!@");
		changePasswordPage.enterToTextboxByIDName(driver, "confirmpassword", "Guru99!@P");
		
		log.info("Change_Password_06 - Step 03: Verify error message");
		verifyEquals(changePasswordPage.getErrorMessageByIDLabel(driver, "message22"), "Passwords do not Match");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
