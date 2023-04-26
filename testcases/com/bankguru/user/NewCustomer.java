package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login;

import commons.BaseTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;

public class NewCustomer extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;

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
		
	}

	@Test(description = "Add new customer with name cannot be numeric")
	public void New_Customer_02() {
			
	}

	@Test(description = "Add new customer with name cannot have special characters")
	public void New_Customer_03() {
		
	}

	@Test(description = "Add new customer with name cannot have character as blank space")
	public void New_Customer_04() {
			
	}

	@Test(description = "Add new customer with address cannot be empty")
	public void New_Customer_05() {
		
	}

	@Test(description = "Add new customer with address cannot have first blank space")
	public void New_Customer_06() {
			
	}
	
	@Test(description = "Add new customer with city cannot be empty")
	public void New_Customer_07() {
		
	}

	@Test(description = "Add new customer with city cannot be numeric")
	public void New_Customer_08() {
			
	}
	
	@Test(description = "Add new customer with city cannot have special character")
	public void New_Customer_09() {
		
	}

	@Test(description = "Add new customer with city cannot have first blank space")
	public void New_Customer_10() {
			
	}
	
	@Test(description = "Add new customer with state cannot be empty")
	public void New_Customer_11() {
		
	}

	@Test(description = "Add new customer with state cannot be numeric")
	public void New_Customer_12() {
			
	}
	
	@Test(description = "Add new customer with state cannot have special character")
	public void New_Customer_13() {
		
	}

	@Test(description = "Add new customer with state cannot have first blank space")
	public void New_Customer_14() {
			
	}
	
	@Test(description = "Add new customer with pin must be numeric")
	public void New_Customer_15() {
		
	}

	@Test(description = "Add new customer with pin cannot be empty")
	public void New_Customer_16() {
			
	}
	
	@Test(description = "Add new customer with pin must have 6 digits")
	public void New_Customer_17() {
		
	}

	@Test(description = "Add new customer with pin cannot have special character")
	public void New_Customer_18() {
			
	}
	
	@Test(description = "Add new customer with pin cannot have first blank space")
	public void New_Customer_19() {
		
	}

	@Test(description = "Add new customer with pin cannot have blank space")
	public void New_Customer_20() {
			
	}
	
	@Test(description = "Add new customer with telephone cannot be empty")
	public void New_Customer_21() {
		
	}

	@Test(description = "Add new customer with telephone cannot have first character as blank space")
	public void New_Customer_22() {
			
	}
	
	@Test(description = "Add new customer with telephone cannot have spaces")
	public void New_Customer_23() {
		
	}

	@Test(description = "Add new customer with telephone cannot have special character")
	public void New_Customer_24() {
			
	}
	
	@Test(description = "Add new customer with email cannot be empty")
	public void New_Customer_25() {
		
	}

	@Test(description = "Add new customer with email must be in correct format")
	public void New_Customer_26() {
			
	}
	
	@Test(description = "Add new customer with email cannot have space")
	public void New_Customer_27() {
		
	}

	@Test(description = "Add new customer with check all Fields name (label) are as requirement")
	public void New_Customer_28() {
			
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
