package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.DeleteCustomerPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class DeleteCustomer extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	DeleteCustomerPageObject deleteCustomerPage;

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

	@Test(description = "Delete customer with customer id cannot be empty")
	public void Delete_Customer_01() {
		log.info("Delete_Customer_01 - Step 01: Open 'Delete Customer' page");
		homePage.openMenuPage(driver, "Delete Customer");
		deleteCustomerPage = PageGenerator.getDeleteCustomerPage(driver);
		
		log.info("Delete_Customer_01 - Step 02: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", "");
		
		log.info("Delete_Customer_01 - Step 03: Click 'Tab'");
		deleteCustomerPage.sendkeyBoardToElement(driver, "cusid", Keys.TAB);
		
		log.info("Delete_Customer_01 - Step 04: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Customer ID is required");
	}

	@Test(description = "Delete customer with customer id must be numeric")
	public void Delete_Customer_02() {
		log.info("Delete_Customer_02 - Step 01: Refresh 'Delete Customer' page");
		deleteCustomerPage.refreshCurrentPage(driver);
		
		log.info("Delete_Customer_02 - Step 02: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", "1234Acc");
		
		log.info("Delete_Customer_02 - Step 03: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
		
		log.info("Delete_Customer_02 - Step 04: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", "Acc123");
		
		log.info("Delete_Customer_02 - Step 05: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
	}
	
	@Test(description = "Delete customer with customer id cannot have special character")
	public void Delete_Customer_03() {
		log.info("Delete_Customer_03 - Step 01: Refresh 'Delete Customer' page");
		deleteCustomerPage.refreshCurrentPage(driver);
		
		log.info("Delete_Customer_03 - Step 02: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", "123!@#");
		
		log.info("Delete_Customer_03 - Step 03: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Special characters are not allowed");
		
		log.info("Delete_Customer_03 - Step 04: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", "!@#");
		
		log.info("Delete_Customer_03 - Step 05: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Special characters are not allowed");
	}
	
	@Test(description = "Delete customer with customer id cannot have black space")
	public void Delete_Customer_04() {
		log.info("Delete_Customer_04 - Step 01: Refresh 'Delete Customer' page");
		deleteCustomerPage.refreshCurrentPage(driver);
		
		log.info("Delete_Customer_04 - Step 02: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", "551 43");
		
		log.info("Delete_Customer_04 - Step 03: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
	}
	
	@Test(description = "Delete customer with customer id first character cannot be space")
	public void Delete_Customer_05() {
		log.info("Delete_Customer_05 - Step 01: Refresh 'Delete Customer' page");
		deleteCustomerPage.refreshCurrentPage(driver);
		
		log.info("Delete_Customer_05 - Step 02: Sendkey to 'Customer ID' field");
		deleteCustomerPage.enterToTextboxByIDName(driver, "cusid", " 55143");
		
		log.info("Delete_Customer_05 - Step 03: Click 'Tab'");
		deleteCustomerPage.sendkeyBoardToElement(driver, "cusid", Keys.TAB);
		
		log.info("Delete_Customer_05 - Step 04: Verify error message");
		verifyEquals(deleteCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "First character can not have space");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
