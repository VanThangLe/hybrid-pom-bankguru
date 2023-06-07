package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.FundTransferPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class FundTransfer extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	FundTransferPageObject fundTransferPage;

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
	
	@Test(description = "Fund transfer with payers account number cannot be empty")
	public void Fund_Transfer_01() {
		log.info("Fund_Transfer_01 - Step 01: Open 'Fund Transfer' page");
		homePage.openMenuPage(driver, "Fund Transfer");
		fundTransferPage = PageGenerator.getFundTransferPage(driver);
		
		log.info("Fund_Transfer_01 - Step 02: Sendkey to 'Payers account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payersaccount", "");
		
		log.info("Fund_Transfer_01 - Step 03: Click 'Tab'");
		fundTransferPage.sendkeyBoardToElement(driver, "payersaccount", Keys.TAB);
		
		log.info("Fund_Transfer_01 - Step 04: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message10"), "Payers Account Number must not be blank");
	}
	
	@Test(description = "Fund transfer with payers account number must be numeric")
	public void Fund_Transfer_02() {
		log.info("Fund_Transfer_02 - Step 01: Refresh 'Fund Transfer' page");
		fundTransferPage.refreshCurrentPage(driver);
		
		log.info("Fund_Transfer_02 - Step 02: Sendkey to 'Payers account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payersaccount", "1234Acc");
		
		log.info("Fund_Transfer_02 - Step 03: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message10"), "Characters are not allowed");
		
		log.info("Fund_Transfer_02 - Step 04: Sendkey to 'Payers account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payersaccount", "Acc123");
		
		log.info("Fund_Transfer_02 - Step 05: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message10"), "Characters are not allowed");
	}
	
	@Test(description = "Fund transfer with payers account number must cannot have special character")
	public void Fund_Transfer_03() {
		log.info("Fund_Transfer_03 - Step 01: Refresh 'Fund Transfer' page");
		fundTransferPage.refreshCurrentPage(driver);
		
		log.info("Fund_Transfer_03 - Step 02: Sendkey to 'Payers account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payersaccount", "123!@#");
		
		log.info("Fund_Transfer_03 - Step 03: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message10"), "Special characters are not allowed");
		
		log.info("Fund_Transfer_03 - Step 04: Sendkey to 'Payers account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payersaccount", "!@#");
		
		log.info("Fund_Transfer_03 - Step 05: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message10"), "Special characters are not allowed");
	}
	
	@Test(description = "Fund transfer with payee account number cannot be empty")
	public void Fund_Transfer_04() {
		log.info("Fund_Transfer_04 - Step 01: Open 'Fund Transfer' page");
		homePage.openMenuPage(driver, "Fund Transfer");
		fundTransferPage = PageGenerator.getFundTransferPage(driver);
		
		log.info("Fund_Transfer_04 - Step 02: Sendkey to 'Payees account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payeeaccount", "");
		
		log.info("Fund_Transfer_04 - Step 03: Click 'Tab'");
		fundTransferPage.sendkeyBoardToElement(driver, "payeeaccount", Keys.TAB);
		
		log.info("Fund_Transfer_01 - Step 04: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message11"), "Payees Account Number must not be blank");
	}
	
	@Test(description = "Fund transfer with payee account number must be numeric")
	public void Fund_Transfer_05() {
		log.info("Fund_Transfer_05 - Step 01: Refresh 'Fund Transfer' page");
		fundTransferPage.refreshCurrentPage(driver);
		
		log.info("Fund_Transfer_05 - Step 02: Sendkey to 'Payees account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payeeaccount", "1234Acc");
		
		log.info("Fund_Transfer_05 - Step 03: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message11"), "Characters are not allowed");
		
		log.info("Fund_Transfer_05 - Step 04: Sendkey to 'Payees account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payeeaccount", "Acc123");
		
		log.info("Fund_Transfer_05 - Step 05: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message11"), "Characters are not allowed");
	}
	
	@Test(description = "Fund transfer with payee account number cannot have special character")
	public void Fund_Transfer_06() {
		log.info("Fund_Transfer_06 - Step 01: Refresh 'Fund Transfer' page");
		fundTransferPage.refreshCurrentPage(driver);
		
		log.info("Fund_Transfer_06 - Step 02: Sendkey to 'Payees account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payeeaccount", "123!@#");
		
		log.info("Fund_Transfer_06 - Step 03: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message11"), "Special characters are not allowed");
		
		log.info("Fund_Transfer_06 - Step 04: Sendkey to 'Payees account no' field");
		fundTransferPage.enterToTextboxByIDName(driver, "payeeaccount", "!@#");
		
		log.info("Fund_Transfer_06 - Step 05: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message11"), "Special characters are not allowed");
	}
	
	@Test(description = "Fund transfer with amount cannot be empty")
	public void Fund_Transfer_07() {
		log.info("Fund_Transfer_07 - Step 01: Open 'Fund Transfer' page");
		homePage.openMenuPage(driver, "Fund Transfer");
		fundTransferPage = PageGenerator.getFundTransferPage(driver);
		
		log.info("Fund_Transfer_07 - Step 02: Sendkey to 'Amount' field");
		fundTransferPage.enterToTextboxByIDName(driver, "ammount", "");
		
		log.info("Fund_Transfer_07 - Step 03: Click 'Tab'");
		fundTransferPage.sendkeyBoardToElement(driver, "ammount", Keys.TAB);
		
		log.info("Fund_Transfer_07 - Step 04: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message1"), "Amount field must not be blank");
	}
	
	@Test(description = "Fund transfer with amount must be numeric")
	public void Fund_Transfer_08() {
		log.info("Fund_Transfer_08 - Step 01: Refresh 'Fund Transfer' page");
		fundTransferPage.refreshCurrentPage(driver);
		
		log.info("Fund_Transfer_08 - Step 02: Sendkey to 'Amount' field");
		fundTransferPage.enterToTextboxByIDName(driver, "ammount", "1234Acc");
		
		log.info("Fund_Transfer_08 - Step 03: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message1"), "Characters are not allowed");
		
		log.info("Fund_Transfer_08 - Step 04: Sendkey to 'Amount' field");
		fundTransferPage.enterToTextboxByIDName(driver, "ammount", "Acc123");
		
		log.info("Fund_Transfer_08 - Step 05: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message1"), "Characters are not allowed");
	}
	
	@Test(description = "Fund transfer with amount cannot have special character")
	public void Fund_Transfer_09() {
		log.info("Fund_Transfer_09 - Step 01: Refresh 'Fund Transfer' page");
		fundTransferPage.refreshCurrentPage(driver);
		
		log.info("Fund_Transfer_09 - Step 02: Sendkey to 'Amount' field");
		fundTransferPage.enterToTextboxByIDName(driver, "ammount", "123!@#");
		
		log.info("Fund_Transfer_09 - Step 03: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message1"), "Special characters are not allowed");
		
		log.info("Fund_Transfer_09 - Step 04: Sendkey to 'Amount' field");
		fundTransferPage.enterToTextboxByIDName(driver, "ammount", "!@#");
		
		log.info("Fund_Transfer_09 - Step 05: Verify error message");
		verifyEquals(fundTransferPage.getErrorMessageByIDLabel(driver, "message1"), "Special characters are not allowed");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
