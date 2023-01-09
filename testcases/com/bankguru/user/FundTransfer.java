package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.bankguru.DashboardPageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class FundTransfer extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition: Step 01 - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Pre-condition: Step 02 - Login with Admin role");
		dashboardPage = loginPage.loginToSystem(GlobalConstants.PROJECT_ADMIN_EMAIL, GlobalConstants.PROJECT_ADMIN_PASSWORD);
	}

	@Test
	public void Controller_01_Add_New_Controller() {
		
	}

	@Test
	public void Controller_02_Edit_Controller() {
		
	}

	@Test
	public void Controller_03_Assign_CardReader() {
		
	}
	
	@Test
	public void Controller_05_Add_New_DI_Event() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
