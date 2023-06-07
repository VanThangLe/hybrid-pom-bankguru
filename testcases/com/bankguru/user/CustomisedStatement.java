package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.CustomizedStatementPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class CustomisedStatement extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	CustomizedStatementPageObject customizedStatementPage;

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

	@Test(description = "Customized statement with account number cannot be empty")
	public void Customized_Statement_01() {
		log.info("Customized_Statement_01 - Step 01: Open 'Customized Statement' page");
		homePage.openMenuPage(driver, "Customized Statement");
		customizedStatementPage = PageGenerator.getCustomizedStatementPage(driver);
		
		log.info("Customized_Statement_01 - Step 02: Sendkey to 'Account No' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "accountno", "");
		
		log.info("Customized_Statement_01 - Step 03: Click 'Tab'");
		customizedStatementPage.sendkeyBoardToElement(driver, "accountno", Keys.TAB);
		
		log.info("Customized_Statement_01 - Step 04: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Account Number must not be blank");
	}

	@Test(description = "Customized statement with account number must be numeric")
	public void Customized_Statement_02() {
		log.info("Customized_Statement_02 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_02 - Step 02: Sendkey to 'Account No' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "accountno", "1234Acc");
		
		log.info("Customized_Statement_02 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
		
		log.info("Customized_Statement_02 - Step 04: Sendkey to 'Account No' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "accountno", "Acc123");
		
		log.info("Customized_Statement_02 - Step 05: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}

	@Test(description = "Customized statement with account number cannot have special character")
	public void Customized_Statement_03() {
		log.info("Customized_Statement_03 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_03 - Step 02: Sendkey to 'Account No' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "accountno", "123!@#");
		
		log.info("Customized_Statement_03 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
		
		log.info("Customized_Statement_03 - Step 04: Sendkey to 'Account No' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "accountno", "!@#");
		
		log.info("Customized_Statement_03 - Step 05: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Special characters are not allowed");
	}
	
	@Test(description = "Customized statement with account number cannot have blank space")
	public void Customized_Statement_04() {
		log.info("Customized_Statement_04 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_04 - Step 02: Sendkey to 'Account No' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "accountno", "123 12");
		
		log.info("Customized_Statement_04 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message2"), "Characters are not allowed");
	}

	@Test(description = "Customized statement with minimum transaction value must be numeric")
	public void Customized_Statement_05() {
		log.info("Customized_Statement_05 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_05 - Step 02: Sendkey to 'Minimum Transaction Value' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "amountlowerlimit", "1234Acc");
		
		log.info("Customized_Statement_05 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message12"), "Characters are not allowed");
		
		log.info("Customized_Statement_05 - Step 04: Sendkey to 'Minimum Transaction Value' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "amountlowerlimit", "Acc123");
		
		log.info("Customized_Statement_05 - Step 05: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message12"), "Characters are not allowed");
	}

	@Test(description = "Customized statement with minimum transaction value cannot have special character")
	public void Customized_Statement_06() {
		log.info("Customized_Statement_06 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_06 - Step 02: Sendkey to 'Minimum Transaction Value' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "amountlowerlimit", "123!@#");
		
		log.info("Customized_Statement_06 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message12"), "Special characters are not allowed");
		
		log.info("Customized_Statement_06 - Step 04: Sendkey to 'Minimum Transaction Value' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "amountlowerlimit", "!@#");
		
		log.info("Customized_Statement_06 - Step 05: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message12"), "Special characters are not allowed");
	}
	
	@Test(description = "Customized statement with minimum transaction value cannot have blank space")
	public void Customized_Statement_07() {
		log.info("Customized_Statement_07 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_07 - Step 02: Sendkey to 'Minimum Transaction Value' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "amountlowerlimit", "123 12");
		
		log.info("Customized_Statement_07 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message12"), "Characters are not allowed");
	}

	@Test(description = "Customized statement with number of transaction limit must be numeric")
	public void Customized_Statement_08() {
		log.info("Customized_Statement_08 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_08 - Step 02: Sendkey to 'Number of Transaction' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "numtransaction", "1234Acc");
		
		log.info("Customized_Statement_08 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message13"), "Characters are not allowed");
		
		log.info("Customized_Statement_08 - Step 04: Sendkey to 'Number of Transaction' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "numtransaction", "Acc123");
		
		log.info("Customized_Statement_08 - Step 05: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message13"), "Characters are not allowed");
	}

	@Test(description = "Customized statement with number of transaction limit cannot have special character")
	public void Customized_Statement_09() {
		log.info("Customized_Statement_09 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_09 - Step 02: Sendkey to 'Number of Transaction' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "numtransaction", "123!@#");
		
		log.info("Customized_Statement_09 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message13"), "Special characters are not allowed");
		
		log.info("Customized_Statement_09 - Step 04: Sendkey to 'Number of Transaction' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "numtransaction", "!@#");
		
		log.info("Customized_Statement_09 - Step 05: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message13"), "Special characters are not allowed");
	}
	
	@Test(description = "Customized statement with number of transaction limit cannot have blank space")
	public void Customized_Statement_10() {
		log.info("Customized_Statement_10 - Step 01: Refresh 'Customized Statement' page");
		customizedStatementPage.refreshCurrentPage(driver);
		
		log.info("Customized_Statement_10 - Step 02: Sendkey to 'Number of Transaction' field");
		customizedStatementPage.enterToTextboxByIDName(driver, "numtransaction", "123 12");
		
		log.info("Customized_Statement_10 - Step 03: Verify error message");
		verifyEquals(customizedStatementPage.getErrorMessageByIDLabel(driver, "message13"), "Characters are not allowed");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
