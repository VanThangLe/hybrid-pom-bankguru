package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class EditCustomer extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	EditCustomerPageObject editCustomerPage;

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

	@Test(description = "Edit customer with customer id cannot be empty")
	public void Edit_Customer_01() {
		log.info("Edit_Customer_01 - Step 01: Open 'Edit Customer' page");
		homePage.openMenuPage(driver, "Edit Customer");
		editCustomerPage = PageGenerator.getEditCustomerPage(driver);
		
		log.info("Edit_Customer_01 - Step 02: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", "");
		
		log.info("Edit_Customer_01 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "cusid", Keys.TAB);
		
		log.info("Edit_Customer_01 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Customer ID is required");
	}

	@Test(description = "Edit customer with customer id must be numeric")
	public void Edit_Customer_02() {
		log.info("Edit_Customer_02 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		
		log.info("Edit_Customer_02 - Step 02: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", "1234Acc");
		
		log.info("Edit_Customer_02 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
		
		log.info("Edit_Customer_02 - Step 04: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", "Acc123");
		
		log.info("Edit_Customer_02 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Characters are not allowed");
	}

	@Test(description = "Edit customer with customer id cannot have special character")
	public void Edit_Customer_03() {
		log.info("Edit_Customer_03 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		
		log.info("Edit_Customer_03 - Step 02: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", "123!@#");
		
		log.info("Edit_Customer_03 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Special characters are not allowed");
		
		log.info("Edit_Customer_03 - Step 04: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", "!@#");
		
		log.info("Edit_Customer_03 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message14"), "Special characters are not allowed");
	}
	
	@Test(description = "Edit customer with valid customer id")
	public void Edit_Customer_04() {
		log.info("Edit_Customer_04 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		
		log.info("Edit_Customer_04 - Step 02: Sendkey to 'Customer ID' field");
		editCustomerPage.enterToTextboxByIDName(driver, "cusid", "55143");
		
		log.info("Edit_Customer_04 - Step 03: Click to 'Submit' button");
		editCustomerPage.clickToButtonByIDName(driver, "AccSubmit");
		
		log.info("Edit_Customer_04 - Step 04: Verify error message");
		verifyTrue(editCustomerPage.isEditCustomerPageDisplayed(driver, "Edit Customer"));
	}
	
	@Test(description = "Edit customer with address cannot be empty")
	public void Edit_Customer_05() {
		log.info("Edit_Customer_05 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_05 - Step 02: Sendkey to 'Address' field");
		editCustomerPage.enterToTextboxByIDName(driver, "addr", "");
		
		log.info("Edit_Customer_05 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "addr", Keys.TAB);
		
		log.info("Edit_Customer_05 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message3"), "Address Field must not be blank");
	}
	
	@Test(description = "Edit customer with city cannot be empty")
	public void Edit_Customer_06() {
		log.info("Edit_Customer_06 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_06 - Step 02: Sendkey to 'City' field");
		editCustomerPage.enterToTextboxByIDName(driver, "city", "");
		
		log.info("Edit_Customer_06 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "city", Keys.TAB);
		
		log.info("Edit_Customer_06 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "City Field must not be blank");
	}
	
	@Test(description = "Edit customer with city cannot be numeric")
	public void Edit_Customer_07() {
		log.info("Edit_Customer_07 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_07 - Step 02: Sendkey to 'City' field");
		editCustomerPage.enterToTextboxByIDName(driver, "city", "1234");
		
		log.info("Edit_Customer_07 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Numbers are not allowed");
		
		log.info("Edit_Customer_07 - Step 04: Sendkey to 'City' field");
		editCustomerPage.enterToTextboxByIDName(driver, "city", "city123");
		
		log.info("Edit_Customer_07 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Numbers are not allowed");
	}
	
	@Test(description = "Edit customer with city cannot have special character")
	public void Edit_Customer_08() {
		log.info("Edit_Customer_08 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_08 - Step 02: Sendkey to 'City' field");
		editCustomerPage.enterToTextboxByIDName(driver, "city", "City!@#");
		
		log.info("Edit_Customer_08 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Special characters are not allowed");
		
		log.info("Edit_Customer_08 - Step 04: Sendkey to 'City' field");
		editCustomerPage.enterToTextboxByIDName(driver, "city", "!@#");
		
		log.info("Edit_Customer_08 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Special characters are not allowed");
	}
	
	@Test(description = "Edit customer with state cannot be empty")
	public void Edit_Customer_09() {
		log.info("Edit_Customer_09 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_09 - Step 02: Sendkey to 'State' field");
		editCustomerPage.enterToTextboxByIDName(driver, "state", "");
		
		log.info("Edit_Customer_09 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "state", Keys.TAB);
		
		log.info("Edit_Customer_09 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "State must not be blank");
	}
	
	@Test(description = "Edit customer with state cannot be numeric")
	public void Edit_Customer_10() {
		log.info("Edit_Customer_10 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_10 - Step 02: Sendkey to 'State' field");
		editCustomerPage.enterToTextboxByIDName(driver, "state", "1234");
		
		log.info("Edit_Customer_10 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Numbers are not allowed");
		
		log.info("Edit_Customer_10 - Step 04: Sendkey to 'State' field");
		editCustomerPage.enterToTextboxByIDName(driver, "state", "state123");
		
		log.info("Edit_Customer_10 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Numbers are not allowed");
	}
	
	@Test(description = "Edit customer with state cannot have special character")
	public void Edit_Customer_11() {
		log.info("Edit_Customer_11 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_11 - Step 02: Sendkey to 'State' field");
		editCustomerPage.enterToTextboxByIDName(driver, "state", "State!@#");
		
		log.info("Edit_Customer_11 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Special characters are not allowed");
		
		log.info("Edit_Customer_11 - Step 04: Sendkey to 'State' field");
		editCustomerPage.enterToTextboxByIDName(driver, "state", "!@#");
		
		log.info("Edit_Customer_11 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Special characters are not allowed");
	}
	
	@Test(description = "Edit customer with pin must be numeric")
	public void Edit_Customer_12() {
		log.info("Edit_Customer_12 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_12 - Step 02: Sendkey to 'PIN' field");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "1234");
		
		log.info("Edit_Customer_12 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Characters are not allowed");
		
		log.info("Edit_Customer_12 - Step 04: Sendkey to 'PIN' field");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "1234PIN");
		
		log.info("Edit_Customer_12 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Characters are not allowed");
	}
	
	@Test(description = "Edit customer with pin must be empty")
	public void Edit_Customer_13() {
		log.info("Edit_Customer_13 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_13 - Step 02: Sendkey to 'PIN' field");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "");
		
		log.info("Edit_Customer_13 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "pinno", Keys.TAB);
		
		log.info("Edit_Customer_13 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "PIN code must not be blank");
	}
	
	@Test(description = "Edit customer with pin must have 6 digits")
	public void Edit_Customer_14() {
		log.info("Edit_Customer_14 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_14 - Step 02: Sendkey to 'PIN' field");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "1234");
		
		log.info("Edit_Customer_14 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "PIN Code must have 6 Digits");
	}
	
	@Test(description = "Edit customer with pin cannot have special character")
	public void Edit_Customer_15() {
		log.info("Edit_Customer_15 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_15 - Step 02: Sendkey to 'PIN' field");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "!@#");
		
		log.info("Edit_Customer_15 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Special characters are not allowed");
		
		log.info("Edit_Customer_15 - Step 04: Sendkey to 'PIN' field");
		editCustomerPage.enterToTextboxByIDName(driver, "pinno", "123!@#");
		
		log.info("Edit_Customer_15 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Special characters are not allowed");
	}
	
	@Test(description = "Edit customer with telephone cannot be empty")
	public void Edit_Customer_16() {
		log.info("Edit_Customer_16 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_16 - Step 02: Sendkey to 'Mobile Number' field");
		editCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "");
		
		log.info("Edit_Customer_16 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "telephoneno", Keys.TAB);
		
		log.info("Edit_Customer_16 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Mobile no must not be blank");
	}
	
	@Test(description = "Edit customer with telephone cannot have special character")
	public void Edit_Customer_17() {
		log.info("Edit_Customer_17 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_17 - Step 02: Sendkey to 'Mobile Number' field");
		editCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "886636!@12");
		
		log.info("Edit_Customer_17 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Special characters are not allowed");
		
		log.info("Edit_Customer_17 - Step 04: Sendkey to 'Mobile Number' field");
		editCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "!@88662682");
		
		log.info("Edit_Customer_17 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Special characters are not allowed");
		
		log.info("Edit_Customer_17 - Step 04: Sendkey to 'Mobile Number' field");
		editCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "88663682!@");
		
		log.info("Edit_Customer_17 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Special characters are not allowed");
	}
	
	@Test(description = "Edit customer with email cannot be empty")
	public void Edit_Customer_18() {
		log.info("Edit_Customer_18 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_18 - Step 02: Sendkey to 'E-mail' field");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "");
		
		log.info("Edit_Customer_18 - Step 03: Click 'Tab'");
		editCustomerPage.sendkeyBoardToElement(driver, "emailid", Keys.TAB);
		
		log.info("Edit_Customer_18 - Step 04: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID must not be blank");
	}
	
	@Test(description = "Edit customer with invalid email")
	public void Edit_Customer_19() {
		log.info("Edit_Customer_19 - Step 01: Refresh 'Edit Customer' page");
		editCustomerPage.refreshCurrentPage(driver);
		editCustomerPage.acceptAlert(driver);
		
		log.info("Edit_Customer_19 - Step 02: Sendkey to 'E-mail' field");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99@gmail");
		
		log.info("Edit_Customer_19 - Step 03: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("Edit_Customer_19 - Step 04: Sendkey to 'E-mail' field");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99");
		
		log.info("Edit_Customer_19 - Step 05: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("Edit_Customer_19 - Step 06: Sendkey to 'E-mail' field");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "Guru99@");
		
		log.info("Edit_Customer_19 - Step 07: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("Edit_Customer_19 - Step 08: Sendkey to 'E-mail' field");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99@gmail.");
		
		log.info("Edit_Customer_19 - Step 09: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("Edit_Customer_19 - Step 10: Sendkey to 'E-mail' field");
		editCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99gmail.com");
		
		log.info("Edit_Customer_19 - Step 11: Verify error message");
		verifyEquals(editCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
