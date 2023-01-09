package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.DashboardPageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class CustomizedStatement extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	String userGroupName, userGroupCode;
	String userGroupNameUpdate, userGroupCodeUpdate;

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
		
		userGroupName = "Group 1";
		userGroupCode = "groupcode1";
		userGroupNameUpdate = "Group 1 Update";
		userGroupCodeUpdate = "groupcode1update";
	}

	@Test
	public void UserGroup_01_Add_New_UserGroup() {
		log.info("UserGroup_01 - Step 01: Open 'Nhóm người dùng' menu");
		dashboardPage.openMenuPage(driver, "Nhóm người dùng");
		
	}

	@Test
	public void UserGroup_02_Edit_UserGroup() {
	
	}

	@Test
	public void UserGroup_03_Assign_User() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
