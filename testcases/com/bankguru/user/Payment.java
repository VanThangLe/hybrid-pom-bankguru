package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.FundTransferPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewAccountPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGenerator;
import pageObjects.bankguru.WithDrawalPageObject;

public class Payment extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	NewAccountPageObject newAccountPage;
	WithDrawalPageObject withDrawalPage;
	FundTransferPageObject fundTransferpage;
	String customerID, accountID;

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

	@Test(description = "Create new customer account and check created successfully")
	public void Payment_01() {
		log.info("Payment_01 - Step 01: Open 'New Customer' page");
		homePage.openMenuPage(driver, "New Customer");
		newCustomerPage = PageGenerator.getNewCustomerPage(driver);
		
		log.info("Payment_01 - Step 02: Sendkey to all fields");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "AUTOMATION TESTING");
		newCustomerPage.enterToTextboxByIDName(driver, "dob", "01/01/1989");
		newCustomerPage.enterToTextboxByIDName(driver, "addr", "PO Box 911 8331 Duis Avenue");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "Tampa");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "FL");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "466250");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "4555442476");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "automation1@gmail.com");
		newCustomerPage.enterToTextboxByIDName(driver, "password", "automation");
		
		log.info("Payment_01 - Step 03: Click to 'Submit' button");
		newCustomerPage.clickToButtonByIDName(driver, "sub");
		
		log.info("Payment_01 - Step 04: Verify data value");
		verifyTrue(newCustomerPage.isTitleTextPageDisplayed(driver, "Customer Registered Successfully!!!"));
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Customer Name"), "AUTOMATION TESTING");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Birthdate"), "1989-01-01");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Address"), "PO Box 911 8331 Duis Avenue");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "City"), "Tampa");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "State"), "FL");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Pin"), "466250");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Mobile No."), "4555442476");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Email"), "automation1@gmail.com");
		customerID = newCustomerPage.getTextByIDName(driver, "Customer ID");
	}

	@Test(description = "Edit customer account and check edited successfully")
	public void Payment_02() {
		log.info("Payment_02 - Step 01: Open 'Edit Customer' page");
		newCustomerPage.openMenuPage(driver, "Edit Customer");
		editCustomerPage = PageGenerator.getEditCustomerPage(driver);
		
		log.info("Payment_02 - Step 02: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", customerID);
		
		log.info("Payment_02 - Step 03: Click to 'Submit' button");
		editCustomerPage.clickToButtonByIDName(driver, "AccSubmit");
		
		log.info("Payment_02 - Step 04: Sendkey to editable field");
		editCustomerPage.enterToTextboxByIDName(driver, "addr", "1883 Cursus Avenue");
		editCustomerPage.enterToTextboxByIDName(driver, "city", "Houston");
		editCustomerPage.enterToTextboxByIDName(driver, "state", "Texas");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "166455");
		editCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "4779728081");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "testing@gmail.com");
		
		log.info("Payment_02 - Step 05: Click to 'Submit' button");
		editCustomerPage.clickToButtonByIDName(driver, "sub");
		
		log.info("Payment_02 - Step 06: Click accept alert");
		editCustomerPage.acceptAlert(driver);
		
		log.info("Payment_02 - Step 07: Open 'Edit Customer' page");
		editCustomerPage.openMenuPage(driver, "Edit Customer");
		
		log.info("Payment_02 - Step 08: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", customerID);
		
		log.info("Payment_02 - Step 09: Click to 'Submit' button");
		editCustomerPage.clickToButtonByIDName(driver, "AccSubmit");
		
		log.info("Payment_02 - Step 10: Verify data value");
		verifyEquals(editCustomerPage.getTextByIDName(driver, "Address"), "1883 Cursus Avenue");
		verifyEquals(editCustomerPage.getTextByIDName(driver, "City"), "Houston");
		verifyEquals(editCustomerPage.getTextByIDName(driver, "State"), "Texas");
		verifyEquals(editCustomerPage.getTextByIDName(driver, "Pin"), "166455");
		verifyEquals(editCustomerPage.getTextByIDName(driver, "Mobile No."), "4779728081");
		verifyEquals(editCustomerPage.getTextByIDName(driver, "Email"), "testing@gmail.com");
	}
	
	@Test(description = "Add new account and check created successfully, then verify 'Current Amount' and 'Initial Deposit' are equal")
	public void Payment_03() {
		log.info("Payment_03 - Step 01: Open 'New Account' page");
		editCustomerPage.openMenuPage(driver, "New Account");
		newAccountPage = PageGenerator.getNewAccountPage(driver);
		
		log.info("Payment_03 - Step 02: Sendkey to all field");
		newAccountPage.enterToTextboxByIDName(driver, "cusid", customerID);
		newAccountPage.enterToTextboxByIDName(driver, "inideposit", "50000");
		
		log.info("Payment_03 - Step 03: Click to 'Submit' button");
		newAccountPage.clickToButtonByIDName(driver, "button2");
		
		log.info("Payment_03 - Step 04: Verify data value");
		verifyTrue(newAccountPage.isTitleTextPageDisplayed(driver, "Account Generated Successfully!!!"));
		verifyEquals(newAccountPage.getTextByIDName(driver, "Current Amount"), "50000");
		accountID = newAccountPage.getTextByIDName(driver, "Account ID");
	}
	
	@Test(description = "Withdraw money from current account")
	public void Payment_04() {
		log.info("Payment_04 - Step 01: Open 'Withdrawal' page");
		newAccountPage.openMenuPage(driver, "Withdrawal");
		withDrawalPage = PageGenerator.getWithDrawalPage(driver);
		
		log.info("Payment_04 - Step 02: Sendkey to all field");
		withDrawalPage.enterToTextboxByIDName(driver, "accountno", accountID);
		withDrawalPage.enterToTextboxByIDName(driver, "ammount", "5000");
		withDrawalPage.enterToTextboxByIDName(driver, "desc", "withdrawal");
		
		log.info("Payment_04 - Step 03: Click to 'Submit' button");
		withDrawalPage.clickToButtonByIDName(driver, "AccSubmit");
		
		log.info("Payment_04 - Step 04: Verify data value");
		verifyTrue(withDrawalPage.isTitleTextPageDisplayed(driver, "Transaction details of Withdrawal for Account" + accountID));
	}
	
	@Test(description = "Transfer the money into another account and check amount equal 10,000")
	public void Payment_05() {
		log.info("Payment_05 - Step 01: Open 'Fund Transfer' page");
		withDrawalPage.openMenuPage(driver, "Fund Transfer");
		fundTransferpage = PageGenerator.getFundTransferPage(driver);
		
		log.info("Payment_05 - Step 02: Sendkey to all field");
		fundTransferpage.enterToTextboxByIDName(driver, "payersaccount", "123396");
		fundTransferpage.enterToTextboxByIDName(driver, "payeeaccount", "123397");
		fundTransferpage.enterToTextboxByIDName(driver, "ammount", "10000");
		fundTransferpage.enterToTextboxByIDName(driver, "desc", "fund transfer");
		
		log.info("Payment_05 - Step 03: Click to 'Submit' button");
		fundTransferpage.clickToButtonByIDName(driver, "AccSubmit");
		
		log.info("Payment_05 - Step 04: Verify data value");
		verifyTrue(fundTransferpage.isTitleTextPageDisplayed(driver, "Fund Transfer Details"));
		verifyEquals(fundTransferpage.getTextByIDName(driver, "ammount"), "10000");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
