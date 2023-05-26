package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGenerator;

public class NewCustomer extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	public static String customerID;

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

	@Test(description = "Add new customer with name cannot be empty")
	public void New_Customer_01() {
		log.info("New_Customer_01 - Step 01: Open 'New Customer' page");
		homePage.openMenuPage(driver, "New Customer");
		newCustomerPage = PageGenerator.getNewCustomerPage(driver);
		
		log.info("New_Customer_01 - Step 02: Sendkey to 'Customer Name' field");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "");
		
		log.info("New_Customer_01 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "name", Keys.TAB);
		
		log.info("New_Customer_01 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message"), "Customer name must not be blank");
	}

	@Test(description = "Add new customer with name cannot be numeric")
	public void New_Customer_02() {
		log.info("New_Customer_02 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_02 - Step 02: Sendkey to 'Customer Name' field");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "1234");
		
		log.info("New_Customer_02 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message"), "Numbers are not allowed");
		
		log.info("New_Customer_02 - Step 04: Sendkey to 'Customer Name' field");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "name123");
		
		log.info("New_Customer_02 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message"), "Numbers are not allowed");
	}

	@Test(description = "Add new customer with name cannot have special characters")
	public void New_Customer_03() {
		log.info("New_Customer_03 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_03 - Step 02: Sendkey to 'Customer Name' field");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "name!@#");
		
		log.info("New_Customer_03 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message"), "Special characters are not allowed");
		
		log.info("New_Customer_03 - Step 04: Sendkey to 'Customer Name' field");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "!@#");
		
		log.info("New_Customer_03 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message"), "Special characters are not allowed");
	}

	@Test(description = "Add new customer with name cannot have character as blank space")
	public void New_Customer_04() {
		log.info("New_Customer_04 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_04 - Step 02: Sendkey to 'Customer Name' field");
		newCustomerPage.enterToTextboxByIDName(driver, "name", " Raul Garcia");
		
		log.info("New_Customer_04 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message"), "First character cannot be space");
	}

	@Test(description = "Add new customer with address cannot be empty")
	public void New_Customer_05() {
		log.info("New_Customer_05 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05 - Step 02: Sendkey to 'Address' field");
		newCustomerPage.enterToTextboxByIDName(driver, "addr", "");
		
		log.info("New_Customer_05 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "addr", Keys.TAB);
		
		log.info("New_Customer_05 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message3"), "Address Field must not be blank");
	}

	@Test(description = "Add new customer with address cannot have first blank space")
	public void New_Customer_06() {
		log.info("New_Customer_06 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06 - Step 02: Sendkey to 'Address' field");
		newCustomerPage.enterToTextboxByIDName(driver, "addr", " Vine St");
		
		log.info("New_Customer_06 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message3"), "First character cannot be space");
	}
	
	@Test(description = "Add new customer with city cannot be empty")
	public void New_Customer_07() {
		log.info("New_Customer_07 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_07 - Step 02: Sendkey to 'City' field");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "");
		
		log.info("New_Customer_07 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "city", Keys.TAB);
		
		log.info("New_Customer_07 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "City Field must not be blank");
	}

	@Test(description = "Add new customer with city cannot be numeric")
	public void New_Customer_08() {
		log.info("New_Customer_08 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_08 - Step 02: Sendkey to 'City' field");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "1234");
		
		log.info("New_Customer_08 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Numbers are not allowed");
		
		log.info("New_Customer_08 - Step 04: Sendkey to 'City' field");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "city123");
		
		log.info("New_Customer_08 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Numbers are not allowed");
	}
	
	@Test(description = "Add new customer with city cannot have special character")
	public void New_Customer_09() {
		log.info("New_Customer_09 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_09 - Step 02: Sendkey to 'City' field");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "City!@#");
		
		log.info("New_Customer_09 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Special characters are not allowed");
		
		log.info("New_Customer_09 - Step 04: Sendkey to 'City' field");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "!@#");
		
		log.info("New_Customer_09 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "Special characters are not allowed");
	}

	@Test(description = "Add new customer with city cannot have first blank space")
	public void New_Customer_10() {
		log.info("New_Customer_10 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_10 - Step 02: Sendkey to 'City' field");
		newCustomerPage.enterToTextboxByIDName(driver, "city", " Cincinnati");
		
		log.info("New_Customer_10 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message4"), "First character cannot be space");
	}
	
	@Test(description = "Add new customer with state cannot be empty")
	public void New_Customer_11() {
		log.info("New_Customer_11 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_11 - Step 02: Sendkey to 'State' field");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "");
		
		log.info("New_Customer_11 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "state", Keys.TAB);
		
		log.info("New_Customer_11 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "State must not be blank");
	}

	@Test(description = "Add new customer with state cannot be numeric")
	public void New_Customer_12() {
		log.info("New_Customer_12 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_12 - Step 02: Sendkey to 'State' field");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "1234");
		
		log.info("New_Customer_12 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Numbers are not allowed");
		
		log.info("New_Customer_12 - Step 04: Sendkey to 'State' field");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "state123");
		
		log.info("New_Customer_12 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Numbers are not allowed");	
	}
	
	@Test(description = "Add new customer with state cannot have special character")
	public void New_Customer_13() {
		log.info("New_Customer_13 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_13 - Step 02: Sendkey to 'State' field");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "State!@#");
		
		log.info("New_Customer_13 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Special characters are not allowed");
		
		log.info("New_Customer_13 - Step 04: Sendkey to 'State' field");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "!@#");
		
		log.info("New_Customer_13 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "Special characters are not allowed");
	}

	@Test(description = "Add new customer with state cannot have first blank space")
	public void New_Customer_14() {
		log.info("New_Customer_14 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_14 - Step 02: Sendkey to 'State' field");
		newCustomerPage.enterToTextboxByIDName(driver, "state", " Ohio");
		
		log.info("New_Customer_14 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message5"), "First character cannot be space");
	}
	
	@Test(description = "Add new customer with pin must be numeric")
	public void New_Customer_15() {
		log.info("New_Customer_15 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_15 - Step 02: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "1234");
		
		log.info("New_Customer_15 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Characters are not allowed");
		
		log.info("New_Customer_15 - Step 04: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "1234PIN");
		
		log.info("New_Customer_15 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Characters are not allowed");
	}

	@Test(description = "Add new customer with pin cannot be empty")
	public void New_Customer_16() {
		log.info("New_Customer_16 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_16 - Step 02: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "");
		
		log.info("New_Customer_16 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "pinno", Keys.TAB);
		
		log.info("New_Customer_16 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "PIN code must not be blank");
	}
	
	@Test(description = "Add new customer with pin must have 6 digits")
	public void New_Customer_17() {
		log.info("New_Customer_17 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_17 - Step 02: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "1234");
		
		log.info("New_Customer_17 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "PIN Code must have 6 Digits");
	}

	@Test(description = "Add new customer with pin cannot have special character")
	public void New_Customer_18() {
		log.info("New_Customer_18 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_18 - Step 02: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "!@#");
		
		log.info("New_Customer_18 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Special characters are not allowed");
		
		log.info("New_Customer_18 - Step 04: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "123!@#");
		
		log.info("New_Customer_18 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Special characters are not allowed");
	}
	
	@Test(description = "Add new customer with pin cannot have first blank space")
	public void New_Customer_19() {
		log.info("New_Customer_19 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_19 - Step 02: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", " 45874");
		
		log.info("New_Customer_19 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "First character cannot be space");
	}

	@Test(description = "Add new customer with pin cannot have blank space")
	public void New_Customer_20() {
		log.info("New_Customer_20 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_20 - Step 02: Sendkey to 'PIN' field");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "45 874");
		
		log.info("New_Customer_20 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message6"), "Characters are not allowed");
	}
	
	@Test(description = "Add new customer with telephone cannot be empty")
	public void New_Customer_21() {
		log.info("New_Customer_21 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_21 - Step 02: Sendkey to 'Mobile Number' field");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "");
		
		log.info("New_Customer_21 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "telephoneno", Keys.TAB);
		
		log.info("New_Customer_21 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Mobile no must not be blank");
	}

	@Test(description = "Add new customer with telephone cannot have first character as blank space")
	public void New_Customer_22() {
		log.info("New_Customer_22 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_22 - Step 02: Sendkey to 'Mobile Number' field");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", " 09876543210000");
		
		log.info("New_Customer_22 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "First character cannot be space");
	}
	
	@Test(description = "Add new customer with telephone cannot have spaces")
	public void New_Customer_23() {
		log.info("New_Customer_23 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_23 - Step 02: Sendkey to 'Mobile Number' field");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "0987654321 0000");
		
		log.info("New_Customer_23 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Characters are not allowed");
	}

	@Test(description = "Add new customer with telephone cannot have special character")
	public void New_Customer_24() {
		log.info("New_Customer_24 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_24 - Step 02: Sendkey to 'Mobile Number' field");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "886636!@12");
		
		log.info("New_Customer_24 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Special characters are not allowed");
		
		log.info("New_Customer_24 - Step 04: Sendkey to 'Mobile Number' field");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "!@88662682");
		
		log.info("New_Customer_24 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Special characters are not allowed");
		
		log.info("New_Customer_24 - Step 04: Sendkey to 'Mobile Number' field");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "88663682!@");
		
		log.info("New_Customer_24 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message7"), "Special characters are not allowed");
	}
	
	@Test(description = "Add new customer with email cannot be empty")
	public void New_Customer_25() {
		log.info("New_Customer_25 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_25 - Step 02: Sendkey to 'E-mail' field");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "");
		
		log.info("New_Customer_25 - Step 03: Click 'Tab'");
		newCustomerPage.sendkeyBoardToElement(driver, "emailid", Keys.TAB);
		
		log.info("New_Customer_25 - Step 04: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID must not be blank");
	}

	@Test(description = "Add new customer with email must be in correct format")
	public void New_Customer_26() {
		log.info("New_Customer_26 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_26 - Step 02: Sendkey to 'E-mail' field");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99@gmail");
		
		log.info("New_Customer_26 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("New_Customer_26 - Step 04: Sendkey to 'E-mail' field");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99");
		
		log.info("New_Customer_26 - Step 05: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("New_Customer_26 - Step 06: Sendkey to 'E-mail' field");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "Guru99@");
		
		log.info("New_Customer_26 - Step 07: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("New_Customer_26 - Step 08: Sendkey to 'E-mail' field");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99@gmail.");
		
		log.info("New_Customer_26 - Step 09: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
		
		log.info("New_Customer_26 - Step 10: Sendkey to 'E-mail' field");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "guru99gmail.com");
		
		log.info("New_Customer_26 - Step 11: Verify error message");
		verifyEquals(newCustomerPage.getErrorMessageByIDLabel(driver, "message9"), "Email-ID is not valid");
	}
	 
	@Test(description = "Add new customer with check all Fields name (label) are as requirement")
	public void New_Customer_27() {
		log.info("New_Customer_27 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
	 
		log.info("New_Customer_27 - Step 02: Click to 'Submit' button");
		newCustomerPage.clickToButtonByIDName(driver, "sub");
		
		log.info("New_Customer_27 - Step 03: Verify error message");
		verifyEquals(newCustomerPage.getTextInAlert(driver), "please fill all fields");
	}
	
	@Test(description = "Add new customer success")
	public void New_Customer_28() {
		log.info("New_Customer_28 - Step 01: Refresh 'New Customer' page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_28 - Step 02: Sendkey to all fields");
		newCustomerPage.enterToTextboxByIDName(driver, "name", "Thang");
		newCustomerPage.clickToCheckboxByNameValue(driver, "rad1", "m");
		newCustomerPage.enterToTextboxByIDName(driver, "dob", "07/07/1996");
		newCustomerPage.enterToTextboxByIDName(driver, "addr", "HaNoi");
		newCustomerPage.enterToTextboxByIDName(driver, "city", "HaNoi");
		newCustomerPage.enterToTextboxByIDName(driver, "state", "HaNoi");
		newCustomerPage.enterToTextboxByIDName(driver, "pinno", "100000");
		newCustomerPage.enterToTextboxByIDName(driver, "telephoneno", "0987654321");
		newCustomerPage.enterToTextboxByIDName(driver, "emailid", "thang.le.fc@gmail.com");
		newCustomerPage.enterToTextboxByIDName(driver, "password", "12345678");
		
		log.info("New_Customer_28 - Step 03: Click to 'Submit' button");
		newCustomerPage.clickToButtonByIDName(driver, "sub");
		
		log.info("New_Customer_28 - Step 04: Verify data value");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Customer Name"), "Thang");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Gender"), "male");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Birthdate"), "1996-07-07");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Address"), "HaNoi");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "City"), "HaNoi");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "State"), "HaNoi");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Pin"), "100000");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Mobile No."), "0987654321");
		verifyEquals(newCustomerPage.getTextByIDName(driver, "Email"), "thang.le.fc@gmail.com");
		customerID = newCustomerPage.getTextByIDName(driver, "Customer ID");
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
