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

public class EditCustomer extends BaseTest {
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

	@Test(description = "Edit customer with customer id cannot be empty")
	public void Edit_Customer_01() {
		
	}

	@Test(description = "Edit customer with customer id must be numeric")
	public void Edit_Customer_02() {
		
	}

	@Test(description = "Edit customer with customer id cannot have special character")
	public void Edit_Customer_03() {
		
	}
	
	@Test(description = "Edit customer with valid customer id")
	public void Edit_Customer_04() {
		
	}
	
	@Test(description = "Edit customer with address cannot be empty")
	public void Edit_Customer_05() {
		
	}
	
	@Test(description = "Edit customer with city cannot be empty")
	public void Edit_Customer_06() {
		
	}
	
	@Test(description = "Edit customer with city cannot be numeric")
	public void Edit_Customer_07() {
		
	}
	
	@Test(description = "Edit customer with city cannot have special character")
	public void Edit_Customer_08() {
		
	}
	
	@Test(description = "Edit customer with state cannot be empty")
	public void Edit_Customer_09() {
		
	}
	
	@Test(description = "Edit customer with state cannot be numeric")
	public void Edit_Customer_10() {
		
	}
	
	@Test(description = "Edit customer with state cannot have special character")
	public void Edit_Customer_11() {
		
	}
	
	@Test(description = "Edit customer with pin must be numeric")
	public void Edit_Customer_12() {
		
	}
	
	@Test(description = "Edit customer with pin must be empty")
	public void Edit_Customer_13() {
		
	}
	
	@Test(description = "Edit customer with pin must have 6 digits")
	public void Edit_Customer_14() {
		
	}
	
	@Test(description = "Edit customer with pin cannot have special character")
	public void Edit_Customer_15() {
		
	}
	
	@Test(description = "Edit customer with telephone cannot be empty")
	public void Edit_Customer_16() {
		
	}
	
	@Test(description = "Edit customer with telephone cannot have special character")
	public void Edit_Customer_17() {
		
	}
	
	@Test(description = "Edit customer with email cannot be empty")
	public void Edit_Customer_18() {
		
	}
	
	@Test(description = "Edit customer with invalid email")
	public void Edit_Customer_19() {
		
	}
	
	@Test(description = "Edit customer with valid email")
	public void Edit_Customer_20() {
		
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
